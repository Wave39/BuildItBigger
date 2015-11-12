package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.bp.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * GetJokeAsyncTask
 * Created by bp on 11/8/15.
 */

public class GetJokeAsyncTask extends AsyncTask < Void, Void, String > {

    //public final String LOG_TAG = GetJokeAsyncTask.class.getSimpleName();

    private static MyApi myApiService = null;
    private OnGetJokeAsyncTaskCompleted theListener;

    public GetJokeAsyncTask(OnGetJokeAsyncTaskCompleted listener)
    {
        theListener = listener;
    }

    public GetJokeAsyncTask setListener(OnGetJokeAsyncTaskCompleted listener) {
        this.theListener = listener;
        return this;
    }

    @Override
    protected String doInBackground(Void... params) {

        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokes-1125.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        //Log.i(LOG_TAG, "onPostExecute result: " + result);
        theListener.onGetJokeTaskCompleted(result);
    }

    public static interface OnGetJokeAsyncTaskCompleted {
        public void onGetJokeTaskCompleted(String result);
    }
}
