package getmore.com.getmore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import getmore.com.getmore.pageflow.MyPageAdapter;
import getmore.com.getmore.pageflow.ViewPagerHandler;
import getmore.com.getmore.pageflow.menu.ActionBarHandler;


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
        actionBarHandler = new ActionBarHandler(this, pager);
        actionBarHandler.restoreActionBar();
        pager = (ViewPager)findViewById(R.id.viewpager);
        ViewPagerHandler viewPagerHandler = new ViewPagerHandler();
        viewPagerHandler.setPagerOnPageChangeListener(pager,actionBarHandler);
        pager.setAdapter(pageAdapter);
    }



    public List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(MyFragment.newInstance("1"));
        fList.add(MyFragment.newInstance("2"));
        fList.add(MyFragment.newInstance("3"));

        return fList;
    }



}
