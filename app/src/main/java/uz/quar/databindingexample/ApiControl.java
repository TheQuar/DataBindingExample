package uz.quar.databindingexample;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiControl {
    @FormUrlEncoded
    @POST("quar/login.php")
    Call<Boolean> login(@Field("user_name") String name, @Field("user_password") String password);

}
