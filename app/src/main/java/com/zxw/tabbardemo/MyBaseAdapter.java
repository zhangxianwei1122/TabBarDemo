package com.zxw.tabbardemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zxw.tabbardemo.fragment.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张贤伟
 * 时间： 2017/5/9 20:39
 * 类描述：
 */
public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<Data> list = new ArrayList<>();
    private final LayoutInflater inflater;

    public MyBaseAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_item, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_image);
        TextView textView = (TextView) view.findViewById(R.id.item_name);

//        imageView.setImageResource(list.get(position).getImage());
        textView.setText(list.get(position).getName());

        return view;
    }


}
