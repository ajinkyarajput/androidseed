package structure.project.ajinkya.framework;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import structure.project.ajinkya.common.LogMessage;

/**
 * Created by Ajinkya on 6/4/17.
 */


public class BaseApplication
        extends MultiDexApplication implements Thread.UncaughtExceptionHandler{

    public static  String TAG="BaseApplication";
    private static BaseApplication instance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.INSTANCE.initializeApplicationComponent(this);
        Thread.setDefaultUncaughtExceptionHandler(this);
        LogMessage.logMessage(TAG,"onCreate");
    }


    public BaseApplication()
    {
        instance = this;
    }

    public static Context getInstance()
    {
        if (null == instance)
        {
            instance = new BaseApplication();
        }

        return instance;
    }


    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        LogMessage.logError(TAG, "uncaughtException",ex);
        System.exit(0);
    }
}
