package com.example.user.powerreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST = "com.example.android.powerreceiver.ACTION_CUSTOM_BROADCAST";
    public CustomReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        //throw new UnsupportedOperationException("Not yet implemented");
        String intentAction = intent.getAction();
        String toastMessage = null;
        switch(intentAction)
        {
            case Intent.ACTION_POWER_CONNECTED: toastMessage="POWER COMNECTED";
                break;
            case Intent.ACTION_POWER_DISCONNECTED: toastMessage= "POWER DISCONNECTED";
                break;
        }
        Toast.makeText(context,toastMessage,Toast.LENGTH_SHORT);
    }

}
