package sulthon.com.iwaktrial.activity;

import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import sulthon.com.iwaktrial.R;
import sulthon.com.iwaktrial.font.LatoFont;
import sulthon.com.iwaktrial.fragment.DataKolamFragment;
import sulthon.com.iwaktrial.fragment.LaporanKematianFragment;
import sulthon.com.iwaktrial.fragment.LaporanPakanFragment;
import sulthon.com.iwaktrial.fragment.LaporanHarianMainFragment;
import sulthon.com.iwaktrial.fragment.ProgramPakanEndFragment;
import sulthon.com.iwaktrial.fragment.ProgramPakanMainFragment;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private View navigationHeader;
    private TextView menuLabel, toolbarTitle;
    private Toolbar toolbar;
    private Typeface latoRegular;

    //toolbar title
    private String[] activityTitles;

    //flag to load home fragment when user presses back key
    private boolean shouldLoadHomeFragmentOnBackPressed = true;
    private Handler handler;

    private int navigationItemIndex;

    //tags used to attach the fragment
    public static final String TAG_LAPORAN_HARIAN = "laporan_harian";
    public static final String TAG_LAPORAN_PAKAN = "laporan_pakan_terimakasih";
    public static final String TAG_LAPORAN_KEMATIAN = "laporan_kematian_terimakasih";
    public static final String TAG_PROGRAM_PAKAN_MAIN = "program_pakan";
    public static final String TAG_PROGRAM_PAKAN_END = "program_pakan_terimakasih";
    public static final String TAG_DATA_KOLAM = "data_kolam";
    public static String CURRENT_TAG = TAG_LAPORAN_HARIAN;

    //Key for communicating between child and parrent
    public static final String Key_CHANGE_FRAGMENT = "ganti_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        handler = new Handler();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        prepareToolbar();
        prepareNavigationView();

        //initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navigationItemIndex = 0;
            loadFragment();
        }

    }

    private void prepareToolbar() {
        //Load toolbarItem
        activityTitles = getResources().getStringArray(R.array.activity_titles);

        //getting font type
        latoRegular = Typeface.createFromAsset(getAssets(), LatoFont.LATO_REGULAR);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);
        toolbar.setSubtitle(null);
        toolbarTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        toolbarTitle.setTypeface(latoRegular);
    }

    private void setToolbarTitle() {
        if (navigationItemIndex == 0) {
            toolbarTitle.setText(activityTitles[0]);
        } else if (navigationItemIndex < 3) {
            toolbarTitle.setText(activityTitles[1]);
        } else if (navigationItemIndex < 5) {
            toolbarTitle.setText(activityTitles[2]);
        } else if (navigationItemIndex == 5) {
            toolbarTitle.setText(activityTitles[3]);
        }
    }

    private void prepareNavigationView() {

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //NavigationView Header
        navigationHeader = navigationView.getHeaderView(0);
        menuLabel = (TextView) navigationHeader.findViewById(R.id.tv_label_menu);
        menuLabel.setTypeface(latoRegular);

        //Apply font to menu item
        Menu menu = navigationView.getMenu();

        for (int i=0; i<menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);

            //for applying a font to SubMenu
            SubMenu subMenu = menuItem.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j=0; j<subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem();
                    SpannableString spannableString = new SpannableString(subMenuItem.getTitle());
                    spannableString.setSpan(new TypefaceSpan(LatoFont.LATO_REGULAR), 0,
                            spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    subMenuItem.setTitle(spannableString);
                }
            }
        }
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_harian:
                        navigationItemIndex = 0;
                        CURRENT_TAG = TAG_LAPORAN_HARIAN;
                        break;
                    case R.id.menu_program_pakan:
                        navigationItemIndex = 3;
                        CURRENT_TAG = TAG_LAPORAN_PAKAN;
                        break;
                    case R.id.menu_data_kolam:
                        navigationItemIndex = 5;
                        CURRENT_TAG = TAG_DATA_KOLAM;
                        break;
                }
                unCheckAllMenuItems();
                loadFragment();
                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                (this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }

    private void unCheckAllMenuItems() {
        final Menu menu = navigationView.getMenu();
        for (int i=0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            if (item.hasSubMenu()) {
                SubMenu subMenu = item.getSubMenu();
                for (int j=0; j<subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    subMenuItem.setChecked(false);
                }
            } else {
                item.setChecked(false);
            }
        }
    }

    private void loadFragment() {

        // selecting appropriate navigation menu item
        selectNavigationMenu();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawerLayout.closeDrawers();

        } else {
            // Sometimes, when fragment has huge data, screen seems hanging
            // when switching between navigation menus
            // So using runnable, the fragment is loaded with cross fade effect
            // This effect can be seen in GMail app
            Runnable mPendingRunnable = new Runnable() {
                @Override
                public void run() {

                    // update the main content by replacing fragments
                    Fragment fragment = getFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                    fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                            android.R.anim.fade_out);
                    fragmentTransaction.replace(R.id.content_frame, fragment, CURRENT_TAG);
                    fragmentTransaction.commitAllowingStateLoss();

                    // set toolbar title
                    setToolbarTitle();
                }
            };

            if (mPendingRunnable != null) {
                handler.post(mPendingRunnable);
            }

            //set toolbar title
            setToolbarTitle();

            //closing drawer on item click
            drawerLayout.closeDrawers();

            //refresh toolbar menu
            invalidateOptionsMenu();
        }
    }

    private void selectNavigationMenu() {
        if (navigationItemIndex == 0) {
            navigationView.getMenu().getItem(0).setChecked(true);
        }
        else if (navigationItemIndex == 3) {
            navigationView.getMenu().getItem(1).setChecked(true);
        }
        else if (navigationItemIndex == 5) {
            navigationView.getMenu().getItem(2).setChecked(true);
        }
    }

    private Fragment getFragment() {
        switch (navigationItemIndex) {
            case 0:
                return LaporanHarianMainFragment.newInstance();
            case 1:
                return LaporanPakanFragment.newInstance();
            case 2:
                return LaporanKematianFragment.newInstance();
            case 3:
                return ProgramPakanMainFragment.newInstance();
            case 4:
                return ProgramPakanEndFragment.newInstance();
            case 5:
                return DataKolamFragment.newInstance();
            default:
                return LaporanHarianMainFragment.newInstance();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragmentOnBackPressed) {
            // checking if user is on other navigation menu
            // rather than home
            if (navigationItemIndex != 0  ) {
                navigationItemIndex = 0;
                CURRENT_TAG = TAG_LAPORAN_HARIAN;
                loadFragment();
                return;
            }
        }
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(Bundle bundle){
        if (bundle.containsKey(Key_CHANGE_FRAGMENT)){
            switch (bundle.getInt(Key_CHANGE_FRAGMENT)){
                case 0:
                    navigationItemIndex = 0;
                    CURRENT_TAG = TAG_LAPORAN_HARIAN;
                    break;
                case 1:
                    navigationItemIndex = 1;
                    CURRENT_TAG = TAG_LAPORAN_PAKAN;
                    break;
                case 2:
                    navigationItemIndex = 2;
                    CURRENT_TAG = TAG_LAPORAN_KEMATIAN;
                    break;
                case 3:
                    navigationItemIndex = 3;
                    CURRENT_TAG = TAG_PROGRAM_PAKAN_MAIN;
                    break;
                case 4:
                    navigationItemIndex = 4;
                    CURRENT_TAG = TAG_PROGRAM_PAKAN_END;
                    break;
                case 5:
                    navigationItemIndex = 5;
                    CURRENT_TAG = TAG_DATA_KOLAM;
                    break;
            }
            unCheckAllMenuItems();
            loadFragment();
        }
    }
}
