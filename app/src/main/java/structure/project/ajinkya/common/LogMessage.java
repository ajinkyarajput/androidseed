package structure.project.ajinkya.common;

import android.util.Log;

/**
 * Created by Ajinkya on 6/4/17.
 */

public class LogMessage
{
    public static void logMessage(String methodName, String description)
    {
        Log.i("Vantage", methodName+ "--"+description);
    }
    public static void logError(String methodName, String description)
    {
        Log.e("Vantage-Exception", methodName+ "--" + description);
    }
    public static void logError(String methodName,String description, Exception ex)
    {
        Log.e("Vantage-Exception", methodName +"--"+ description ,ex);
    }
    public static void logError(String methodName,String description, Throwable ex)
    {
        Log.e("Vantage-Exception", methodName +"--"+ description ,ex);
    }


}
