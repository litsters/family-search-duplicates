package familySearchModel.extensibleData;


import familySearchModel.textValue.TextValue;

/**
 * A concluded genealogical date.
 */
public class Date extends ExtensibleData {
    private TextValue[] normalized; // The list of normalized values for the date, provided for display purposes by the application. Normalized values are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.
    private String original;        // The original text as supplied by the user.
    private String formal;          // The standardized and/or normalized formal value.

    public Date(){
        super();
        normalized = null;
        original = null;
        formal = null;
    }

    public String extractStringValue(){
        if(getFormal() != null) return getFormal();
        else return null;
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

    public String getFormal() {
        return formal;
    }

    public void setFormal(String formal) {
        this.formal = formal;
    }
}
