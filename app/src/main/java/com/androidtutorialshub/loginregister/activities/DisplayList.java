package com.androidtutorialshub.loginregister.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.adapters.DisplayAdapter;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

import java.util.ArrayList;

public class DisplayList extends Activity {

    private DatabaseHelper mHelper;
    private SQLiteDatabase dataBase;

    //variables to hold staff records
    private ArrayList<String> stafid = new ArrayList<String>();
    private ArrayList<String> nama = new ArrayList<String>();
    private ArrayList<String> jbt = new ArrayList<String>();
    private ArrayList<String> hobies = new ArrayList<String>();
    private ArrayList<String> gender = new ArrayList<String>();

    private ListView userList;
    private AlertDialog.Builder build;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        userList = (ListView) findViewById(R.id.List);

        mHelper = new DatabaseHelper(this);


    }

    @Override
    protected void onResume() {
        //refresh data for screen is invoked/displayed
        displayData();
        super.onResume();
    }

    /**
     * displays data from SQLite
     */
    private void displayData() {
        dataBase = mHelper.getWritableDatabase();
        //the SQL command to fetched all records from the table
        Cursor mCursor = dataBase.rawQuery("SELECT * FROM "
                + DatabaseHelper.TABLE_USER, null);

        //reset variables
        stafid.clear();
        nama.clear();
        jbt.clear();

        //fetch each record
        if (mCursor.moveToFirst()) {
            do {
                //get data from field
                stafid.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_USER_NAME)));
                nama.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_USER_EMAIL)));
                jbt.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_USER_PASSWORD)));
                hobies.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_USER_HOBBIES)));
                gender.add(mCursor.getString(mCursor.getColumnIndex(DatabaseHelper.COLUMN_USER_GENDER)));

            } while (mCursor.moveToNext());
            //do above till data exhausted
        }

        //display to screen
        DisplayAdapter disadpt = new DisplayAdapter(DisplayList.this, stafid, nama, jbt,hobies,gender);
        userList.setAdapter(disadpt);
        mCursor.close();
    }//end displayData


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.display_list, menu);
        return true;
    }

}