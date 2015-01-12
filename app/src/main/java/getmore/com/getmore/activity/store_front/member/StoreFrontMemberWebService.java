package getmore.com.getmore.activity.store_front.member;

import android.util.Log;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import getmore.com.getmore.util.JsonHandler;
import getmore.com.getmore.vo.NewsItemVO;
import getmore.com.getmore.vo.ShopVO;

/**
 * Created by zhongqinng on 8/1/15.
 */
public class StoreFrontMemberWebService {
    private static final String TAG = "StoreFrontMemberWebService";
    private StoreFrontMemberActivity mActivity;
    private JsonHandler jsonHandler;

    public StoreFrontMemberWebService(StoreFrontMemberActivity mActivity){
        this.mActivity=mActivity;
        this.jsonHandler=new JsonHandler();
    }

    public void get_shop(String shop_id) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("shop_id",shop_id);

        ParseCloud.callFunctionInBackground("cx_store_front_member", params, new FunctionCallback<HashMap<String, Object>>() {
            public void done(HashMap<String, Object> result, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "cx_store_front_member: okay");
                    HashMap<String, Object> shop = jsonHandler.getHashMapStringObject("shop", result);
                    String id = jsonHandler.getString(shop,"id");
                    String name = jsonHandler.getString(shop,"name");
                    String address = jsonHandler.getString(shop,"address");
                    String top_banner_url = jsonHandler.getString(shop,"top_banner_url");
                    String member_promo_url = jsonHandler.getString(shop,"member_promo_url");
                    String hours = jsonHandler.getString(shop,"hours");
                    String tier1_item = jsonHandler.getString(shop,"tier1_item");
                    Number tier1_point = jsonHandler.getNumber(shop,"tier1_point");
                    String tier2_item = jsonHandler.getString(shop,"tier2_item");
                    Number tier2_point = jsonHandler.getNumber(shop,"tier2_point");
                    String tier3_item = jsonHandler.getString(shop,"tier3_item");
                    Number tier3_point = jsonHandler.getNumber(shop,"tier3_point");
                    String tier4_item = jsonHandler.getString(shop,"tier4_item");
                    Number tier4_point = jsonHandler.getNumber(shop,"tier4_point");
                    String member_promo_text = jsonHandler.getString(shop,"member_promo_text");
                    ArrayList<NewsItemVO> newsItemVOArrayList = getNewsItemArraylist(jsonHandler.getArrayList("news", shop));

                    ShopVO shopVO = new ShopVO(id,name,address,hours,top_banner_url,
                            tier1_item,tier1_point,tier2_item,tier2_point,
                            tier3_item,tier3_point,tier4_item,tier4_point);
                    shopVO.setMember_promo_url(member_promo_url);
                    shopVO.setMember_promo_text(member_promo_text);
                    shopVO.setNewsItemVOArrayList(newsItemVOArrayList);

                    mActivity.setShopVO(shopVO);

                } else {
                    Log.i(TAG, "cx_store_front_member: EXCEPTION: " + e.getMessage());
                }
            }
        });
    }

    private ArrayList<NewsItemVO> getNewsItemArraylist(ArrayList<HashMap<String,Object>> news){
        ArrayList<NewsItemVO> newsItemVOArrayList = new ArrayList<NewsItemVO>();
        int i = 0;
        if(news!=null) {
            int size = news.size();
            while (i < size) {
                String text = jsonHandler.getString(news.get(i), "text");
                Date createdAt = jsonHandler.getDate(news.get(i), "createdAt");
                NewsItemVO newsItemVO = new NewsItemVO(text, createdAt);
                newsItemVOArrayList.add(newsItemVO);
                i++;
            }
        }

        return newsItemVOArrayList;
    }
}
