package com.example.fithub;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.like.LikeButton;

public class customFeedView extends ArrayAdapter {
    private String[] frndNames;
    private String[] frndDesc;
    private Integer[] challengeImgs;
    private Integer[] profileImgs;
    private Activity context;
    private String[] challengeTime;
    private LikeButton likeButton;

    public customFeedView(Activity context, String[] frndNames, String[] frndDesc, Integer[] challengeImgs, Integer[] profileImgs, String[] challengeTime, LikeButton likeButton){
        super(context, R.layout.row_item, frndNames);
        this.context = context;
        this.frndNames = frndNames;
        this.frndDesc = frndDesc;
        this.challengeImgs = challengeImgs;
        this.profileImgs = profileImgs;
        this.challengeTime = challengeTime;
        this.likeButton = likeButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);
        TextView textViewName = (TextView) row.findViewById(R.id.frndName);
        TextView textViewDesc = (TextView) row.findViewById(R.id.frndDesc);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.challengeImg);
        ImageView imageProf = (ImageView) row.findViewById(R.id.frndProfileImg);
        TextView textViewTime = (TextView) row.findViewById(R.id.challengeTime);
        LikeButton likeButton = (LikeButton) row.findViewById(R.id.likeButton);

        textViewName.setText(frndNames[position]);
        textViewDesc.setText(frndDesc[position]);
        imageFlag.setImageResource(challengeImgs[position]);
        imageProf.setImageResource(profileImgs[position]);
        textViewTime.setText(challengeTime[position]);
        return row;
    }
}
