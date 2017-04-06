package structure.project.ajinkya.apis;

import retrofit.Callback;
import retrofit.http.GET;
import structure.project.ajinkya.pojo.UserDetail;

/**
 * Created by Ajinkya on 6/4/17.
 */
public interface ServerApi {

    @GET("/userDetails")
    void userDetails(Callback<UserDetail> c);
}
