package com.srikanth.activityresulttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * Created by srikanth Kommineni on 9/30/14.
 */

public class MainActivity extends Activity {
    static final int RESULT_FROM_LOGIN = 100;
    boolean mRequireLogin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        setAndVerifyUserState(true);
    }

    /**
     * This is a simplified version of the actual method that does the login verification
     * For the intents and purposes of this demo, it is sufficient.
     *
     * @param requireLogin Indicate if the user login is required.
     *
     */
    private void setAndVerifyUserState(boolean requireLogin) {
        mRequireLogin = requireLogin;
        invalidateOptionsMenu();

        // Forcing user auth
        if (mRequireLogin) {
            // Do the logout logic if required
            // mSessionManager.logout();
            startLoginActivity();
        }
    }

    /*
     * This is needed in case the user is
     * logged out or just installed the application.
     */
    private void startLoginActivity() {
        Intent loginIntent = new Intent(this, AuthenticateLauncherActivity.class);
        startActivityForResult(loginIntent, RESULT_FROM_LOGIN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Boolean handled = false;

        switch (requestCode) {
            case RESULT_FROM_LOGIN:
                if (resultCode == Activity.RESULT_OK) {

                    // Just resume, the login activity handles everything when things are successful.
                    handled = true;
                } else if (resultCode == Activity.RESULT_CANCELED) {

                    // Login activity didn't work or the user pressed the back button. Exit the app.

                    handled = true;
                    finish();
                }

                break;
        }

        // If we haven't handled it yet, send it to the super
        if (!handled) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
