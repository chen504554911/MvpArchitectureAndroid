package com.ztesoft.mvparchitectureandroid.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


/**
 * @author chenyx
 * @date create 2017/9/11
 * @description
 */
public class ZteSoftToast {
    private static Toast toast;
    private static Toast toastcenter;

    public static void show(Context context, String string) {

        try {
            if (string != null & string.trim().equals(""))
                return;
            if (toast == null) {
                toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
            }
            toast.setText(string);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(Context context, int stringId) {

        try {
            if (stringId == 0)
                return;
            String string =  context.getString(stringId);
            if (toast == null) {
                toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
            }
            toast.setText(string);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showCenter(Context context, String string) {
        if (string.trim().equals(""))
            return;
        try {
            if (toastcenter == null) {
                toastcenter = Toast.makeText(context, string, Toast.LENGTH_SHORT);
                toastcenter.setGravity(Gravity.CENTER, 0, -50);
            }
            toastcenter.setText(string);
            toastcenter.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
