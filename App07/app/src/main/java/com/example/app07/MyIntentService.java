package com.example.app07;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG,"TestJobService started!");


        //Toast.makeText(getApplicationContext(),"TestJobService started!",Toast.LENGTH_SHORT).show();
    }
}

