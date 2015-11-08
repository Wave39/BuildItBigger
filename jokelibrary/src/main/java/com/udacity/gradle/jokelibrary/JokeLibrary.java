package com.udacity.gradle.jokelibrary;

import java.util.Random;

public class JokeLibrary {

    private static String[] theJokes = {
            "A Googler, a rabbi, and Jimi Hendrix walk into a bar...",
            "There was a young lady from Nantucket...",
            "There was a young lady from Venus...",
            "Knock knock...",
            "Did you hear the one about the human cannonball..."
    };

    public static String getJoke() {
        Random r = new Random();
        int idx = r.nextInt(theJokes.length);
        return theJokes[idx];
    }

}
