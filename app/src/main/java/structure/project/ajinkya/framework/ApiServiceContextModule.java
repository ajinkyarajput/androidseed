package structure.project.ajinkya.framework;

import android.util.Base64;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import structure.project.ajinkya.apis.ServerApi;

/**
 * Created by Ajinkya on 6/4/17.
 */


@Module //a module could also include other modules
public class ApiServiceContextModule {
    private final BaseApplication application;
    public static String TAG = ApiServiceContextModule.class.getName();

    public ApiServiceContextModule(BaseApplication application) {
        this.application = application;
    }


    public static String encodeCredentialsForRetroBasicAuthorization() {
        final String userAndPassword = "admin" + ":" + "admin123!";
        return "Basic " + Base64.encodeToString(userAndPassword.getBytes(), Base64.NO_WRAP);
    }

    @Provides
    RestAdapter getONotesRestAdapter() {
        String BASE_URL = "http://192.168.1.16:80";
        RestAdapter.Builder localBuilder = new RestAdapter.Builder();
        //   localBuilder.setErrorHandler(paramRestErrorHandler).setProfiler(new RetrofitProfiler()).setRequestInterceptor(paramRestAdapterRequestInterceptor).setConverter(new JacksonConverter(paramObjectMapper));
        localBuilder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Content-Type", "application/json");
               // request.addHeader("Authorization", encodeCredentialsForRetroBasicAuthorization());
            }
        });
        localBuilder.setEndpoint(BASE_URL);
        localBuilder.setLogLevel(RestAdapter.LogLevel.NONE);
        localBuilder.setLog(RestAdapter.Log.NONE);
        return localBuilder.build();
    }

    @Provides
    public ServerApi getServerApi(){
        return getONotesRestAdapter().create(ServerApi.class);
    }

   
}
