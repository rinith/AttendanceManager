package com.techpalle.attendancemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager mgr = getSupportFragmentManager();
            FragmentTransaction t = mgr.beginTransaction();
            NewOrImportFragment nf = new NewOrImportFragment();
            t.add(R.id.container1, nf);
            t.commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadSubjectList() {

        SQLiteDatabase db = openOrCreateDatabase("techpalle", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS subjects(subject_name varchar)");

        FragmentManager mgr = getSupportFragmentManager();
        FragmentTransaction t = mgr.beginTransaction();
        SubjectListFragment slf = new SubjectListFragment();
        t.replace(R.id.container1, slf);
        t.addToBackStack(null); //remember previous screen - back button works
        t.commit();
    }

    public void addSubject(String sub) {

        SQLiteDatabase db = openOrCreateDatabase("techpalle", MODE_PRIVATE, null);
        // Save and Add
        int num = 0;
        if (!checkinvalid(sub)) {

                db.execSQL("INSERT INTO subjects VALUES('" + sub + "')");
            Toast.makeText(this, "Subject added", Toast.LENGTH_SHORT).show();
                num++;
            }
            else {
            Toast.makeText(this, "Please add some subject..", Toast.LENGTH_SHORT).show();
        }

        }


    public static boolean checkinvalid(String s){
        int no_of_spaces=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                no_of_spaces++;
            }
        }

        return no_of_spaces==s.length() || s.equals("");

    }





    }

