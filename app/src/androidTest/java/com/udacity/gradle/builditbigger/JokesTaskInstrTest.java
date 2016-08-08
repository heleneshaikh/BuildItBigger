package com.udacity.gradle.builditbigger;

<<<<<<< HEAD
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

=======
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
>>>>>>> d4699c25724a8ae7d18a9f07062b501dfd41df3c
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
<<<<<<< HEAD
import static org.junit.Assert.assertNotNull;
=======
>>>>>>> d4699c25724a8ae7d18a9f07062b501dfd41df3c

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokesTaskInstrTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
<<<<<<< HEAD
    public void shouldReturnNonEmptyString() {
        onView(withId(R.id.button)).perform(click());
        String joke = "";
        try {
//            JokesTask jokesTask = new JokesTask();
//            jokesTask.execute();
//            joke = jokesTask.get(30, TimeUnit.SECONDS);
        } catch(Exception e) {

        }
        assertNotNull("not null", joke);
=======
    public void shouldReceiveNonEmptyString() {
        onView(withId(R.id.button)).perform(click());
//        intended(toPackage("com.udacity.gradle.joke")); //should send intent to JokeActivity in this package
>>>>>>> d4699c25724a8ae7d18a9f07062b501dfd41df3c

    }



}
