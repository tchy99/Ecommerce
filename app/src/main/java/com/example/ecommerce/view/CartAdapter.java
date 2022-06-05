package com.example.ecommerce.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ecommerce.R;
import com.example.ecommerce.model.produit;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {

    private Context context;
    private List<produit> list;
    private LayoutInflater inflater;

    public CartAdapter(Context context, List<produit> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }




    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public produit getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_item, null);
        return null;
    }
}
