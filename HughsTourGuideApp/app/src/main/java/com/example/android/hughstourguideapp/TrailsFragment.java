package com.example.android.hughstourguideapp;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        locations.add(new Location(R.string.tinahely_loop, R.string.tinahely_loop_info, R.drawable.tinahely_loop));
        locations.add(new Location(R.string.ballycumber_loop, R.string.ballycumber_loop_info, R.drawable.ballycumber_loop));
        locations.add(new Location(R.string.kyle_loop, R.string.kyle_loop_info, R.drawable.kyle_loop));
        locations.add(new Location(R.string.mangans_loop, R.string.mangans_loop_info, R.drawable.mangans_loop));
        locations.add(new Location(R.string.wicklow_way, R.string.wicklow_way_info, R.drawable.wicklow_way));
        locations.add(new Location(R.string.railway_walk, R.string.railway_walk_info, R.drawable.railway_walk));

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
            //public Intent getIntent();
            Context context = null;

            if(location.equals(0)){
                // create a new intent to open the {@link TinahelyLoopInfo Activity}
                Intent tinahelyLoopInfo = new Intent (context, TinahelyLoopInfoActivity.class);
                // set the new Westlife activity
                startActivity(tinahelyLoopInfo);

            }
            /* TODO Add additional Intents for the other items on the listView */
            else{
                Toast.makeText(getActivity(), "Info Page Under Construction", Toast.LENGTH_SHORT).show();
            }
        });


        return listView;
    }


}