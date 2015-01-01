package getmore.com.getmore.util;

import android.util.Log;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by zhongqinng on 2/1/15.
 */
public class JsonHandler {
    private String TAG = "JsonHandler";

    public JsonHandler(){};

    public String getString(HashMap<String,Object> hashMap, String key){
        String returnString = null;
        Object object = hashMap.get(key);
        if(object!=null){
            returnString= object.toString();
        }
        return returnString;
    }

    public Number getNumber(HashMap<String,Object> hashMap, String key){
        Number returnNumber = null;
        Object object = hashMap.get(key);
        if(object!=null){
           try{
               returnNumber=Double.parseDouble(object.toString());
           }catch (Exception e){
               Log.e(TAG,"getNumber EXCEPTION: "+e.getMessage());
               e.printStackTrace();
           }
        }
        return returnNumber;
    }

    public Date getDate(HashMap<String,Object> hashMap, String key){
        Date returnDate = null;
        Object object = hashMap.get(key);
        if(object!=null){
            try{
                returnDate= (Date) object;
            }catch (Exception e){
                Log.e(TAG,"getDate EXCEPTION: "+e.getMessage());
                e.printStackTrace();
            }
        }

        return returnDate;

    }
}

