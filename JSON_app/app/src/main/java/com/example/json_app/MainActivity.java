package com.example.json_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mque;
    private TextView textView;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.json_string);
        start    = findViewById(R.id.start_button);

        mque = Volley.newRequestQueue(this);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParser();

            }

        });


        
    }

    private void jsonParser() {
        String url = "https://api.myjson.com/bins/9qcwk";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                   for(int i = 0 ; i < response.length(); i++){
                       JSONObject list = response.getJSONObject(i);
                       String img = list.getString("image");

                       textView.setText(img);
                   }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)  {

                error.printStackTrace();
            }
        });

        mque.add(request);
    }
}
