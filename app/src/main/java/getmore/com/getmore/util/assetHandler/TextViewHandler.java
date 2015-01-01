package getmore.com.getmore.util.assetHandler;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class TextViewHandler {
    private String TAG = "TextViewSetter";

    public TextViewHandler(){};

    public void setTextViewVisible(TextView textView,boolean visible){
        if(visible){
            try {
                textView.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Log.e(TAG, "setTextViewVisible View.VISIBLE EXCEPTION:" + e.getMessage());
                e.printStackTrace();
            }
        }else {
            try {
                textView.setVisibility(View.GONE);
            }catch (Exception e){
                Log.e(TAG, "setTextViewVisible View.GONE EXCEPTION:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean checkTextViewVisible(TextView textView) {
        boolean returnBol = false;
        if (textView != null) {
            if (textView.getVisibility() == View.VISIBLE) {
                returnBol = true;
            }
        }
        return returnBol;
    }
}
