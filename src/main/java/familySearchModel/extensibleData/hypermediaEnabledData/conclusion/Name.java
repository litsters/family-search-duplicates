package familySearchModel.extensibleData.hypermediaEnabledData.conclusion;

import familySearchModel.extensibleData.Date;
import familySearchModel.extensibleData.NameForm;

/**
 * A name conclusion.
 */
public class Name extends Conclusion {
    private String type;            // The type of the name.
    private boolean preferred;      // Whether the conclusion is preferred above other conclusions of the same type. Useful, for example, for display purposes.
    private Date date;              // The date the name was first applied or adopted.
    private NameForm[] nameForms;   // Alternate forms of the name, such as the romanized form of a non-latin name.

    public Name(){
        super();
        type = null;
        preferred = false;
        date = null;
        nameForms = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public NameForm[] getNameForms() {
        return nameForms;
    }

    public void setNameForms(NameForm[] nameForms) {
        this.nameForms = nameForms;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("{\n");
        builder.append("     type: " + type + "\n");
        builder.append("     preferred: " + preferred + "\n");
        builder.append("     date: " + date + "\n");
        builder.append("     nameForms: [\n");
        if(nameForms != null) for(NameForm nameForm : nameForms) builder.append(nameForm + "\n");
        builder.append("     ]\n}\n");

        return builder.toString();
    }
}
