package org.waodec.activities.Spinners_fetcher;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class Authenticationer implements Response.Listener<JSONObject>, Response.ErrorListener {

    private boolean isAuthorized = false;

    private static Authenticationer instacne;

    private Authenticationer() {

    }

    public static Authenticationer getInstance() {
        if (instacne == null) instacne = new Authenticationer();
        return instacne;
    }


    public boolean isAuthorizedUser(RequestQueue requestQueue, String url, JSONObject userInfo) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, userInfo, this, this);
        requestQueue.add(request);
        return this.isAuthorized;

    }

    @Override
    public void onResponse(JSONObject response) {

        try {

            if (this.isAuthorized) this.isAuthorized = false;

            if (response.getBoolean("token")) this.isAuthorized = true;
            Log.i("onResponse", "authorized successfully " + response.toString());



        } catch (Exception ex) {
            Log.e("onResponse", ex.getMessage());
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.isAuthorized = false;
        Log.e("onErrorResponse", error.getMessage());

    }


}
