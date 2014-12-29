package getmore.com.getmore;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by zhongqinng on 16/11/14.
 */
public class GetMoreApplication extends Application{
    static final String TAG = "WineStoryApplication";

    @Override
    public void onCreate() {
        super.onCreate();


        //DEV
        String PARSE_APPLICATION_ID = "IgzLAHgxsgXjOAQ8Nj1ilIq4rFxda46Nwq9FApbn";
        String PARSE_CLIENT_ID ="uNC95NXAgIVPKdPB9hmNR9qtQqAaC1GcmmKLDC4a";
        String FACEBOOK_APP_ID = "1741150259442878";



        Parse.initialize(this,
                PARSE_APPLICATION_ID,
                PARSE_CLIENT_ID
        );

        // Set your Facebook App Id in strings.xml
        Log.i(TAG,"GetMoreApplication: FACEBOOK_APP_ID:"+FACEBOOK_APP_ID);
        ParseFacebookUtils.initialize(FACEBOOK_APP_ID);
    }
}
