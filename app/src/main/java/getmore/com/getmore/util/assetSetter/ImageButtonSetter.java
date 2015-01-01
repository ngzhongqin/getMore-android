package getmore.com.getmore.util.assetSetter;

import android.util.Log;
import android.widget.ImageButton;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class ImageButtonSetter {
    private String TAG = "ImageButtonSetter";

    public ImageButtonSetter(){

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
