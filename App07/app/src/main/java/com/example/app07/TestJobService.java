package com.example.app07;

import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;

/**
 * JobService to be scheduled by the JobScheduler.
 * start another service
 */
public class TestJobService extends JobService {
    private static final String TAG = "TestJobService";

    @Override
    public boolean onStartJob(JobParameters params) {
        //Intent service = new Intent(getApplicationContext(), MyIntentService.class);
        //getApplicationContext().startService(service);
        //Util.scheduleJob(getApplicationContext()); // reschedule the job
        Log.i(TAG,"onStartJob");
        Util.scheduleJob(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        //Log.i(TAG,"onStopJob");
        //JobScheduler jobScheduler=getApplicationContext().getSystemService(JobScheduler.class);
        //jobScheduler.cancel(Util.TEST_SERVICE_ID);
        return true;
    }
}
