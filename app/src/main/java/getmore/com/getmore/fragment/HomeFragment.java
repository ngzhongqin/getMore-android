package getmore.com.getmore.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import getmore.com.getmore.R;

public class HomeFragment extends Fragment {
    private String TAG = "HomeFragment";
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private ViewHolder viewHolder;
    private View v;

    class ViewHolder{
        FrameLayout search_box_container;
        LinearLayout search_hint_container;
        ImageButton search_btn;
        ImageButton search_hint_btn;
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
        viewHolder.search_btn = (ImageButton) v.findViewById(R.id.search_btn);
        viewHolder.search_hint_btn = (ImageButton) v.findViewById(R.id.search_hint_btn);
        setSearchBoxContainerVisible(false);
        setSearchButtonOnClickListener();
        setSearchHintButtonOnClickListener();

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

    private void setSearchButtonOnClickListener(){
        viewHolder.search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setSearchButtonOnClickListener");
                setSearchBoxContainerVisible(true);
                setSearchHintContainerVisible(false);

            }
        });
    }

    private void setSearchHintButtonOnClickListener(){
        viewHolder.search_hint_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "setSearchHintButtonOnClickListener");
                setSearchBoxContainerVisible(true);
                setSearchHintContainerVisible(false);

            }
        });
    }
}

