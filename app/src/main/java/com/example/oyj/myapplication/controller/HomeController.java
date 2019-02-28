package com.example.oyj.myapplication.controller;
import com.example.oyj.myapplication.view.HomeView;
import com.example.oyj.myapplication.activity.listener.HomeControllerListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
public class HomeController implements OnClickListener{
    private final String TAG = "Home controller";
    private HomeView homeView;
    private HomeControllerListener listener;

    public HomeController(HomeView homeView, HomeControllerListener listener) {
        this.homeView = homeView;
        this.listener = listener;
    }

    public void onClick(View v) {
        Log.i(TAG, "onClick");
        this.listener.onClickHomeSuccess();

    }
}
