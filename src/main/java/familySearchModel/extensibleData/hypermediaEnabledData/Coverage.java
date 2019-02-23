package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.extensibleData.Date;
import familySearchModel.extensibleData.PlaceReference;

/**
 * A description of the coverage of a resource.
 */
public class Coverage extends HypermediaEnabledData {
    private PlaceReference spatial; // Spatial coverage.
    private Date temporal;          // Temporal coverage.

    public Coverage(){
        super();
        spatial = null;
        temporal = null;
    }

    public PlaceReference getSpatial() {
        return spatial;
    }

    public void setSpatial(PlaceReference spatial) {
        this.spatial = spatial;
    }

    public Date getTemporal() {
        return temporal;
    }

    public void setTemporal(Date temporal) {
        this.temporal = temporal;
    }
}
