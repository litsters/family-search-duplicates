package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.textValue.TextValue;

/**
 * A vocabulary term.
 */
public class Term extends HypermediaEnabledData {
    private String type;        // Get the vocabulary term type.
    private String concept;     // Get the URI of the concept this vocabulary term is associated with.
    private String sublist;     // Get the URI of the sublist this vocabulary term is associated with.
    private int sublistPosition;// Get the position of this vocabulary term within it's associated sublist.
    private TextValue[] values; // Get the vocabulary term values.

    public Term(){
        super();
        type = null;
        concept = null;
        sublist = null;
        sublistPosition = -1;
        values = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getSublist() {
        return sublist;
    }

    public void setSublist(String sublist) {
        this.sublist = sublist;
    }

    public int getSublistPosition() {
        return sublistPosition;
    }

    public void setSublistPosition(int sublistPosition) {
        this.sublistPosition = sublistPosition;
    }

    public TextValue[] getValues() {
        return values;
    }

    public void setValues(TextValue[] values) {
        this.values = values;
    }
}
