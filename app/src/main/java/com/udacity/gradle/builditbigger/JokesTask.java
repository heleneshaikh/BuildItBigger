package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.heleneshaikh.myapplication.backend.jokesAPI.JokesAPI;
import com.udacity.gradle.joke.JokeActivity;
import com.udacity.gradle.jokes.JokeTeller;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by heleneshaikh on 05/08/16.
 */
public class JokesTask extends AsyncTask<Void, Void, String> {
    Context context;
    JokesAPI jokesAPI = null;

    public JokesTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        //get jokes from backend
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL("http://10.0.2.2:8080/_ah/api/jokesAPI/v1/response");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + '\n');
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            String joke = jsonObject.getString("myData");
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE, joke);
            context.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
