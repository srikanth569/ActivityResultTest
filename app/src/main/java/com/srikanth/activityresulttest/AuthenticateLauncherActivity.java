package com.srikanth.activityresulttest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by srikanth Kommineni on 9/30/14.
 */
public class AuthenticateLauncherActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    @Override
    public void onBackPressed() {
        // The original method has Logic to check if the user has initiated login to prevent
        // him from hitting back after hitting submit before the server returns with a result.

        finishActivity(RESULT_CANCELED);
        super.onBackPressed();
    }

}
