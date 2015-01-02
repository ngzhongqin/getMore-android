package getmore.com.getmore.fragment.home;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.ParseGeoPoint;

import java.util.ArrayList;

import getmore.com.getmore.R;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.util.location.LocationHandler;
import getmore.com.getmore.vo.ShopVO;

/**
 * Created by zhongqinng on 2/1/15.
 */
public class SearchShopResults {
    private String TAG = "SearchShopResults";
    private FragmentActivity fragmentActivity;
    private View v;
    private ViewHolder viewHolder;
    private AssetHandler assetHandler;
    private HomeWebService homeWebService;
    private SearchShopAdapter searchShopAdapter;
    private ArrayList<ShopVO> searchShopVOs;

    class ViewHolder{
        FrameLayout search_box_container;
        LinearLayout search_hint_container;
        ImageButton search_btn;
        ImageButton search_hint_btn;
        LinearLayout search_shop_list;
        LinearLayout search_shop_container;
        TextView search_title;
        LinearLayout search_spinner_placeholder;
        EditText search_edit_text;
        LinearLayout sort_btn_container;
        Button popular_btn;
        Button closer_btn;
    }

    public SearchShopResults(FragmentActivity fragmentActivity, View v,HomeWebService homeWebService){
        this.fragmentActivity=fragmentActivity;
        this.v=v;
        this.viewHolder=new ViewHolder();
        this.assetHandler = new AssetHandler(fragmentActivity);
        this.homeWebService=homeWebService;

        viewHolder.search_hint_btn = assetHandler.imageButtonHandler.set(v,R.id.search_hint_btn);
        viewHolder.search_btn = assetHandler.imageButtonHandler.set(v,R.id.search_btn);
        viewHolder.search_title = assetHandler.textViewHandler.set(v,R.id.search_title);
        viewHolder.search_spinner_placeholder = assetHandler.linearLayoutHandler.set(v,R.id.search_spinner_placeholder);
        viewHolder.search_shop_container = assetHandler.linearLayoutHandler.set(v,R.id.search_shop_container);
        viewHolder.search_shop_list = assetHandler.linearLayoutHandler.set(v,R.id.search_shop_list);
        viewHolder.search_hint_container = assetHandler.linearLayoutHandler.set(v,R.id.search_hint_container);
        viewHolder.search_box_container = assetHandler.frameLayoutHandler.set(v,R.id.search_box_container);
        viewHolder.search_edit_text = assetHandler.editTextHandler.set(v,R.id.search_edit_text);
        viewHolder.sort_btn_container = assetHandler.linearLayoutHandler.set(v,R.id.sort_btn_container);
        viewHolder.popular_btn = assetHandler.buttonHandler.set(v,R.id.popular_btn);
        viewHolder.closer_btn = assetHandler.buttonHandler.set(v,R.id.closer_btn);

        assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.sort_btn_container,false);
        assetHandler.frameLayoutHandler.setFrameLayoutVisible(viewHolder.search_box_container,false);
        assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.search_spinner_placeholder,false);
        assetHandler.textViewHandler.setTextViewVisible(viewHolder.search_title,false);
        setSearchButtonOnClickListener();
        setSearchHintButtonOnClickListener();
        setPopularButtonOnClickListener();
        setCloserButtonOnClickListener();
        setEditTextAction();
    };

    private void setSearchButtonOnClickListener(){

        viewHolder.search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setSearchButtonOnClickListener");
                if(assetHandler.frameLayoutHandler.checkFrameLayoutVisible(viewHolder.search_box_container)){
                    Log.d(TAG, "setSearchButtonOnClickListener search_box_container is visible");
                    get_shop_search(true);
                }else {
                    assetHandler.frameLayoutHandler.setFrameLayoutVisible(viewHolder.search_box_container, true);
                    assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.search_hint_container, false);
                }
            }
        });
    }

    private void setSearchHintButtonOnClickListener(){
        viewHolder.search_hint_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setSearchHintButtonOnClickListener");
                assetHandler.frameLayoutHandler.setFrameLayoutVisible(viewHolder.search_box_container, true);
                assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.search_hint_container, false);
            }
        });
    }

    private void setPopularButtonOnClickListener(){
        viewHolder.popular_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setPopularButtonOnClickListener");
                assetHandler.buttonHandler.setTextBold(viewHolder.popular_btn,true);
                assetHandler.buttonHandler.setTextBold(viewHolder.closer_btn,false);
                get_shop_search(true);
            }
        });
    }

    private void setCloserButtonOnClickListener(){
        viewHolder.closer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setCloserButtonOnClickListener");
                assetHandler.buttonHandler.setTextBold(viewHolder.closer_btn,true);
                assetHandler.buttonHandler.setTextBold(viewHolder.popular_btn,false);
                get_shop_search(false);
            }
        });
    }

    private void get_shop_search(boolean sortByMember){
        ParseGeoPoint geoPoint = getCurrentLocation();
        assetHandler.linearLayoutHandler.removeAllViews(viewHolder.search_shop_list);
        assetHandler.frameLayoutHandler.setFrameLayoutVisible(viewHolder.search_box_container, false);
        assetHandler.textViewHandler.setTextViewVisible(viewHolder.search_title,true);
        assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.search_spinner_placeholder,true);
        homeWebService.get_shop_search(getSearchTerms(),sortByMember,geoPoint);
        assetHandler.keyBoardHandler.hide_keyboard();
    }

    private ArrayList<String> getSearchTerms(){
        ArrayList<String> returnArrayList = assetHandler.editTextHandler.getStringsFromEditText(viewHolder.search_edit_text);
        return returnArrayList;
    }

    public void create_search_shop_list(ArrayList<ShopVO> searchShopVOs){
        Log.d(TAG,"create_search_shop_list start");
        this.searchShopVOs=searchShopVOs;
        assetHandler.linearLayoutHandler.removeAllViews(viewHolder.search_shop_list);
//        viewHolder.search_shop_list.removeAllViews();
        searchShopAdapter = new SearchShopAdapter(this.fragmentActivity,this.fragmentActivity, R.id.home_i_searchshop_panel_content);
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

        assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.search_spinner_placeholder,false);
        //assetHandler.editTextHandler.clearText(viewHolder.search_edit_text);
        assetHandler.linearLayoutHandler.setLinearLayoutVisible(viewHolder.sort_btn_container,true);
        Log.d(TAG,"create_search_shop_list end");
    }

    private void setEditTextAction(){
        if(viewHolder!=null){
            if(viewHolder.search_edit_text!=null){
                viewHolder.search_edit_text.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            get_shop_search(true);

                            return true;
                        }
                        return false;
                    }
                });
            }
        }
    }

    private ParseGeoPoint getCurrentLocation(){
        LocationHandler locationHandler = new LocationHandler();
        ParseGeoPoint location = locationHandler.getLastKnownLocation(this.fragmentActivity);
        return location;
    }
}
