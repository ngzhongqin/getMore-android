package getmore.com.getmore.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import getmore.com.getmore.R;
import getmore.com.getmore.fragment.home.favourite.FavouriteShopResults;
import getmore.com.getmore.fragment.home.favourite.FavouriteWebService;
import getmore.com.getmore.fragment.home.search.SearchShopResults;
import getmore.com.getmore.fragment.home.search.SearchWebService;
import getmore.com.getmore.util.assetHandler.AssetHandler;
import getmore.com.getmore.vo.ShopVO;

public class HomeFragment extends Fragment {
    private String TAG = "HomeFragment";
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    //private ViewHolder viewHolder;
    private View v;
    private AssetHandler assetHandler;
    private SearchWebService searchWebService;
    private SearchShopResults searchShopResults;
    private FavouriteShopResults favouriteShopResults;
    private FavouriteWebService favouriteWebService;

    public static final HomeFragment newInstance(String message)
    {
        HomeFragment f = new HomeFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        v = inflater.inflate(R.layout.home_f, container, false);
        assetHandler = new AssetHandler(getActivity());
        searchWebService =new SearchWebService(this);
        searchShopResults=new SearchShopResults(getActivity(),v, searchWebService);
        favouriteWebService = new FavouriteWebService(this);
        favouriteShopResults= new FavouriteShopResults(getActivity(),v,favouriteWebService);
        return v;
    }

    public void create_search_shop_list(ArrayList<ShopVO> searchShopVOs){
        searchShopResults.create_search_shop_list(searchShopVOs);
    }

    public void create_favourite_shop_list(ArrayList<ShopVO> shopVOs,HomeFragment homeFragment){
        favouriteShopResults.create_shop_list(shopVOs,homeFragment);
    }

    public void set_search_hint_container_visible(boolean visible){
        searchShopResults.set_search_hint_container_visible(visible);
        favouriteShopResults.set_spinner_visible(!visible);
    }
}

