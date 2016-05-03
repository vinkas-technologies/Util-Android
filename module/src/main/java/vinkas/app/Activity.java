package vinkas.app;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vinoth on 3-5-16.
 */
public class Activity extends AppCompatActivity {

    public Application getApp() {
        return (Application) getApplication();
    }

    public void sendResult(int resultCode) {
        setResult(resultCode);
        finish();
    }

}
