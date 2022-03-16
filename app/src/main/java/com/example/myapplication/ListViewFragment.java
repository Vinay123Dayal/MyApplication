package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewFragment extends Fragment implements BuddyAdapter.CommunicateRecycler {

    private RecyclerView recyclerView;
    private String TAG = "Fragment1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        Log.i("ListViewFragment", "open");
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        BuddyAdapter ba = new BuddyAdapter(EventList.getInstance().get_list(), this);
        recyclerView.setAdapter(ba);
        return view;

    }

    @Override
    public void replaceFragment(EventData nd) {
        Log.i("fragment", "all id well");

        DetailsFragment df = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("newsdata",nd);
        df.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.fragment,df).addToBackStack(null).commit();

    }
}
