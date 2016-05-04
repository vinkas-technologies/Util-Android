package vinkas.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import vinkas.util.Helper;
import vinkas.util.R;

/**
 * Created by Vinoth on 3-5-16.
 */
public abstract class SplashActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume();
        initialize();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    protected void initialize() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (isReady() == false)
                        sleep(1000);
                    startMainActivity();
                } catch (InterruptedException e) {
                    Helper.onException(e);
                }
            }
        };
        thread.start();
    }

    public boolean isReady() {
        return true;
    }

    protected void startMainActivity() {
        Intent i = new Intent(this, getMainActivityClass());
        startActivity(i);
        finish();
    }

    protected abstract Class<?> getMainActivityClass();

}