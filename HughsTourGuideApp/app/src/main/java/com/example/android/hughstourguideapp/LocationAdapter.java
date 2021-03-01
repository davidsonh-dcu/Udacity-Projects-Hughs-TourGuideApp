package com.example.android.hughstourguideapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {
    /**
     * resource ID for the background color for this list of words
     */
    private final int mColorResourceId;

    /**
     * Create a new {@link LocationAdapter} object
     * This is a custom constructor
     * The context is used to inflate the layout file, and the list is the data I want to populate
     * into the list
     * @param context current context
     * @param locations a list Location objects to display in the list
     * @param colorResourceId is the resource ID for the background color for this list of words
     */

    public LocationAdapter(Activity context, ArrayList<Location> locations, int colorResourceId) {
        // Initialise the ArrayAdapter's internal storage for the context and the list
        // the second argument locations is use when the ArrayAdapter is populating a single text
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    /**
     * @param position    The position in the list of data that should be displayed in the list item view
     * @param convertView The recycled view to populate
     * @param parent      The parent ViewGroup @+id/list??
     * @return The View for the position in the AdapterView
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // get the {@link location} object located at the current position in the list
        Location currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_name_text_view
        TextView locationNameTextView = listItemView.findViewById(R.id.location_name_text_view);
        // get the location title from the current Location object and set this text on the location text view
        locationNameTextView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID location_description_text_view
        TextView locationDescriptionTextView = listItemView.findViewById(R.id.location_description_text_view);
        locationDescriptionTextView.setText(currentLocation.getLocationDescription());

        // Find the ImageView in the list_item.xml layout with the ID
        ImageView locationImageView = listItemView.findViewById(R.id.location_image_view);

        if(currentLocation.hasImage()){
            // Get the location image from the current Location object and set this image on the ImageView
            locationImageView.setImageResource(currentLocation.getImageResourceId());

            // make sure that the image is visible
            locationDescriptionTextView.setVisibility(View.VISIBLE);
        }
        else{
            // Otherwise hide the imageView (set visibility to GONE with no blank space holder in the app)
            locationDescriptionTextView.setVisibility(View.GONE);
        }

        // Set the theme color for this list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //set color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

