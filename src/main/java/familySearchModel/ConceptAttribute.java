package familySearchModel;

/**
 * A concept attribute.
 */
public class ConceptAttribute {
    private String id;      // Get the concept attribute id.
    private String name;    // Get the concept attribute name.
    private String value;   // Get the concept attribute value.

    public ConceptAttribute(){
        id = null;
        name = null;
        value = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
