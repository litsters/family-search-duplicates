package familySearchModel;

/**
 * A tag in the FamilySearch system.
 */
public class Tag {
    private String resource;    // A reference to the value of the tag.

    public Tag(){
        resource = null;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
