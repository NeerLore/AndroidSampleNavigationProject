package mrwms.com.m_tact.sampleproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mrwms.com.m_tact.sampleproject.R;

/**
 * Created by NeverMore on 2018/07/09.
 */
public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    /**
     * call in onCreate(@Nullable Bundle savedInstanceState)
     * not call setContentView
     *
     * @param savedInstanceState
     * @param layoutid the layoutid of contentview
     */
    protected void onCreate(@Nullable Bundle savedInstanceState, int layoutid) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        //set contentview
        ViewGroup v=findViewById(R.id.contentmain);
        getLayoutInflater().inflate(layoutid,v);

        //set toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navigation
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //navigation header
        View headerView = navigationView.getHeaderView(0);
        TextView tv_name = headerView.findViewById(R.id.tv_name);
        tv_name.setText("Mr.Miss.");
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.navitem_logout:
                break;
            case R.id.navitem_top:

                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
