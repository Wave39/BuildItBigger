package com.wave39.jokedisplaylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

/**
 * JokeDisplayActivity
 * Created by bp on 11/7/15.
 */

public class JokeDisplayActivity extends ActionBarActivity {

    public final String LOG_TAG = JokeDisplayActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        Log.i(LOG_TAG, "onCreate");

        String theJoke;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                theJoke = null;
            } else {
                theJoke = extras.getString(Intent.EXTRA_TEXT);
            }

        } else {
            theJoke = (String) savedInstanceState.getSerializable(Intent.EXTRA_TEXT);
        }

        Log.i(LOG_TAG, "The joke is: " + theJoke);
    }

}
