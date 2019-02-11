package org.waodec.activities.singletons;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequestQueue {

    private static SingletonRequestQueue instance;
    private RequestQueue mRequestQueue;
    private Context mContext;


    private SingletonRequestQueue(Context context) {
        this.mContext = context;
        this.mRequestQueue = getRequestQueue();

    }

    public static synchronized SingletonRequestQueue getInstance(Context context) {
        if (instance == null) return instance = new SingletonRequestQueue(context);
        return instance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) return Volley.newRequestQueue(mContext);
        return mRequestQueue;
    }

}
