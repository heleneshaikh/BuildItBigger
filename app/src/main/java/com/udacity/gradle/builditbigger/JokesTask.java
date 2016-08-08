package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.example.heleneshaikh.myapplication.backend.jokesAPI.JokesAPI;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.joke.JokeActivity;
import java.io.IOException;

/**
 * Created by heleneshaikh on 05/08/16.
 */
public class JokesTask extends AsyncTask<Context, Void, String> {
    private static JokesAPI myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Context...params) {
        if(myApiService == null) {  // Only do this once
            JokesAPI.Builder builder = new JokesAPI.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.tellJoke().execute().getData(); //check that this returns a non-empty string
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE, result);
        context.startActivity(intent);
    }
}
