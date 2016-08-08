package com.udacity.gradle.joke;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.androidjokes.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class JokeActivity extends Activity {
//    public static final String JOKE = "Joke";

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

//    @Subscribe
//    public void onMessageEvent(JokeEvent event){
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

//        String joke = getIntent().getStringExtra(JOKE);
//        TextView textView = (TextView) findViewById(R.id.joke_tv);
//        textView.setText(joke);
    }
}
