package com.wave39.jokedisplaylibrary;

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
    }

}
