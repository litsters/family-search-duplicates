package familySearchModel;

/**
 * A data qualifier. Qualifiers are used to "qualify" certain data elements to provide additional context, information, or details.
 */
public class Qualifier {
    private String name;    // The name of the qualifier. The name should be an element of a constrained vocabulary and is used to determine meaning of the qualifier.
    private String value;   // The value of the qualifier. Some qualifiers may not have values, indicating that the qualifier is to be treated more like a "tag".

    public Qualifier(){
        name = null;
        value = null;
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
