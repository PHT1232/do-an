package com.example.appquanlyhoctap.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appquanlyhoctap.Model.Item;
import com.example.appquanlyhoctap.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class OptionAdapter extends BaseAdapter {

    Context context;
    private int layout;
    List<Item> optionList;

    public OptionAdapter(Context context, int layout, List<Item> optionList) {
        this.context = context;
        this.layout = layout;
        this.optionList = optionList;
    }


    @Override
    public int getCount() {
        return optionList.size();
    }

    @Override
    public Object getItem(int position) {
        return optionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        ImageView image;
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            holder.image = convertView.findViewById(R.id.image_id);
            holder.textView = convertView.findViewById(R.id.text_id);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Item item = optionList.get(position);
        holder.textView.setText(item.getText());
        holder.image.setImageResource(item.getImageView1());
        return convertView;
    }
}
