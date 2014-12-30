package getmore.com.getmore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import getmore.com.getmore.R;

public class HomeFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private ViewHolder viewHolder;
    private View v;

    class ViewHolder{
        FrameLayout search_box_container;
        LinearLayout search_hint_container;
    }

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
        viewHolder=new ViewHolder();
        viewHolder.search_box_container = (FrameLayout) v.findViewById(R.id.search_box_container);
        viewHolder.search_hint_container = (LinearLayout) v.findViewById(R.id.search_hint_container);
        setSearchBoxContainerVisible(false);

        return v;
    }

    public void setSearchBoxContainerVisible(boolean visible){
        if(visible){
            viewHolder.search_box_container.setVisibility(View.VISIBLE);
        }else{
            viewHolder.search_box_container.setVisibility(View.GONE);
        }
    }

    public void setSearchHintContainerVisible(boolean visible){
        if(visible){
            viewHolder.search_hint_container.setVisibility(View.VISIBLE);
        }else{
            viewHolder.search_hint_container.setVisibility(View.GONE);
        }
    }
}

