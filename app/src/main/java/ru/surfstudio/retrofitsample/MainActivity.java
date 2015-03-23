package ru.surfstudio.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import ru.surfstudio.retrofitsample.data.BaseResponse;
import ru.surfstudio.retrofitsample.data.Foo;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Foo f = new Foo();
        f.setId("qwe123");
        f.setContent("test");

        App.getInstance().getFooService().postFooObject(f.getId(), f, new Callback<BaseResponse>() {
            @Override
            public void success(BaseResponse baseResponse, Response response) {
                //all good
                Log.d("on success", baseResponse.getJsonResponse());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //handle error
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
