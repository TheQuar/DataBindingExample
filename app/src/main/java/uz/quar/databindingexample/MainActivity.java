package uz.quar.databindingexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.widget.Toast;

import uz.quar.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LoginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginData(viewModel);

        viewModel.loginListener = this;
    }


    @Override
    public void onStarted() {
        message("started");
    }

    @Override
    public void onSuccess() {
        message("success");
    }

    @Override
    public void onFailure(String message) {
        message(message);
    }

    private void message(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}