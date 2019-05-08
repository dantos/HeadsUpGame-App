package com.dantos.dev.headsup.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.dantos.dev.headsup.R;

import java.util.ArrayList;

public class ScoreAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;

    private Context context;
    private ArrayList<ArrayList<String>> scoreList;

    public ScoreAdapter(Context context, ArrayList<ArrayList<String>> scoreList){
        this.scoreList = scoreList;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the Item from ListView
        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.score_item, null);

        ArrayList<String> score = scoreList.get(position);
        int color               = ContextCompat.getColor(context, R.color.themeRed);

        if (score.get(1).equals("1")) { color = ContextCompat.getColor(context, R.color.themeGreen); }

        TextView scoreHintText  = view.findViewById(R.id.scoreHintText);
        scoreHintText.setText(score.get(0));
        scoreHintText.setTextColor(color);

        return view;
    }

    @Override
    public int getCount() {
        return scoreList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
