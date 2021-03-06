package com.candy.readmessage;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by candy on 2015/3/28.
 */
public class AdminReceiver extends DeviceAdminReceiver {

   public static ArrayList<PasswordAttemp> listenlists = new ArrayList<>();

    @Override
    public void onPasswordSucceeded(Context context, Intent intent) {
        super.onPasswordSucceeded(context, intent);
        Toast.makeText(context,"解锁",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPasswordFailed(Context context, Intent intent) {

        super.onPasswordFailed(context, intent);
/*        DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
        int s = dpm.getCurrentFailedPasswordAttempts();
        Log.d("xxxxxx", "attemps"+s);
        dpm=null;*/
        Toast.makeText(context,"解锁错误",Toast.LENGTH_SHORT).show();
        for(int i = 0;i<listenlists.size();i++){
            listenlists.get(i).OnStateChanged(false);
        }
    }

    public void addListener(PasswordAttemp listener){

        listenlists.add(listener);

    }

    public interface PasswordAttemp{
        public void OnStateChanged(boolean sss);
    }
}
