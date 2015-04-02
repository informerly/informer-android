package sabasoft.net.newsfeeds.PushNotification;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class Push extends Application {
    String username = "test@informerly.com";// not generating dynamically still working
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("username", username);
        installation.saveInBackground();
        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
    }
}
