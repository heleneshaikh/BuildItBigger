package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        jokesTask.execute(this);

        JokeTeller jokeTeller = new JokeTeller();
        Intent intent = new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, jokeTeller.tellJoke());
        startActivity(intent);
    }
}
