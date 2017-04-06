package structure.project.ajinkya.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.Set;

/**
 * Created by Ajinkya on 6/4/17.
 */

public class LocalMemory {

    public static boolean getBooleanValue(Context paramContext, String paramString, boolean paramBoolean) {
        if ((paramContext != null) && (paramString != null)) {
            return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, paramBoolean);
        }
        return false;
    }

    public static int getIntValue(Context paramContext, String paramString) {
        int j = Integer.MIN_VALUE;
        int i = j;
        if (paramContext != null) {
            i = j;
            if (paramString != null) {
                i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString, 0);
            }
        }
        return i;
    }
    public static float getFloatValue(Context paramContext, String paramString) {
        float j = Float.MIN_VALUE;
        float i = j;
        if (paramContext != null) {
            i = j;
            if (paramString != null) {
                i = PreferenceManager.getDefaultSharedPreferences(paramContext).getFloat(paramString, 0);
            }
        }
        return i;
    }

    public static long getLongValue(Context paramContext, String paramString) {
        long l2 = Long.MIN_VALUE;
        long l1 = l2;
        if (paramContext != null) {
            l1 = l2;
            if (paramString != null) {
                l1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString, Long.MIN_VALUE);
            }
        }
        return l1;
    }

    public static String getStringValue(Context paramContext,String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramContext != null) {
            localObject1 = localObject2;
            if (paramString != null) {
                localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, null);
            }
        }
        return (String) localObject1;
    }

    public static void putBooleanValue(Context paramContext, String paramString, boolean paramBoolean) {
        if ((paramContext != null) && (paramString != null)) {
           Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
            editor.putBoolean(paramString, paramBoolean);
            editor.commit();
        }
    }

    public static void putFloatValue(Context paramContext, String paramString, float paramFloat) {
        if ((paramContext != null) && (paramString != null)) {
            Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
            editor.putFloat(paramString, paramFloat);
            editor.commit();
        }
    }

    public static void putIntValue(Context paramContext, String paramString, int paramInt) {
        if ((paramContext != null) && (paramString != null)) {
            Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
            editor.putInt(paramString, paramInt);
            editor.apply();
        }
    }

    public static void putLongValue(Context paramContext, String paramString, long paramLong) {
        if ((paramContext != null) && (paramString != null)) {
            Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
            editor.putLong(paramString, paramLong);
            editor.apply();
        }
    }


    public static void putStringSetValue(Context paramContext, String paramString, Set<String> paramSet) {
        if ((paramContext != null) && (paramString != null)) {
            Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
            editor.putStringSet(paramString, paramSet);
            editor.commit();
        }
    }

    public static void putStringValue(Context paramContext,String paramString1, String paramString2) {
        if ((paramContext != null) && (paramString1 != null)) {
            Editor editor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
            editor.putString(paramString1, paramString2);
            editor.commit();
        }
    }

    public static void clearLocalMemory(Context paramContext)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
        preferences.edit().clear().commit();

    }
}
