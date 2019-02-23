package familySearchModel;

/**
 * The online documentation for PlaceDescriptionInfo gives no information.
 * Get it here: https://www.familysearch.org/developers/docs/api/types/json_PlaceDescriptionInfo
 */
public class PlaceDescriptionInfo {
    private double zoomLevel;       // Get the zoom level for this place description.
    private String relatedType;     // Get the type of this place description. This attribute is only relevant "related place descriptions."
    private String relatedSubType;  // Get the sub-type of this related place description. This attribute is only relevant "related place descriptions."

    public PlaceDescriptionInfo(){
        zoomLevel = -1;
        relatedType = null;
        relatedSubType = null;
    }

    public double getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(double zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public String getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    public String getRelatedSubType() {
        return relatedSubType;
    }

    public void setRelatedSubType(String relatedSubType) {
        this.relatedSubType = relatedSubType;
    }
}
