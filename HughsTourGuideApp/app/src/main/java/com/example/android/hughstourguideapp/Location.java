package com.example.android.hughstourguideapp;

/**
 * {@link Location} Represents a location of interest that a user wants to know about it contains
 * text, image view and audio clip
 */

public class Location {
    // location name
    private final String mLocationName;

    // description of location
    private final int mLocationDescriptionResourceId;

    // image of location
    private final int mLocationImageResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

     /** create a Location object
     *  This is the constrcutor
     * @param locationName name of location
     * @param locationDescriptionResourceId description of location
     * @param locationImageResourceId location image
     */

    public Location(String locationName, int locationDescriptionResourceId, int locationImageResourceId){
        mLocationName = locationName;
        mLocationDescriptionResourceId = locationDescriptionResourceId;
        mLocationImageResourceId = locationImageResourceId;
    }
    // get location name
    public String getLocationName() {return mLocationName;}

    // get description of location
    public int getLocationDescription() {return mLocationDescriptionResourceId;}

    // get location image
    public int getImageResourceId(){return mLocationImageResourceId;}

    /** Return whether or not there is an image for this word */
    public boolean hasImage(){
        return mLocationDescriptionResourceId != NO_IMAGE_PROVIDED; // Returns TRUE if NO_IMAGE_PROVIDED is more than -1
    }

}
