package com.example.android.hughstourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        locations.add(new Location(R.string.madelines, R.string.madelines_info, R.drawable.madelines_b_b));
        locations.add(new Location(R.string.ballynultagh_forge, R.string.ballynultagh_forge_info, R.drawable.ballnultagh_forge));
        locations.add(new Location(R.string.derryview_cottage, R.string.derryview_cottage_info, R.drawable.derryview_cottage));
        locations.add(new Location(R.string.fairwood_stables, R.string.fairwood_stables_info, R.drawable.fairwood_stables));
        locations.add(new Location(R.string.murphys_hotel, R.string.murphys_hotel_info, R.drawable.murphys));
        locations.add(new Location(R.string.toberpatrick_cottages, R.string.toberpatrick_cottages_info, R.drawable.toberpatrick_cottage));
        locations.add(new Location(R.string.kyle_farm_bandb, R.string.kyle_farm_bandb_info, R.drawable.kyle_farmhouse));
        // create {@link LocationAdapter}, whose data source is a list of {@link locations}
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.teal_200);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_description_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

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
                Toast.makeText(getActivity(), R.string.toast, Toast.LENGTH_SHORT).show();
            }
        });

        return listView;
    }
}