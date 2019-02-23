package familySearchModel.extensibleData;

/**
 * A set of data that supports extension elements.
 */
public class ExtensibleData {
    private String id;  // A local, context-specific id for the data.

    public ExtensibleData(){
        id = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
