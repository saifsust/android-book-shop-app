package org.waodec.activities.volleies;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.waodec.activities.entities.Thana;

public class ThanaResponseListener implements Response.Listener<JSONArray>, Response.ErrorListener {

    @Override
    public void onResponse(JSONArray response) {
        System.out.println(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println("Thana Response Listener error occure" + error.getMessage());
    }
}
