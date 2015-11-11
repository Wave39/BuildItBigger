package com.wave39.jokedisplaylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * JokeDisplayActivity
 * Created by bp on 11/7/15.
 */

public class JokeDisplayActivity extends AppCompatActivity {

    //public final String LOG_TAG = JokeDisplayActivity.class.getSimpleName();

    String theJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity);

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

        //Log.i(LOG_TAG, "The joke is: " + theJoke);

        TextView textView = (TextView) this.findViewById(R.id.joke_text_view);
        textView.setText(theJoke);
    }

}
