package getmore.com.getmore.pageflow.menu;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import getmore.com.getmore.R;

/**
 * Created by zhongqinng on 30/12/14.
 */
public class ActionBarHandler {
    public String TAG = "ActionBarHandler";
    public Activity mActivity;
    private View cView;
    private ActionBarViewHolder actionBarViewHolder;
    private ActionBar actionBar;
    private ViewPager pager;

    class ActionBarViewHolder{
        ImageButton home_btn;
        ImageButton friends_btn;
        ImageButton points_btn;
        TextView user_id;
        LinearLayout spinner_placeholder;

    }

    public ActionBarHandler(FragmentActivity mActivity, ViewPager pager){
        this.pager=pager;
        this.mActivity=mActivity;
        actionBarViewHolder = new ActionBarViewHolder();

    }

    public void restoreActionBar() {


        setActionBar();
        ActionBarWebService actionBarWebService = new ActionBarWebService(this);
        actionBarWebService.landing_page();



    }



    private void set_home_btn_selected(boolean selected){
        if(selected){
            actionBarViewHolder.home_btn.setImageResource(R.drawable.home);
        }else{
            actionBarViewHolder.home_btn.setImageResource(R.drawable.home_grey);
        }
    }

    private void set_friends_btn_selected(boolean selected){
        if(selected){
            actionBarViewHolder.friends_btn.setImageResource(R.drawable.friends);
        }else{
            actionBarViewHolder.friends_btn.setImageResource(R.drawable.friends_grey);
        }
    }

    private void set_points_btn_selected(boolean selected){
        if(selected){
            actionBarViewHolder.points_btn.setImageResource(R.drawable.points);
        }else{
            actionBarViewHolder.points_btn.setImageResource(R.drawable.points_grey);
        }
    }

    public void setActionBar(){
        actionBar = mActivity.getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayOptions(actionBar.DISPLAY_SHOW_CUSTOM);
        cView = mActivity.getLayoutInflater().inflate(R.layout.actionbar, null);
        actionBarViewHolder.home_btn = (ImageButton) cView.findViewById(R.id.home_btn);
        actionBarViewHolder.friends_btn = (ImageButton) cView.findViewById(R.id.friends_btn);
        actionBarViewHolder.points_btn = (ImageButton) cView.findViewById(R.id.points_btn);
        actionBarViewHolder.user_id = (TextView) cView.findViewById(R.id.user_id);
        actionBarViewHolder.spinner_placeholder = (LinearLayout) cView.findViewById(R.id.spinner_placeholder);

        actionBarViewHolder.home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "actionBarViewHolder.home_btn.setOnClickListener");
//                Toast.makeText(mActivity.getApplicationContext(), "Home Btn", Toast.LENGTH_SHORT).show();
                set_home_btn_active();
                pager.setCurrentItem(0);

            }
        });


        actionBarViewHolder.friends_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "actionBarViewHolder.friends_btn.setOnClickListener");
//                Toast.makeText(mActivity.getApplicationContext(), "Friends Btn", Toast.LENGTH_SHORT).show();
                set_friends_btn_active();
                pager.setCurrentItem(1);

            }
        });


        actionBarViewHolder.points_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "actionBarViewHolder.points_btn.setOnClickListener");
//                Toast.makeText(mActivity.getApplicationContext(), "Points Btn", Toast.LENGTH_SHORT).show();
                set_points_btn_active();
                pager.setCurrentItem(2);

            }
        });
        actionBar.setCustomView(cView);
    }

    public void set_home_btn_active(){
        set_home_btn_selected(true);
        set_friends_btn_selected(false);
        set_points_btn_selected(false);
    }

    public void set_friends_btn_active(){
        set_home_btn_selected(false);
        set_friends_btn_selected(true);
        set_points_btn_selected(false);
    }

    public void set_points_btn_active(){
        set_home_btn_selected(false);
        set_friends_btn_selected(false);
        set_points_btn_selected(true);
    }

    public void setActionBarHandlerAfterWebServiceCall(String user_id) {
        setActionBar();
        actionBarViewHolder.spinner_placeholder.setVisibility(View.GONE);
        actionBarViewHolder.user_id.setText("ID: "+user_id);

        actionBar.setCustomView(cView);
    }

}
