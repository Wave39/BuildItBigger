package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * ApplicationTest
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest extends ApplicationTestCase<Application> {

    String jokeString;

    public ApplicationTest() {
        super(Application.class);
    }

    public void testSample() {
        assertEquals(1 + 1, 2);
    }

    public void testAlbumGetTask() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        GetJokeAsyncTask task = new GetJokeAsyncTask();
        task.setListener(new GetJokeAsyncTask.OnGetJokeAsyncTaskCompleted() {
            @Override
            public void onGetJokeTaskCompleted(String result) {
                jokeString = result;
                signal.countDown();
            }
        }).execute();
        signal.await();

        assertFalse("Joke is empty", TextUtils.isEmpty(jokeString));
    }
}