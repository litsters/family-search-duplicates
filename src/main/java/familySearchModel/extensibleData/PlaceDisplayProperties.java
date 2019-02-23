package familySearchModel.extensibleData;

/**
 * A set of display properties for places for the convenience of quick display, such as for a
 * Web-based application. All display properties are provided in the default locale for the current
 * application context and are NOT considered canonical for the purposes of data exchange.
 */
public class PlaceDisplayProperties extends ExtensibleData {
    private String name;        // The displayable name of the place.
    private String fullName;    // The displayable full name of the place.
    private String type;        // The displayable type of the place.

    public PlaceDisplayProperties(){
        super();
        name = null;
        fullName = null;
        type = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
