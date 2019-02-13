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

public class ZelaFetcher {

    private Spinner zela;
    private Context mContext;
    private RequestQueue requestQueue;

    public ZelaFetcher(Spinner zela, RequestQueue requestQueue, Context mContext) {
        this.zela = zela;
        this.mContext = mContext;
        this.requestQueue = requestQueue;

        onDoBackground();
    }

    private void onDoBackground() {


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URLS.GEL_ZELA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {


                try {

                    Log.i("onResponse", response.toString());

                    ArrayList<String> data = new ArrayList<>();


                    for (int i = 0; i < response.length(); ++i) {
                        data.add(response.getJSONObject(i).get("zela_name").toString());
                    }


                    ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_dropdown_item_1line, data);
                    zela.setAdapter(adapter);

                } catch (Exception ex) {
                    Log.e("Zela Fetcher", ex.getMessage());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ZELA Fetcher", error.getMessage());
            }
        });

        requestQueue.add(request);


    }


}
