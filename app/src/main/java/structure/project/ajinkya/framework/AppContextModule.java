package structure.project.ajinkya.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import dagger.Module;
import dagger.Provides;
import structure.project.ajinkya.service.UserInfoService;

/**
 * Created by Ajinkya on 6/4/17.
 */


@Module //a module could also include other modules
public class AppContextModule {
    private final BaseApplication application;
    public static String TAG = "SSearch-AppContextModule";

    public AppContextModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    public BaseApplication application() {
        return this.application;
    }

    @Provides
    public Context applicationContext() {
        return this.application;
    }

    @Provides
    public TelephonyManager provideTelephoneManager(Context context) {
        Log.i(TAG, "in provideTelephoneManager ");
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }


    @Provides
    public SharedPreferences getSharedPreference(Context context) {
        Log.i(TAG, "in getSharedPreference ");
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    public LocationManager locationService(Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }


    @Provides
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Provides
    UserInfoService userInfoService(){return  new UserInfoService();}

}
