package com.amelia.pert4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MinumanFragment extends Fragment {

    private String[] minumanArray = { "Es teh manis", "Es Lemon", "Es Kelapa", "Rainbow Ice"
    };
    public MinumanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_minuman, container, false);
        ArrayAdapter adapter = new ArrayAdapter<String>(this.getContext(),
                R.layout.list_minuman_item, minumanArray);
        ListView listview = (ListView)rootView.findViewById(R.id.minuman_list);
        listview.setAdapter(adapter);
        return rootView;
    }

}
