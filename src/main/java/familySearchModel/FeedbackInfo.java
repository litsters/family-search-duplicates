package familySearchModel;

/**
 * Information about a a feedback submission about a place.
 */
public class FeedbackInfo {
    private String resolution;          // The resolution of the feedback.
    private String status;              // The status of the feedback.
    private ResourceReference place;    // A reference to the place that was created based on this feedback, if any.
    private String details;             // Some additional details about the resolution.

    public FeedbackInfo(){
        resolution = null;
        status = null;
        place = null;
        details = null;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ResourceReference getPlace() {
        return place;
    }

    public void setPlace(ResourceReference place) {
        this.place = place;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
