package getmore.com.getmore.fragment.home.favourite;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.parse.ParseGeoPoint;

import java.util.ArrayList;

import getmore.com.getmore.R;
import getmore.com.getmore.fragment.home.HomeFragment;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.util.location.LocationHandler;
import getmore.com.getmore.vo.ShopVO;

/**
 * Created by zhongqinng on 10/1/15.
 */
public class FavouriteShopResults {
    private View view;
    private String TAG = "FavouriteShopResults";
    private FragmentActivity fragmentActivity;
    private FavouriteWebService favouriteWebService;
    private AssetHandler ah;
    private ViewHolder vh;
    private ArrayList<ShopVO> shopVOs;

    class ViewHolder{
        LinearLayout fav_shop_container;
        LinearLayout fav_shop_list;
        LinearLayout fav_spinner_placeholder;
    }

    public FavouriteShopResults(FragmentActivity fragmentActivity, View view, FavouriteWebService favouriteWebService){
        this.fragmentActivity=fragmentActivity;
        ah = new AssetHandler(fragmentActivity);
        vh = new ViewHolder();
        this.view=view;
        this.favouriteWebService=favouriteWebService;

        vh.fav_shop_container = ah.linearLayoutHandler.set(view, R.id.fav_shop_container);
        vh.fav_shop_list = ah.linearLayoutHandler.set(view, R.id.fav_shop_list);
        vh.fav_spinner_placeholder = ah.linearLayoutHandler.set(view, R.id.fav_spinner_placeholder);

        boolean sortByNews = true;
        ParseGeoPoint currentLocation = getCurrentLocation();
        this.favouriteWebService.get_fav_shop(sortByNews,currentLocation);
    }

    private ParseGeoPoint getCurrentLocation(){
        LocationHandler locationHandler = new LocationHandler();
        ParseGeoPoint location = locationHandler.getLastKnownLocation(this.fragmentActivity);
        return location;
    }

    public void create_shop_list(ArrayList<ShopVO> shopVOs, HomeFragment homeFragment) {
        if(checkShopVOsNullOrEmpty(shopVOs)){
            homeFragment.set_search_hint_container_visible(true);
        }else{
            create_fav_shop_list(shopVOs);
        }
    }

    private boolean checkShopVOsNullOrEmpty(ArrayList<ShopVO> shopVOs){
        boolean returnBol;
        if(shopVOs==null){
            returnBol = true;
            return returnBol;
        }else{
            if(shopVOs.isEmpty()){
                returnBol = true;
                return returnBol;
            }else{
                returnBol = false;
                return returnBol;
            }
        }
    }

    public void create_fav_shop_list(ArrayList<ShopVO> shopVOs){
        Log.d(TAG, "create_fav_shop_list start");
        this.shopVOs=shopVOs;
        ah.linearLayoutHandler.removeAllViews(vh.fav_shop_list);
        FavShopAdapter favShopAdapter = new FavShopAdapter(this.fragmentActivity, this.fragmentActivity, R.id.home_i_favshop_panel_content);
        for (ShopVO item : this.shopVOs) {
            favShopAdapter.add(item);
        }

        int i = 0;
        int size = favShopAdapter.getCount();
        while(i<size){
            View itemView = favShopAdapter.getView(i,null,null);
            vh.fav_shop_list.addView(itemView);
            i++;
        }

        ah.linearLayoutHandler.setVisible(vh.fav_spinner_placeholder, false);
        Log.d(TAG,"create_fav_shop_list end");
    }
}
