package com.example.android.hughstourguideapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class BarsAndFoodFragment extends Fragment {

    public BarsAndFoodFragment(){
        // Required empty public constructor}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_description_list, container, false);

        // Create list of locations
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Madeline's", R.string.madelines, R.drawable.madelines_b_b));
        locations.add(new Location("Murphy's Hotel", R.string.murphys_hotel, R.drawable.murphys));
        locations.add(new Location("O'Connor's", R.string.murphys_hotel, R.drawable.oconnors));
        locations.add(new Location("D'lish", R.string.murphys_hotel, R.drawable.dlish));


        // create {@link LocationAdapter}, whose data source is a list of {@link locations}
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.purple_200);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_description_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // set onClickListener to show more info


        return listView;
    }
}
