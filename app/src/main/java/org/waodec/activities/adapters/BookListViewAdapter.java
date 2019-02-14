package org.waodec.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.waodec.R;
import org.waodec.activities.uploader.Book;

import java.util.ArrayList;
import java.util.List;

public class BookListViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Book> books;//= new ArrayList<>();

   /* public BookListViewAdapter(Context context, int resource, ArrayList<Book> books) {
        super(context, resource, books);
        this.context = context;
        this.books = books;
    }
*/

    public BookListViewAdapter(Context context, ArrayList<Book> books) {

        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return books.get(position).getBookId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.book_list_view, parent, false);

        Book book = books.get(position);

        ImageView imageView = (ImageView) view.findViewById(R.id.book_img);

        TextView bookName = (TextView) view.findViewById(R.id.book_name);
        TextView writer = (TextView) view.findViewById(R.id.writer);
        TextView available = (TextView) view.findViewById(R.id.available);

        bookName.setText(book.getBookName());
        writer.setText(book.getWriter());
        available.setText("20");

        return view;
    }
}
