package com.example.fithub;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fithub.R;

public class customlLeaderboard extends ArrayAdapter{
    private String[] leader_name;
    private Integer[] leader_rank;
    private Activity context;
    private Integer[] leader_img;

    public customlLeaderboard(Activity context, String[] leader_name, Integer[] leader_rank, Integer[] leader_img) {
        super(context, R.layout.row_leaderboard, leader_name);
        this.context = context;
        this.leader_img = leader_img;
        this.leader_name = leader_name;
        this.leader_rank = leader_rank;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_leaderboard, null, true);
        TextView textViewName1 = (TextView) row.findViewById(R.id.leader_name);
        TextView textViewDesc1 = (TextView) row.findViewById(R.id.leader_rank);
        ImageView imageFlag1 = (ImageView) row.findViewById(R.id.leader_img);

        textViewName1.setText(leader_name[position]);
        textViewDesc1.setText(Integer.toString(leader_rank[position]));
        imageFlag1.setImageResource(leader_img[position]);
        return row;
    }
}
