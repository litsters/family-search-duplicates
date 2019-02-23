package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.extensibleData.Attribution;

/**
 * A reference to a resource that is being used as evidence.
 */
public class EvidenceReference extends HypermediaEnabledData {
    private String resourceId;          // The resource id of the resource being referenced. Used as an extension attribute when resolving the resource is inconvenient.
    private String resource;            // The URI to the resource being referenced as evidence.
    private Attribution attribution;    // Attribution metadata for this evidence reference.

    public EvidenceReference(){
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
