package Mcommerce.com.miu_pos_system.Views.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import Mcommerce.com.miu_pos_system.R;
import Mcommerce.com.miu_pos_system.Views.Fragment.CategoriesFragment;
import Mcommerce.com.miu_pos_system.Views.Fragment.CustomerFragment;
import Mcommerce.com.miu_pos_system.Views.Fragment.MainFragment;
import Mcommerce.com.miu_pos_system.Views.Fragment.OrdersFragment;
import Mcommerce.com.miu_pos_system.Views.Fragment.ProductsFragment;
import Mcommerce.com.miu_pos_system.Views.Fragment.StaffsFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.draw_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvTabName)
    TextView tvTabName;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        setSupportActionBar(toolbar);
        toolbarAction();
        loadDefaultFragment();
        itemSelectAction();
    }


    private void loadDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new MainFragment());
        fragmentTransaction.commit();
    }

    private void replaceFragement(Object o) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, (Fragment) o);
        fragmentTransaction.commit();
    }

    private void itemSelectAction() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    private void toolbarAction() {
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    private void linkViews() {
        ButterKnife.bind(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                replaceFragement(new MainFragment());
                tvTabName.setText("Home");
                break;
            case R.id.nav_order:
                replaceFragement(new OrdersFragment());
                tvTabName.setText("Order");
                break;
            case R.id.nav_products:
                replaceFragement(new ProductsFragment());
                tvTabName.setText("Product");
                break;
            case R.id.nav_cate:
                replaceFragement(new CategoriesFragment());
                tvTabName.setText("Category");
                break;
            case R.id.nav_staff:
                replaceFragement(new StaffsFragment());
                tvTabName.setText("Staff");
                break;
            case R.id.nav_customer:
                replaceFragement(new CustomerFragment());
                tvTabName.setText("Customer");
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_bar, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        searchView = (SearchView) menu.findItem(R.id.search_view).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTabName.setVisibility(View.GONE);
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                tvTabName.setVisibility(View.VISIBLE);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}