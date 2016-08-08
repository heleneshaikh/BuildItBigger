package com.udacity.gradle.joke;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.hfad.androidjokes.R;

public class JokeActivity extends Activity {
    public static final String JOKE = "Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(JOKE);
        TextView textView = (TextView) findViewById(R.id.joke_tv);
        textView.setText(joke);
    }
}
