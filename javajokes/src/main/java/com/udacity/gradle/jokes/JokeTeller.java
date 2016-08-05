package com.udacity.gradle.jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by heleneshaikh on 04/08/16.
 */

public class JokeTeller {
    public String tellJoke() {
        List<String> jokes = new ArrayList<>();
        jokes.add("What has a mouth but no teeth? A river.");
        jokes.add("If i had a dollar for every girl that found me unattractive, they would eventually find me attractive.");
        jokes.add("Life is like toilet paper, you're either on a roll or taking shit from some asshole.");
        jokes.add("Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?");
        Random random = new Random();
        int value = random.nextInt(4);
        return jokes.get(value);
    }
}

