package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

/**
 * MainActivityTest
 * Created by bp on 11/10/15.
 */

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    private MainActivity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class), null, null);
        mActivity = (MainActivity)getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSample() {
        assertEquals(2 + 2, 5);
    }

//    public void testAsyncTask() {
//        try {
//            GetJokeAsyncTask jokeTask = new GetJokeAsyncTask();
//            jokeTask.execute(this);
//            joke = jokeTask.get(30, TimeUnit.SECONDS);
//        } catch (Exception e){
//            fail("Timed out");
//        }
//    }

}
