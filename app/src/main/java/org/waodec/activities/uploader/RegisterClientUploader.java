package org.waodec.activities.uploader;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

public class RegisterClientUploader implements Response.Listener<JSONObject>, Response.ErrorListener {


    public void upload(RequestQueue requestQueue, JSONObject data, String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, data, this, this);
        requestQueue.add(request);
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.i("onResponse", response.toString());

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("onErrorResponse", error.getMessage());
    }
}
