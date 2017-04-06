package structure.project.ajinkya.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import retrofit.RetrofitError;
import retrofit.client.Response;
import structure.project.ajinkya.R;
import structure.project.ajinkya.common.LogMessage;
import structure.project.ajinkya.database.SQLiteBase;
import structure.project.ajinkya.framework.Injector;
import structure.project.ajinkya.pojo.UserDetail;
import structure.project.ajinkya.service.UserInfoService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UserInfoService.ServerCallback {

    private static final String TAG = MainActivity.class.getName();
    Button testRestCall;
    @Inject
    UserInfoService userInfoService;

    @Inject
    Context context;

    SQLiteBase sqLiteBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testRestCall = (Button) findViewById(R.id.btnTestRestService);
        if(testRestCall!=null)
            testRestCall.setOnClickListener(this);

        Injector.INSTANCE.getApplicationComponent().inject(this);
        sqLiteBase = new SQLiteBase(context);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnTestRestService){
            LogMessage.logMessage(TAG,"onClick");
            userInfoService.getUserInfo(this);
        }
    }

    @Override
    public void failure(RetrofitError retrofitError) {

    }

    @Override
    public void success(UserDetail userDetail, Response response) {
        LogMessage.logMessage(TAG,"success"+userDetail.getName());

    }
}
