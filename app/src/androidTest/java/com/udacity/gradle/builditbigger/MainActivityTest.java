package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.ContextThemeWrapper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * MainActivityTest
 * Created by bp on 11/10/15.
 */

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    public Intent mLaunchIntent;
    public MainActivity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public MainActivityTest(Class<MainActivity> activityClass)
    {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ContextThemeWrapper context = new ContextThemeWrapper(getInstrumentation().getTargetContext(), R.style.AppTheme);
        setActivityContext(context);
        mLaunchIntent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        mainActivity = launchActivity("com.udacity.gradle.builditbigger", MainActivity.class, null);
        setActivity(mainActivity);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @MediumTest
    public void testSample() {
        assertEquals(2 + 2, 4);
    }

//    @MediumTest
//    public void testAsyncTask() {
//        String joke = null;
//        try {
//            GetJokeAsyncTask jokeTask = new GetJokeAsyncTask(null);
//            jokeTask.execute();
//            joke = jokeTask.get(30, TimeUnit.SECONDS);
//            Log.i("Test", "Joke: " + joke);
//        } catch (Exception e){
//            Log.i("Test", "Timed out");
//            fail("Timed out");
//        }
//
//        assertNotNull(joke);
//    }

    public void testSomeAsyncTask() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        final GetJokeAsyncTask jokeTask = new GetJokeAsyncTask(null);
        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                jokeTask.execute();
            }
        });

        signal.await(30, TimeUnit.SECONDS);
        assertTrue("Happiness", true);
    }
}
