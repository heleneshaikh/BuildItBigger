package com.udacity.gradle.builditbigger.free;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.udacity.gradle.builditbigger.JokeActivity;
import com.udacity.gradle.builditbigger.JokeEvent;
import com.udacity.gradle.builditbigger.JokesTask;
import com.udacity.gradle.builditbigger.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageEvent(JokeEvent event){
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, event.joke);
        startActivity(intent);
    }

    public void tellJoke(View view) {
        JokesTask jokesTask = new JokesTask();
        jokesTask.execute(this);
    }
}
