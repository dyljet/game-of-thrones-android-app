package com.example.gameofquestions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.ShareActionProvider;

import com.example.gameofquestions.HousePagE.HouseTestFrag;
import com.example.gameofquestions.LoginPagE.Login;
import com.example.gameofquestions.QuizPagE.QuizPageFrag;
import com.example.gameofquestions.TheoryPagE.TheoryMainPage;

public class NavigationDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
private ShareActionProvider mShareActionProvider;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer2);
        View view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new HouseTestFrag());
        ft.commit();
 // default screen
        navigationView.setCheckedItem(R.id.nav_house);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // share button in the toolbar to share app
        getMenuInflater().inflate(R.menu.navigation_drawer, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Hey I know you love Game of thrones, try out this app from the PlayStore");

return super.onCreateOptionsMenu(menu) ;

    }

    private void setShareActionIntent(String your_message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,your_message);
        mShareActionProvider.setShareIntent(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {




        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_theory) {
            Intent i = new Intent(NavigationDrawer.this, TheoryMainPage.class);
            startActivity(i);
        } else if (id == R.id.nav_house) {
            //Intent i = new Intent(NavigationDrawer.this,HousePage.class);
           // startActivity(i);
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new HouseTestFrag());
            ft.commit();
        } else if (id == R.id.nav_quiz) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new QuizPageFrag());
            ft.commit();

        }
        else if (id == R.id.nav_viewG) {
            Intent i = new Intent(NavigationDrawer.this, ViewerGuide.class);
            startActivity(i);


        } else if (id == R.id.nav_logout){

            Intent i = new Intent(NavigationDrawer.this, Login.class);
            startActivity(i);
        }
        else if (id == R.id.nav_userG){

            Intent i = new Intent(NavigationDrawer.this, UserGuide.class);
            startActivity(i);

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
