package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.extensibleData.Attribution;

/**
 * A reference to a discussion.
 */
public class DiscussionReference extends HypermediaEnabledData {
    private String resourceId;          // The id of the discussion being referenced.
    private String resource;            // The URI to the resource. For more information, see Architecture of the World Wide Web, Volume One, Section 2
    private Attribution attribution;    // The attribution metadata for this discussion reference.

    public DiscussionReference(){
        super();
        resourceId = null;
        resource = null;
        attribution = null;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }
}
