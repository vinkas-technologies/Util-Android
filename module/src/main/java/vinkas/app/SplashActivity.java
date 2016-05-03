package vinkas.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import vinkas.util.R;

/**
 * Created by Vinoth on 3-5-16.
 */
public abstract class SplashActivity extends Activity {

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isNetworkAvailable())
            initialize();
        else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Unable to connect to internet. Please try again later.");
            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dlgAlert.setCancelable(false);
            dlgAlert.create().show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    protected void initialize() {
        if(isReady()) {
            startMainActivity();
        }
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