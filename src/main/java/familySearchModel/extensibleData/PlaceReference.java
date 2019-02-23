package familySearchModel.extensibleData;


import familySearchModel.textValue.TextValue;

/**
 * A reference to genealogical place.
 */
public class PlaceReference extends ExtensibleData {
    private TextValue[] normalized; // The list of normalized values for the place, provided for display purposes by the application. Normalized values are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
    private String original;        // The original value as supplied by the user.
    private String description;     // Not in specification, but shows up anyways.

    public PlaceReference(){
        super();
        normalized = null;
        original = null;
        description = null;
    }

    public TextValue[] getNormalized() {
        return normalized;
    }

    public void setNormalized(TextValue[] normalized) {
        this.normalized = normalized;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
