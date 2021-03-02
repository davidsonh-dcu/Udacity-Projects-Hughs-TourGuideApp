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
        locations.add(new Location(R.string.madelines, R.string.madelines_food, R.drawable.madelines_b_b));
        locations.add(new Location(R.string.murphys_hotel, R.string.murphys_food, R.drawable.murphys));
        locations.add(new Location(R.string.oconnors, R.string.oconnors_food, R.drawable.oconnors));
        locations.add(new Location(R.string.dlish, R.string.dlish_food, R.drawable.dlish));
        locations.add(new Location(R.string.the_farm_shop, R.string.the_farm_shop_food, R.drawable.farmshop1));
        locations.add(new Location(R.string.the_courthouse_cafe, R.string.the_courthouse_cafe_food, R.drawable.courthouse_cafe));

        // create {@link LocationAdapter}, whose data source is a list of {@link locations}
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.purple_200);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // location_description_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // set onClickListener to show more info
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
