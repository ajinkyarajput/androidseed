package structure.project.ajinkya.service;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import structure.project.ajinkya.apis.ServerApi;
import structure.project.ajinkya.common.LogMessage;
import structure.project.ajinkya.framework.Injector;
import structure.project.ajinkya.pojo.UserDetail;

/**
 * Created by Ajinkya on 6/4/17.
 */
public class UserInfoService  implements Callback <UserDetail>{

    private static final String TAG = UserInfoService.class.getName();
    @Inject
    ServerApi serverApi;

    ServerCallback serverCallback;

    public UserInfoService()  {
        Injector.INSTANCE.getApplicationComponent().inject(this);
    }


    public void getUserInfo(UserInfoService.ServerCallback callback){
        LogMessage.logMessage(TAG,"getUserInfo");
        this.serverCallback = callback;
        this.serverApi.userDetails(this);
    }
    @Override
    public void success(UserDetail userDetail, Response response) {
        LogMessage.logMessage(TAG, "success:");

        if (this.serverCallback != null) {
            this.serverCallback.success(userDetail, response);
        }
    }

    @Override
    public void failure(RetrofitError error) {
        LogMessage.logMessage(TAG, "failure:" + error);

        if (this.serverCallback != null) {
            this.serverCallback.failure(error);
        }
    }

    public interface ServerCallback{

        void failure(RetrofitError retrofitError);

        void success(UserDetail userDetail, Response response);

    }
}
