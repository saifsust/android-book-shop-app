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
import org.waodec.activities.urls.URLS;

import java.util.ArrayList;

public class DivisionFetcher {

    private DivisionFetcher() {
    }


    public static void viewDivision(final RequestQueue requestQueue, final Spinner division, final Context context) {


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URLS.GET_DIVISIONS, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    ArrayList<String> data = new ArrayList<String>();
                    for (int i = 0; i < response.length(); ++i) {
                        data.add(response.getJSONObject(i).get("divisionnName").toString());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, data);
                    division.setAdapter(adapter);
                    Log.i("onResponse", response.toString());

                } catch (Exception ex) {
                    Log.e("onResponse", ex.getMessage());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse", error.getMessage());
            }
        });

        requestQueue.add(request);


    }

}
