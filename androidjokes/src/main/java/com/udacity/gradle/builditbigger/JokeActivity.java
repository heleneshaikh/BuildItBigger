package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.hfad.androidjokes.R;

public class JokeActivity extends Activity {


    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView textView = (TextView) findViewById(R.id.joke_tv);
        textView.setText(getIntent().getStringExtra(JOKE));
    }
}
