package com.example.fithub.ui.home;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fithub.R;
import com.example.fithub.customFeedView;
import com.like.LikeButton;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ListView listView;
    private LikeButton likeButton;
    private String frndNames[] = {
            "Ioav",
            "Sakshi",
            "Lydia",
            "Michael"
    };

    private String frndDesc[] = {
            "I did a 5k run",
            "I did 200 squats.",
            "I did a 5k run",
            "I did 200 squats."
    };


    private Integer challengeImgs[] = {
            R.drawable.workout1,
            R.drawable.workout2,
            R.drawable.workout1,
            R.drawable.workout2

    };

    private Integer profileImgs[] = {
            R.drawable.user2,
            R.drawable.user1,
            R.drawable.user1,
            R.drawable.user2

    };

    private String challengeTime[] = {
            "Today 12:00pm",
            "Today 10:03am",
            "Yesterday 5:00pm",
            "Yesterday 4:30pm"
    };
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView textView = new TextView(getContext());
        textView.setTypeface(Typeface.DEFAULT_BOLD);
//        textView.setText("My Feed");

        ListView listView = (ListView) root.findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        customFeedView customFeedView = new customFeedView(getActivity(), frndNames, frndDesc, challengeImgs, profileImgs, challengeTime, likeButton);
        listView.setAdapter(customFeedView);

        return root;
    }
}