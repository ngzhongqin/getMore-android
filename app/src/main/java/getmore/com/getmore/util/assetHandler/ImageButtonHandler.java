package getmore.com.getmore.util.assetHandler;

import android.util.Log;
import android.widget.ImageButton;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class ImageButtonHandler {
    private String TAG = "ImageButtonSetter";

    public ImageButtonHandler(){

    }

    public void setImageButtonImageResource(ImageButton imageButton, int resId){
        if(imageButton!=null){
            try{
                imageButton.setImageResource(resId);
            }catch (Exception e){
                Log.e(TAG,"setImageButtonImageResource :imageButton: "+imageButton+" EXCEPTION: "+e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
