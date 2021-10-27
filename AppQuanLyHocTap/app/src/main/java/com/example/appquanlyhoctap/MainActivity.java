package com.example.appquanlyhoctap;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlyhoctap.Adapter.OptionAdapter;
import com.example.appquanlyhoctap.Model.Item;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout mDrawer;
    Toolbar toolbar;
    ActionBar actionBar;

    ListView listView;
    OptionAdapter optionAdapter;
    List<Item> optionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        init();
    }

    public void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_black_24dp);
        mDrawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_dashBoard:
                toolbar.setTitle("Home");
                break;
            case R.id.nav_classes:
                toolbar.setTitle("Classes");
                break;
            case R.id.nav_calendar:
                toolbar.setTitle("Calendar");
                break;
            case R.id.nav_notifications:
                toolbar.setTitle("notifications");
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        MenuItem actionMenuItem = menu.findItem(R.id.overflowMenu);
        actionMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return false;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return false;
            }
        });
        return true;
    }

    public void displayAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.custom_dialog_user_profile, null);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        listView = alertLayout.findViewById(R.id.listView);
        optionList = new ArrayList<>();
        optionList.add(new Item(R.drawable.ic_account_box_black_24dp, "Your Profile"));
        optionList.add(new Item(R.drawable.ic_settings_black_24dp, "Settings"));
        optionList.add(new Item(R.drawable.ic_logout_black_24dp, "Logout"));
        optionAdapter = new OptionAdapter(MainActivity.this, R.layout.optionrow, optionList);
        listView.setAdapter(optionAdapter);
        setOnclick();
        alert.setView(alertLayout);
        alert.setCancelable(true);
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void setOnclick() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = optionList.get(position);
                switch (item.getText()) {
                    case "Your profile":
                        break;
                    case "Settings":
                        break;
                    case "Logout":
                        logout();
                        break;
                }
            }
        });
    }

    public boolean logout () {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
            case R.id.overflowMenu:
                Log.d("phat", "onOptionsItemSelected: lol");
                displayAlertDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
