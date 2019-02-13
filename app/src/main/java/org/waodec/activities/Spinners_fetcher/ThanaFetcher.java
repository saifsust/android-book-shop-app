package org.waodec.activities.Spinners_fetcher;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.waodec.activities.urls.URLS;

import java.util.ArrayList;
import java.util.List;

public class ThanaFetcher {
    private Spinner thanaView;
    private RequestQueue requestQueue;
    private Context mContext;


    public ThanaFetcher(Spinner thanaView, RequestQueue requestQueue, Context mContext) {
        this.thanaView = thanaView;
        this.requestQueue = requestQueue;
        this.mContext = mContext;
        doInBackground();

    }

    private void doInBackground() {


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URLS.GET_THANA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    Log.i("onResponse", response.toString());

                    List<String> data = new ArrayList<String>();

                    for (int i = 0; i < response.length(); ++i) {
                        JSONObject obj = response.getJSONObject(i);
                        data.add(obj.get("thana_name").toString());
                    }



                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_dropdown_item_1line, data);
                    thanaView.setAdapter(arrayAdapter);


                } catch (Exception ex) {
                    Log.e("Thana onResponse : ", ex.getMessage());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ThanaFetcher ERROR", error.getMessage());
            }
        });
        requestQueue.add(request);

    }


}
