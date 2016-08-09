package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.RenamingDelegatingContext;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.concurrent.TimeUnit;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class JokesTaskInstrTest {
    Context mockContext;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        mockContext = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "test_");
    }

    @Test
    public void shouldReturnNonEmptyString() {
        onView(withId(R.id.button)).perform(click());
        String joke = "";
        try {
            JokesTask jokesTask = new JokesTask();
            jokesTask.execute(mockContext);
            joke = jokesTask.get(30, TimeUnit.SECONDS);
            assertNotNull("not null", joke);
            assertTrue(joke.length() > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
