package ru.surfstudio.retrofitsample;


import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import ru.surfstudio.retrofitsample.retrofit.CustomErrorHandler;
import ru.surfstudio.retrofitsample.retrofit.Requests;

public class App extends android.app.Application{

    private Requests.FooService fooService;
    private RestAdapter restAdapter;

    private static App appInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(Requests.ROOT_CATALOG).setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("Accept-Language", "ru, en");
                    }
                })
                .setErrorHandler(new CustomErrorHandler(this))
                .build();
    }

    public Requests.FooService getFooService() {
        if (fooService == null) {
            fooService = restAdapter.create(Requests.FooService.class);
        }
        return fooService;
    }

    public static App getInstance() {
        return appInstance;
    }
}
