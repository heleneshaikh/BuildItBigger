package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Toast.makeText(this, jokeTeller.tellJoke(), Toast.LENGTH_SHORT).show();

    }


}
