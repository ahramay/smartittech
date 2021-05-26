package com.asifnazir.urdubiblequiz.activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.SortedList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.asifnazir.urdubiblequiz.databinding.FragmentLeaderboradsBinding;

import java.util.ArrayList;

public class LeaderboradsFragment extends Fragment {

    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progress;

    public LeaderboradsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentLeaderboradsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentLeaderboradsBinding.inflate(inflater, container, false);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progress = new ProgressDialog(getContext());
        progress.setTitle("Loading");
        progress.setMessage("Please Wait Leader board is loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        SortedList<User> userSortedList;

        userSortedList = new SortedList<User>(User.class, new SortedList.Callback<User>() {
            @Override
            public void onInserted(int position, int count) {

            }

            @Override
            public void onRemoved(int position, int count) {

            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {

            }

            @Override
            public int compare(User o1, User o2) {
                Long o1l = o1.getCoins();
                Long o2l = o2.getCoins();

                return o2l.compareTo(o1l);
            }

            @Override
            public void onChanged(int position, int count) {

            }

            @Override
            public boolean areContentsTheSame(User oldItem, User newItem) {
                return false;
            }

            @Override
            public boolean areItemsTheSame(User item1, User item2) {
                return false;
            }
        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        database.getReference().child("Users").orderByChild("coins")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot children : snapshot.getChildren()){
                            User user = children.getValue(User.class);
                            userSortedList.add(user);
                        }
                        final LeaderboardsAdapter adapter = new LeaderboardsAdapter(getContext(), userSortedList);

                        binding.recyclerView.setAdapter(adapter);
                        progress.dismiss();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        progress.dismiss();
                    }
                });

        return binding.getRoot();
    }
}