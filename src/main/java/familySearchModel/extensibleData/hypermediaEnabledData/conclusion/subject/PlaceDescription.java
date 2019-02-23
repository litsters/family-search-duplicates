package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject;

import familySearchModel.ResourceReference;
import familySearchModel.textValue.TextValue;
import familySearchModel.extensibleData.Date;
import familySearchModel.extensibleData.PlaceDisplayProperties;

/**
 * A PlaceDescription is used to describe the details of a place in terms of its name and possibly its type,
 * time period, and/or a geospatial description -- a description of a place as a snapshot in time.
 */
public class PlaceDescription extends Subject {
    private PlaceDisplayProperties display;         // Display properties for the place. Display properties are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
    private TextValue[] names;                      // An ordered list of standardized (or normalized), fully-qualified (in terms of what is known of the applicable jurisdictional hierarchy) names for this place that are applicable to this description of this place. The list MUST include at least one value. It is RECOMMENDED that instances include a single name and any equivalents from other cultural contexts; name variants should more typically be described in separate PlaceDescription instances. The list is assumed to be given in order of preference, with the most preferred value in the first position in the list.
    private Date temporalDescription;               // A description of the time period to which this place description is relevant.
    private double latitude;                        // Degrees north or south of the Equator (0.0 degrees). Values range from −90.0 degrees (south) to 90.0 degrees (north).
    private double longitude;                       // Angular distance in degrees, relative to the Prime Meridian. Values range from −180.0 degrees (west of the Meridian) to 180.0 degrees (east of the Meridian).
    private ResourceReference spatialDescription;   // A reference to a geospatial description of this place. It is RECOMMENDED that this description resolve to a KML document.
    private ResourceReference place;                // A reference to the place being described.
    private ResourceReference jurisdiction;         // A reference to a description of the jurisdiction this place.

    public PlaceDescription(){
        super();
        display = null;
        names = null;
        temporalDescription = null;
        latitude = -1;
        longitude = -1;
        spatialDescription = null;
        place = null;
        jurisdiction = null;
    }

    public PlaceDisplayProperties getDisplay() {
        return display;
    }

    public void setDisplay(PlaceDisplayProperties display) {
        this.display = display;
    }

    public TextValue[] getNames() {
        return names;
    }

    public void setNames(TextValue[] names) {
        this.names = names;
    }

    public Date getTemporalDescription() {
        return temporalDescription;
    }

    public void setTemporalDescription(Date temporalDescription) {
        this.temporalDescription = temporalDescription;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ResourceReference getSpatialDescription() {
        return spatialDescription;
    }

    public void setSpatialDescription(ResourceReference spatialDescription) {
        this.spatialDescription = spatialDescription;
    }

    public ResourceReference getPlace() {
        return place;
    }

    public void setPlace(ResourceReference place) {
        this.place = place;
    }

    public ResourceReference getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(ResourceReference jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
