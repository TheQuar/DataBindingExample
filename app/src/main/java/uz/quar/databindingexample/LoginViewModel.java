package uz.quar.databindingexample;

import android.view.View;

import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    public String username;
    public String password;

    public LoginListener loginListener;

    public void onClickLoginButton(View v) {
        loginListener.onStarted();
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            loginListener.onFailure("username yoki parol yozilmadi");
            return;
        }

        ResetAdapter.create().login(username, password).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    if (response.body())
                        loginListener.onSuccess();
                    else
                        loginListener.onFailure("Bunday foydalanuvchi mavjud emas");

                } else
                    loginListener.onFailure("Ma'lumot yuborishda xatolik");
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                loginListener.onFailure(t.getMessage());
            }
        });


    }
}
