package getmore.com.getmore.menu;

import android.app.ActionBar;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import getmore.com.getmore.R;

/**
 * Created by zhongqinng on 30/12/14.
 */
public class ActionBarHandler {
    public String TAG = "ActionBarHandler";
    public Activity mActivity;
    private View cView;
    private ActionBarViewHolder actionBarViewHolder;

    class ActionBarViewHolder{
        ImageButton home_btn;
        ImageButton friends_btn;
        ImageButton points_btn;
    }

    public ActionBarHandler(Activity mActivity){
        this.mActivity=mActivity;
        actionBarViewHolder = new ActionBarViewHolder();
    }

    public void restoreActionBar() {
        //   ActionBar actionBar = getActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setTitle(mTitle);

        ActionBar actionBar = mActivity.getActionBar();
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

        actionBarViewHolder.home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.i(TAG, "actionBarViewHolder.home_btn.setOnClickListener");
                Toast.makeText(mActivity.getApplicationContext(), "Home Btn", Toast.LENGTH_SHORT).show();
                set_home_btn_selected(true);
                set_friends_btn_selected(false);
                set_points_btn_selected(false);

            }
        });


        actionBarViewHolder.friends_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.i(TAG, "actionBarViewHolder.friends_btn.setOnClickListener");
                Toast.makeText(mActivity.getApplicationContext(), "Friends Btn", Toast.LENGTH_SHORT).show();
                set_home_btn_selected(false);
                set_friends_btn_selected(true);
                set_points_btn_selected(false);

            }
        });


        actionBarViewHolder.points_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.i(TAG, "actionBarViewHolder.points_btn.setOnClickListener");
                Toast.makeText(mActivity.getApplicationContext(), "Points Btn", Toast.LENGTH_SHORT).show();
                set_home_btn_selected(false);
                set_friends_btn_selected(false);
                set_points_btn_selected(true);

            }
        });

        actionBar.setCustomView(cView);
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

}
