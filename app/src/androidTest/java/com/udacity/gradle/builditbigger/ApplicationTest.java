package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * ApplicationTest
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testSample() {
        assertEquals(1 + 1, 2);
    }

}