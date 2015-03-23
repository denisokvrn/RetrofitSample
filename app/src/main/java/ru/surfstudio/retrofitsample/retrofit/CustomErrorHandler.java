package ru.surfstudio.retrofitsample.retrofit;

import android.content.Context;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CustomErrorHandler implements ErrorHandler {

    private Context context;

    public CustomErrorHandler(Context context) {
        this.context = context;
    }

    @Override
    public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (r != null && r.getStatus() == 401) {
            //handle 401 error
        }
        return cause;
    }
}