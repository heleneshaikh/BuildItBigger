package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.udacity.gradle.joke.JokeActivity;
import com.udacity.gradle.jokes.JokeTeller;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        JokesTask jokesTask = new JokesTask();
        jokesTask.execute();


         /*
        STEP 1: Make the button display a toast showing a joke retrieved from your Java joke telling
        library.
        Toast.makeText(this, jokeTeller.tellJoke(), Toast.LENGTH_SHORT).show();
        */

        /*
        STEP 2: Create an Android Library containing an Activity that will display a joke passed to
        it as an intent extra. Wire up project dependencies so that the button can now pass the joke
        from the Java Library to the Android Library.

        JokeTeller jokeTeller = new JokeTeller();
        Intent intent = new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, jokeTeller.tellJoke());
        startActivity(intent);
         */
    }


}
