package uz.quar.databindingexample;

public interface LoginListener {
    void onStarted();
    void onSuccess();
    void onFailure(String message);

}
