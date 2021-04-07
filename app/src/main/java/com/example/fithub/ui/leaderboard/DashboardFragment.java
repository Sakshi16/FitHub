package com.example.fithub.ui.leaderboard;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fithub.R;
import com.example.fithub.customlLeaderboard;

public class DashboardFragment extends Fragment {
    private ListView listView;
    private String leader_name[] = {
            "Sakshi",
            "Ioav",
            "Michael",
            "Lydia",
            "Adem",
            "Dibakar",
            "Sakshi",
            "Ioav",
            "Michael",
            "Lydia",
            "Adem",
            "Dibakar"
    };

    private Integer leader_rank[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private Integer leader_img[] = {
            R.drawable.user2,
            R.drawable.user1,
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user2,
            R.drawable.user1,
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user2,
            R.drawable.user1,
            R.drawable.user1,
            R.drawable.user2
    };

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        TextView textView = new TextView(getContext());
        textView.setTypeface(Typeface.DEFAULT_BOLD);

        ListView listView=(ListView)root.findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        customlLeaderboard customlLeaderboard = new customlLeaderboard(getActivity(), leader_name, leader_rank, leader_img);
        listView.setAdapter((ListAdapter) customlLeaderboard);

        return root;
    }
}