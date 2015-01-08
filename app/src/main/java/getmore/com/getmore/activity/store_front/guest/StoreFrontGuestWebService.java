package getmore.com.getmore.activity.store_front.guest;

import android.util.Log;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;

import java.util.HashMap;

import getmore.com.getmore.util.JsonHandler;
import getmore.com.getmore.vo.ShopVO;

/**
 * Created by zhongqinng on 8/1/15.
 */
public class StoreFrontGuestWebService {
    private static final String TAG = "StoreFrontGuestWebService";
    private StoreFrontGuestActivity mActivity;
    private JsonHandler jsonHandler;

    public StoreFrontGuestWebService(StoreFrontGuestActivity mActivity){
        this.mActivity=mActivity;
        this.jsonHandler=new JsonHandler();
    }

    public void get_shop(String shop_id) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("shop_id",shop_id);

        ParseCloud.callFunctionInBackground("cx_store_front_guest", params, new FunctionCallback<HashMap<String, Object>>() {
            public void done(HashMap<String, Object> result, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "cx_store_front_guest: okay");
                    HashMap<String, Object> shop = jsonHandler.getHashMapStringObject("shop", result);
                    String id = jsonHandler.getString(shop,"id");
                    String name = jsonHandler.getString(shop,"name");
                    String address = jsonHandler.getString(shop,"address");
                    String top_banner_url = jsonHandler.getString(shop,"top_banner_url");
                    String guest_promo_url = jsonHandler.getString(shop,"guest_promo_url");
                    String hours = jsonHandler.getString(shop,"hours");
                    String tier1_item = jsonHandler.getString(shop,"tier1_item");
                    Number tier1_point = jsonHandler.getNumber(shop,"tier1_point");
                    String tier2_item = jsonHandler.getString(shop,"tier2_item");
                    Number tier2_point = jsonHandler.getNumber(shop,"tier2_point");
                    String tier3_item = jsonHandler.getString(shop,"tier3_item");
                    Number tier3_point = jsonHandler.getNumber(shop,"tier3_point");
                    String tier4_item = jsonHandler.getString(shop,"tier4_item");
                    Number tier4_point = jsonHandler.getNumber(shop,"tier4_point");

                    ShopVO shopVO = new ShopVO(id,name,address,hours,top_banner_url,
                            guest_promo_url,tier1_item,tier1_point,tier2_item,tier2_point,
                            tier3_item,tier3_point,tier4_item,tier4_point);


                    mActivity.setShopVO(shopVO);

                } else {
                    Log.i(TAG, "cx_store_front_guest: EXCEPTION: " + e.getMessage());
                }
            }
        });
    }
}
