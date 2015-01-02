package getmore.com.getmore.util.assetHandler;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class LinearLayoutHandler {
    private String TAG = "LinearLayoutSetter";

    public LinearLayoutHandler(){};

    public LinearLayout set(View v, int resId){
        LinearLayout linearLayout = null;
        try{
            linearLayout = (LinearLayout) v.findViewById(resId);
        }catch (Exception e){
            Log.e(TAG,"set resId:"+resId+" EXCEPTION: "+e.getMessage());
            e.printStackTrace();
        }
        return linearLayout;
    }

    public void setLinearLayoutVisible(LinearLayout linearLayout,boolean visible){
        if(visible){
            try {
                linearLayout.setVisibility(View.VISIBLE);
            }catch (Exception e){
                Log.e(TAG, "setLinearLayoutVisible View.VISIBLE EXCEPTION:" + e.getMessage());
                e.printStackTrace();
            }
        }else {
            try {
                linearLayout.setVisibility(View.GONE);
            }catch (Exception e){
                Log.e(TAG, "setLinearLayoutVisible View.GONE EXCEPTION:" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public boolean checkFrameLayoutVisible(LinearLayout layout) {
        boolean returnBol = false;
        if (layout != null) {
            if (layout.getVisibility() == View.VISIBLE) {
                returnBol = true;
            }
        }
        return returnBol;
    }

    public void removeAllViews(LinearLayout layout) {
        try{
            layout.removeAllViews();
        }catch (Exception e){
            Log.e(TAG,"removeAllViews()");
            e.printStackTrace();
        }
    }
}
