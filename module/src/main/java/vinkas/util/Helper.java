package vinkas.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Vinoth on 3-5-16.
 */
public class Helper {

    public static final int RESULT_OK = 1001;
    public static final int RESULT_CANCEL = 1002;
    public static final int RESULT_ERROR = 1003;

    public static void onException(Exception exception) {
        if (BuildConfig.DEBUG)
            exception.printStackTrace();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
