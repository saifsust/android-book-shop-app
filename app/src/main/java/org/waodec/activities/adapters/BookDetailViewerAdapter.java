package org.waodec.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.waodec.R;
import org.waodec.activities.uploader.Borrower;

import java.util.ArrayList;

public class BookDetailViewerAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Borrower> borrowers;

    public BookDetailViewerAdapter(Context context, ArrayList<Borrower> borrowers) {
        this.context = context;
        this.borrowers = borrowers;
    }

    @Override
    public int getCount() {
        return borrowers.size();
    }

    @Override
    public Object getItem(int position) {
        return borrowers.get(position);
    }


    @Override

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.book_detail, parent, false);
        TextView bookName = (TextView) view.findViewById(R.id.book_detail_name);
        Borrower borrower = borrowers.get(position);
        bookName.setText(borrower.getBook().getBookName());
        return view;
    }
}
