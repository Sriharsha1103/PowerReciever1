package com.example.user.powerreciever;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    private boolean mReceiverState;
    private static final String ACTION_CUSTOM_BROADCAST = "com.example.android.powerreceiver.ACTION_CUSTOM_BROADCAST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.receiverToggle);
        final SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        mReceiverState = sharedPreferences.getBoolean("recieveState",true);
        toggle.setChecked(mReceiverState);
        final ComponentName receiver = new ComponentName(this,CustomReceiver.class);
        final PackageManager packageManager= getPackageManager();
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mReceiverState= true;
                }
                else{
                    mReceiverState = false;
                }
            }
        });
        int receiverStateFlag = (mReceiverState ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED : PackageManager.COMPONENT_ENABLED_STATE_DISABLED);
        sharedPreferences.edit().putBoolean("recieverState",mReceiverState).apply();
        packageManager.setComponentEnabledSetting(receiver,receiverStateFlag,packageManager.DONT_KILL_APP);
    }

    public void sendBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(this,)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}
