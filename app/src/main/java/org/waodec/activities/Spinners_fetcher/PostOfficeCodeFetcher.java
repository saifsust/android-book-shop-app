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

public class PostOfficeCodeFetcher {

    private PostOfficeCodeFetcher() {
    }

    public static void ViewPostOfficeCode(RequestQueue requestQueue, final Context mContext, final Spinner postOfficeCode) {


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URLS.GET_POST_OFFICE_CODE, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {

                    Log.i("onResponse", response.toString());
                    ArrayList<String> data = new ArrayList<>();
                    for (int i = 0; i < response.length(); ++i) {
                        data.add(response.getJSONObject(i).get("postOfficeCode").toString());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_dropdown_item_1line, data);
                    postOfficeCode.setAdapter(adapter);


                } catch (Exception ex) {
                    Log.e("onResponse", ex.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Post-Office-Code : ", error.getMessage());
            }
        });

        requestQueue.add(request);

    }
}
