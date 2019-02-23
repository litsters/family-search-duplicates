package familySearchModel.extensibleData;

import familySearchModel.Qualifier;

/**
 * A part of a name.
 */
public class NamePart extends ExtensibleData {
    private String type;            // The type of the name part.
    private String value;           // The value of the name part.
    private Qualifier[] qualifiers; // The qualifiers associated with this name part.

    public NamePart(){
        super();
        type = null;
        value = null;
        qualifiers = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Qualifier[] getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(Qualifier[] qualifiers) {
        this.qualifiers = qualifiers;
    }
}
