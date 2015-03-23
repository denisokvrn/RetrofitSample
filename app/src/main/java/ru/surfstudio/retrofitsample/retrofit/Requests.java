package ru.surfstudio.retrofitsample.retrofit;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;
import ru.surfstudio.retrofitsample.data.BaseResponse;
import ru.surfstudio.retrofitsample.data.Foo;

public class Requests {

    public static final String ROOT_CATALOG = "http://api.example.com";

    public interface FooService {

        @POST("/rest/1.0/update/{fooId}")
        void postFooObject(
                @Path("fooId") String id,
                @Body Foo fooObj,
                Callback<BaseResponse> callback);
    }

}