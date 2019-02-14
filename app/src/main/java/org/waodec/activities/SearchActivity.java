package org.waodec.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.waodec.R;
import org.waodec.activities.urls.URLS;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private Button back;
    private ListView listView;
    private RequestQueue requestQueue;

    private ArrayAdapter<String> listViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        searchView = (SearchView) findViewById(R.id.search_bar);
        listView = (ListView) findViewById(R.id.book_list_view);

        searchView.setOnQueryTextListener(new SearchViewListener());

        /* listView.setOnItemClickListener(new ListViewListener());*/


    }

    /**
     *
     *
     *
     */

    private class BookRequestListener implements Response.Listener<JSONArray>, Response.ErrorListener {

        @Override
        public void onResponse(JSONArray response) {

            Log.i("onResponse", response.toString());


            try {

                ArrayList<String> info = new ArrayList<>();

                for (int i = 0; i < response.length(); ++i) {
                    JSONObject data = response.getJSONObject(i);
                    int totalCopies = data.getInt("totalCopies");
                    int takenCopies = data.getInt("takenCopies");
                    int available = totalCopies - takenCopies;
                    info.add("Book Name : " + data.get("bookName").toString() + " availableCopies : " + available);
                }
                listViewAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, info);
                listView.setAdapter(listViewAdapter);

                listView.setOnItemClickListener(new ListViewListener());

            } catch (Exception ex) {
                Log.e("onResponse ex", ex.getMessage());
            }

        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("onErrorResponse", error.getMessage());
        }
    }


    /**
     *
     *
     *
     */
    private class ListViewListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            Log.i("onItemClick", "" + position);


        }
    }


    /***
     *
     *
     *
     */


    private class SearchViewListener implements SearchView.OnQueryTextListener {
        @Override
        public boolean onQueryTextChange(String newText) {

            return false;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {


            try {
                requestQueue = Volley.newRequestQueue(getApplicationContext());

                JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, URLS.POST_BOOKS + query, null, new BookRequestListener(), new BookRequestListener());
                requestQueue.add(request);


            } catch (Exception ex) {
                Log.e("onQueryTextSubmit", ex.getMessage());
            }


            return false;
        }
    }


}
