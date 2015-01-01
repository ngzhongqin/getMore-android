package getmore.com.getmore.util.assetSetter;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class FrameLayoutSetter {
    private String TAG = "FrameLayoutSetter";

    public FrameLayoutSetter(){};

    public void setFrameLayoutVisible(FrameLayout frameLayout,boolean visible){
        if(visible){
            try {
                frameLayout.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Log.e(TAG, "setFrameLayoutVisible View.VISIBLE EXCEPTION:" + e.getMessage());
                e.printStackTrace();
            }
        }else {
            try {
                frameLayout.setVisibility(View.GONE);
            }catch (Exception e){
                Log.e(TAG, "setFrameLayoutVisible View.GONE EXCEPTION:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean checkFrameLayoutVisible(FrameLayout layout) {
        boolean returnBol = false;
        if (layout != null) {
            if (layout.getVisibility() == View.VISIBLE) {
                returnBol = true;
            }
        }
        return returnBol;
    }
}
