package getmore.com.getmore.fragment.home;

import android.util.Log;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import getmore.com.getmore.util.JsonHandler;
import getmore.com.getmore.vo.ShopVO;

/**
 * Created by zhongqinng on 1/1/15.
 */
public class HomeWebService {

    private static final String TAG = "HomeWebService";
    private HomeFragment homeFragment;
    private JsonHandler jsonHandler;

    public HomeWebService(HomeFragment homeFragment){
        this.homeFragment=homeFragment;
        this.jsonHandler=new JsonHandler();
    }

    public void get_shop_search(ArrayList<String> search_terms,boolean sortByMember, ParseGeoPoint geoPoint) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        JSONArray searchTermsJSON = new JSONArray();
        int i =0;
        int size = search_terms.size();

        while (i<size){
            try {
                JSONObject searchTermJSON = new JSONObject();
                searchTermJSON.put("tag", search_terms.get(i));
                searchTermsJSON.put(searchTermJSON);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            i++;
        }
        if(geoPoint!=null){
            params.put("location",geoPoint);
        }

        if(sortByMember){
            params.put("sortBy","member");
        }else{
            params.put("sortBy","location");
        }

        params.put("search_terms",searchTermsJSON);
        final ArrayList<ShopVO> shopVOs = new ArrayList<ShopVO>();
        ParseCloud.callFunctionInBackground("cx_get_shop_search", params, new FunctionCallback<HashMap<String, Object>>() {
            public void done(HashMap<String, Object> result, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "cx_get_shop_search: okay");
                    ArrayList<HashMap<String, Object>> objects = (ArrayList<HashMap<String, Object>>) result.get("shops");
                  int i = 0;
                    int size = 0;
                    if(objects!=null){
                        size = objects.size();
                    }

                    while (i<size){
                        String id = jsonHandler.getString(objects.get(i),"id");
                        String name = jsonHandler.getString(objects.get(i),"name");
                        String short_desc = jsonHandler.getString(objects.get(i),"short_desc");
                        String small_pict_url = jsonHandler.getString(objects.get(i),"small_pict_url");
                        ParseGeoPoint location = jsonHandler.getGeoPoint(objects.get(i),"location");
                        Number number1 = jsonHandler.getNumber( objects.get(i), "number");
                        ShopVO shopVO = new ShopVO(id,name,short_desc,small_pict_url);
                        shopVO.setNumberOfMembers(number1);
                        shopVO.setLocation(location);
                        shopVOs.add(shopVO);
                        i++;
                    }

                    homeFragment.create_search_shop_list(shopVOs);

                } else {
                    Log.i(TAG, "cx_get_shop_search: EXCEPTION: " + e.getMessage());
                }
            }
        });
    }
/*
    private Number getNumberOfMembers(ArrayList<HashMap<String, Object>> shop_membership_objects, String shop_id){
        Number returnNumber = 0;
            if(shop_id!=null){
                if(shop_membership_objects!=null){
                    int i = 0;
                    int size = shop_membership_objects.size();
                    while (i<size){
                        if(shop_membership_objects.get(i)!=null){
                            String shop_id_from_object = jsonHandler.getString(shop_membership_objects.get(i), "shopId");
                            if(shop_id_from_object!=null){
                                if(!shop_id_from_object.toString().isEmpty()){
                                    if(shop_id_from_object.toString().equals(shop_id)){
                                        Number number1 = jsonHandler.getNumber( shop_membership_objects.get(i), "number");
                                        if(number1!=null){
                                            return number1;
                                        }
                                    }
                                }
                            }
                        }
                        i++;
                    }
                }
            }
        return returnNumber;
    }
    */
}
