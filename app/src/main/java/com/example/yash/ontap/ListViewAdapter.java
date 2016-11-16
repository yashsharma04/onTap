package com.example.yash.ontap;

/**
 * Created by apple on 31/10/16.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



/**
 * Created by apple on 18/10/16.
 */
public class ListViewAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Activity mActivity;
    //private List<Result> results;
    private List<Result> restaurantResults;

    public ListViewAdapter(List<Result> results) {
        restaurantResults = results;
        //this.results = results;
        //this.mInflater = LayoutInflater.from(mActivity.getApplicationContext());
    }

    @Override
    public int getCount() {
        return restaurantResults.size();
    }

    @Override
    public Result getItem(int i) {
        return restaurantResults.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view = mInflater.inflate(R.layout.activity_listview ,viewGroup,false);
        }
        TextView textview = (TextView)view.findViewById(R.id.label);
        textview.setText(getItem(i).getName());
        return view;
    }
}