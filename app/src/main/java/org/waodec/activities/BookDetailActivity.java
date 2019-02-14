package org.waodec.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;
import org.waodec.R;
import org.waodec.activities.adapters.BookDetailViewerAdapter;
import org.waodec.activities.singletons.SingletonRequestQueue;
import org.waodec.activities.uploader.Book;
import org.waodec.activities.uploader.Borrower;
import org.waodec.activities.urls.URLS;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity {

    private RequestQueue requestQueue;

    private ListView listView;
    private JsonArrayRequest request;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_activity);

        listView = (ListView) findViewById(R.id.book_detail_view);

        Intent intent = getIntent();

        String bookId = intent.getStringExtra("bookId");

        requestQueue = SingletonRequestQueue.getInstance(getApplicationContext()).getRequestQueue();

        request = new JsonArrayRequest(Request.Method.POST, URLS.POST_BOOK_DETAIL + bookId, null, new BookDetailRequestListener(), new BookDetailRequestListener());

        requestQueue.add(request);

    }


    private class BookDetailRequestListener implements Response.Listener<JSONArray>, Response.ErrorListener {
        @Override
        public void onResponse(JSONArray response) {

            Log.i("onResponse", response.toString());

            try {


                ArrayList<Borrower> info = new ArrayList<>();

                for (int i = 0; i < response.length(); ++i) {

                    JSONObject data = response.getJSONObject(i);

                    JSONObject jbook = data.getJSONObject("book");

                    Book book = new Book();
                    book.setBookName(jbook.getString("bookName"));


                    JSONObject registerClient = data.getJSONObject("registerClient");


                    String receiveDate = data.getString("receiveDate");
                    String returnDate = data.getString("returnDate");

                    System.out.println("===============================");

                    System.out.println(receiveDate);
                    System.out.println(returnDate);
                    System.out.println(book.toString());
                    System.out.println(registerClient.toString());
                    System.out.println("\n \n \n \n \n");


                    Borrower borrower = new Borrower();
                    borrower.setBook(book);

                    info.add(borrower);

                }


                BookDetailViewerAdapter adapter = new BookDetailViewerAdapter(getApplicationContext(), info);
                listView.setAdapter(adapter);

            } catch (Exception ex) {
                Log.e("onRes ERROR", ex.getMessage());

            }

        }

        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }


}
