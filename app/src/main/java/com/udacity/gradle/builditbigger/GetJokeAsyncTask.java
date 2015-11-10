package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.bp.myapplication.backend.myApi.MyApi;

/**
 * GetJokeAsyncTask
 * Created by bp on 11/8/15.
 */

public class GetJokeAsyncTask extends AsyncTask<Void, Void, String> {

    public final String LOG_TAG = GetJokeAsyncTask.class.getSimpleName();

    private static MyApi myApiService = null;

    @Override
    protected String doInBackground(Void... params) {

        return "Async return value 2";

    }

    @Override
    protected void onPostExecute(String result) {
        Log.i(LOG_TAG, "onPostExecute result: " + result);
    }
}
