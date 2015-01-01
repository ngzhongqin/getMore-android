package getmore.com.getmore.fragment.home;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import getmore.com.getmore.R;
import getmore.com.getmore.util.assetSetter.AssetSetter;
import getmore.com.getmore.vo.ShopVO;

/**
 * Created by zhongqinng on 2/1/15.
 */
public class SearchShopResults {
    private String TAG = "SearchShopResults";
    private FragmentActivity fragmentActivity;
    private View v;
    private ViewHolder viewHolder;
    private AssetSetter assetSetter;
    private HomeWebService homeWebService;
    private SearchShopAdapter searchShopAdapter;
    private ArrayList<ShopVO> searchShopVOs;

    class ViewHolder{
        FrameLayout search_box_container;
        LinearLayout search_hint_container;
        ImageButton search_btn;
        ImageButton search_hint_btn;
        LinearLayout search_shop_list;
    }

    public SearchShopResults(FragmentActivity fragmentActivity, View v,HomeWebService homeWebService){
        this.fragmentActivity=fragmentActivity;
        this.v=v;
        this.viewHolder=new ViewHolder();
        this.assetSetter = new AssetSetter();
        this.homeWebService=homeWebService;

        viewHolder.search_box_container = (FrameLayout) v.findViewById(R.id.search_box_container);
        viewHolder.search_hint_container = (LinearLayout) v.findViewById(R.id.search_hint_container);
        viewHolder.search_btn = (ImageButton) v.findViewById(R.id.search_btn);
        viewHolder.search_hint_btn = (ImageButton) v.findViewById(R.id.search_hint_btn);
        viewHolder.search_shop_list = (LinearLayout) v.findViewById(R.id.search_shop_list);

        assetSetter.frameLayoutSetter.setFrameLayoutVisible(viewHolder.search_box_container,false);
        setSearchButtonOnClickListener();
        setSearchHintButtonOnClickListener();
    };

    private void setSearchButtonOnClickListener(){

        viewHolder.search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setSearchButtonOnClickListener");
                if(assetSetter.frameLayoutSetter.checkFrameLayoutVisible(viewHolder.search_box_container)){
                    Log.d(TAG, "setSearchButtonOnClickListener search_box_container is visible");
                    homeWebService.get_shop_search(getSearchTerms());
                }else {
                    assetSetter.frameLayoutSetter.setFrameLayoutVisible(viewHolder.search_box_container, true);
                    assetSetter.linearLayoutSetter.setLinearLayoutVisible(viewHolder.search_hint_container, false);
                }
            }
        });
    }

    private void setSearchHintButtonOnClickListener(){
        viewHolder.search_hint_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setSearchHintButtonOnClickListener");
                assetSetter.frameLayoutSetter.setFrameLayoutVisible(viewHolder.search_box_container, true);
                assetSetter.linearLayoutSetter.setLinearLayoutVisible(viewHolder.search_hint_container, false);
            }
        });
    }

    private ArrayList<String> getSearchTerms(){
        String searchTerm = "shoe";
        ArrayList<String> returnArrayList = new ArrayList<String>();
        returnArrayList.add(searchTerm);
        searchTerm = "footwear";
        returnArrayList.add(searchTerm);
        return returnArrayList;
    }

    public void create_search_shop_list(ArrayList<ShopVO> searchShopVOs){
        Log.d(TAG,"create_search_shop_list start");
        this.searchShopVOs=searchShopVOs;
        viewHolder.search_shop_list.removeAllViews();
        searchShopAdapter = new SearchShopAdapter(this.fragmentActivity, R.id.home_i_searchshop_panel_content);
        for (ShopVO item : this.searchShopVOs) {
            searchShopAdapter.add(item);
        }

        int i = 0;
        int size = searchShopAdapter.getCount();
        while(i<size){
            View itemView = searchShopAdapter.getView(i,null,null);
            viewHolder.search_shop_list.addView(itemView);
            i++;
        }
        Log.d(TAG,"create_search_shop_list end");

    }
}
