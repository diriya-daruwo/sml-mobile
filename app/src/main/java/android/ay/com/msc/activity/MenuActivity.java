package android.ay.com.msc.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.ay.com.msc.adapter.NavDrawerListAdapter;
import android.ay.com.msc.bean.NavDrawerBean;
import android.ay.com.msc.fragment.AppointmentFragment;
import android.ay.com.msc.fragment.HistoryFragment;
import android.ay.com.msc.fragment.HomeFragment;
import android.ay.com.msc.fragment.NotificationFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.ay.com.msc.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends ActionBarActivity {

    private Toolbar toolbar;


    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawerLinear;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] navMenuTitles;
    private NavDrawerListAdapter adapter;
    private ArrayList<NavDrawerBean> navDrawerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

//            ActionBar customActionBar = getActionBar();
//
//            customActionBar.setIcon(null);
//            customActionBar.hide();
//            customActionBar.show();



            setContentView(R.layout.activity_menu);

            UIInitialize();

            displayView(0);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void UIInitialize() throws Exception{

        try {



            mTitle = mDrawerTitle = getTitle();


            toolbar = (Toolbar) findViewById(R.id.tool_bar);
            toolbar.setTitle("");
            toolbar.setNavigationIcon(R.drawable.list_selector);
            setSupportActionBar(toolbar);


            navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

            mDrawerLayout     = (DrawerLayout) findViewById(R.id.drawer_layout);
            mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

            mDrawerList       = (ListView) findViewById(R.id.list_slidermenu);
            mDrawerLinear     = (LinearLayout) findViewById(R.id.navContainerLinearLayout);

            navDrawerItems = new ArrayList<NavDrawerBean>();

            navDrawerItems.add(new NavDrawerBean(navMenuTitles[0],false,0));
            navDrawerItems.add(new NavDrawerBean(navMenuTitles[1],false,0));
            navDrawerItems.add(new NavDrawerBean(navMenuTitles[2],false,0));
            navDrawerItems.add(new NavDrawerBean(navMenuTitles[3],true,3));
            navDrawerItems.add(new NavDrawerBean(navMenuTitles[4],false,0));
            navDrawerItems.add(new NavDrawerBean(navMenuTitles[5], false, 0));
            navDrawerItems.add(new NavDrawerBean(navMenuTitles[6],false,0));
            mDrawerList.setOnItemClickListener(new SlideMenuClickListener());


            adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
            mDrawerList.setAdapter(adapter);


            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,toolbar,R.string.app_name,
                    R.string.app_name ) {

                public void onDrawerClosed(View view) {


//                    getActionBar().setTitle(mTitle);
                    invalidateOptionsMenu();

                }

                public void onDrawerOpened(View drawerView) {
//                    getActionBar().setTitle(mDrawerTitle);
                    invalidateOptionsMenu();


                }
            };

            mDrawerLayout.setDrawerListener(mDrawerToggle);

        }catch (Exception e){
            throw e;
        }
    }

    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            displayView(position);
        }
    }



    private void displayView(int position) {

        try {


            Fragment fragment = null;


            switch (position) {
                case 0:

                    fragment = new HomeFragment();

                    break;

                case 1:

                    fragment = new AppointmentFragment();

                    break;

                case 2:

//                    fragment = new AppointmentFragment();

                    break;

                case 3:

                    fragment = new NotificationFragment();

                    break;

                case 4:

                    fragment = new HistoryFragment();

                    break;




                default:
                    break;
            }

            setUpFragment(fragment, position);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setUpFragment(Fragment fragment,int position ){

        try {




            if (fragment != null) {


                FragmentManager fragmentManager = getSupportFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();



                    mDrawerList.setItemChecked(position, true);
                    mDrawerList.setSelection(position);
                    setTitle(navMenuTitles[position]);
                    mDrawerLayout.closeDrawer(mDrawerLinear);



            } else {
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
