package familySearchModel;

/**
 * A generic reference to a resource.
 */
public class ResourceReference {
    private String resourceId;    // The resource id of the resource being referenced. Used as an extension attribute when resolving the resource is inconvenient.
    private String resource;      // The URI to the resource. For more information, see Architecture of the World Wide Web, Volume One, Section 2

    public ResourceReference(){
        resourceId = null;
        resource = null;
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

    @Override
    public String toString(){
        return "{resource: " + resource + ", resourceId: " + resourceId + "}";
    }
}
