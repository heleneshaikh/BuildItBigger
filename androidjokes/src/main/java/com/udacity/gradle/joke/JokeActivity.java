package com.udacity.gradle.joke;

import android.app.Activity;
import android.os.Bundle;
import com.hfad.androidjokes.R;
import org.greenrobot.eventbus.EventBus;

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
