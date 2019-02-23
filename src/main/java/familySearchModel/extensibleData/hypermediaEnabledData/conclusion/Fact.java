package familySearchModel.extensibleData.hypermediaEnabledData.conclusion;

import familySearchModel.Qualifier;
import familySearchModel.extensibleData.Date;
import familySearchModel.extensibleData.PlaceReference;

/**
 * A conclusion about a fact applicable to a person or relationship.
 */
public class Fact extends Conclusion {
    private String type;            // The type of the fact.
    private Date date;              // The date of applicability of this fact.
    private PlaceReference place;   // The place of applicability of this fact.
    private String value;           // The value as supplied by the user.
    private Qualifier[] qualifiers; // The qualifiers associated with this fact.

    public Fact(){
        super();
        type = null;
        date = null;
        place = null;
        value = null;
        qualifiers = null;
    }

    public String extractStringValue(){
        if(getDate() == null) return null;
        return date.extractStringValue();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PlaceReference getPlace() {
        return place;
    }

    public void setPlace(PlaceReference place) {
        this.place = place;
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

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("{\n");
        builder.append("     type: " + type + "\n");
        builder.append("     date: " + date + "\n");
        builder.append("     place: " + place + "\n");
        builder.append("     value: " + value + "\n");
        builder.append("}\n");
        return builder.toString();
    }
}
