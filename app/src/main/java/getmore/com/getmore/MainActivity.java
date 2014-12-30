package getmore.com.getmore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import getmore.com.getmore.menu.ActionBarHandler;


public class MainActivity extends FragmentActivity {
    private String TAG = "MainActivity";
    private MyPageAdapter pageAdapter;
    private ActionBarHandler actionBarHandler;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        setPagerOnPageChangeListener();



        instantiate_action_bar();
    }

    public void instantiate_action_bar(){
        actionBarHandler = new ActionBarHandler(this, pager);
        actionBarHandler.restoreActionBar();
    }

    public List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(MyFragment.newInstance("1"));
        fList.add(MyFragment.newInstance("2"));
        fList.add(MyFragment.newInstance("3"));

        return fList;
    }

    private void setPagerOnPageChangeListener(){
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int index) {
                Log.d(TAG,"page: "+index);
                switch (index){
                    case 0:
                        actionBarHandler.set_home_btn_active();
                        break;
                    case 1:
                        actionBarHandler.set_friends_btn_active();
                        break;
                    case 2:
                        actionBarHandler.set_points_btn_active();
                        break;
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }


}
