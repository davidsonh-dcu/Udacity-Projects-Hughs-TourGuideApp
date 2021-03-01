package com.example.android.hughstourguideapp;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrailsFragment extends Fragment {


    public TrailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_description_list, container, false);

        // Create list of locations
        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("Tinahely Loop", R.string.tinahely_loop, R.drawable.tinahely_loop));
        locations.add(new Location("Ballycumber Loop", R.string.ballycumber_loop, R.drawable.ballycumber_loop));
        locations.add(new Location("Kyle Loop", R.string.kyle_loop, R.drawable.kyle_loop));
        locations.add(new Location("Mangan's Loop", R.string.mangans_loop, R.drawable.mangans_loop));
        locations.add(new Location("Wicklow Way", R.string.wicklow_way, R.drawable.wicklow_way));
        locations.add(new Location("Railway Walk", R.string.railway_walk, R.drawable.railway_walk));

        // create {@link LocationAdapter}, whose data source is a list of {@link locations}
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.design_default_color_primary);

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