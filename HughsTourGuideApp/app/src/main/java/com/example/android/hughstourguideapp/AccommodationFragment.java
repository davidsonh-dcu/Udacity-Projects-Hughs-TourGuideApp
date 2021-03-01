package com.example.android.hughstourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AccommodationFragment extends Fragment {

    public AccommodationFragment(){
        // Required empty public constructor}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_description_list, container, false);

        // Create list of locations
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Madeline's B&B", R.string.madelines, R.drawable.madelines_b_b));
        locations.add(new Location("Ballynultagh Forge", R.string.ballynultagh_forge, R.drawable.ballnultagh_forge));
        locations.add(new Location("Derryview Cottage", R.string.derryview_cottage, R.drawable.derryview_cottage));
        locations.add(new Location("Fairwood Stables", R.string.fairwood_stables, R.drawable.fairwood_stables));
        locations.add(new Location("Murphy's Hotel", R.string.murphys_hotel, R.drawable.murphys));
        locations.add(new Location("Toberpatrick Cottages", R.string.toberpatrick_cottages, R.drawable.toberpatrick_cottage));

        // create {@link LocationAdapter}, whose data source is a list of {@link locations}
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.teal_200);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_description_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // set onClickListener to show more info
        listView.setOnItemClickListener((parent, view, position, id) -> {

            // Get the {@link Location} object the user clicked on
            Location location = locations.get(position);

            if(location.equals(0)){
                // create a new intent to open the {@link TinahelyLoopInfo Activity}
                Intent tinahelyLoopInfo = new Intent (getActivity(), TinahelyLoopInfoActivity.class);
                // set the new Westlife activity
                startActivity(tinahelyLoopInfo);

            }
            // TODO Add additional Intents for the other items on the listView
            else{
                Toast.makeText(getActivity(), "Info Page Under Construction", Toast.LENGTH_SHORT).show();
            }
        });

        return listView;
    }
}