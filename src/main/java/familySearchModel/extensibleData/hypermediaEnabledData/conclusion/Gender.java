package familySearchModel.extensibleData.hypermediaEnabledData.conclusion;


/**
 * A gender conclusion.
 */
public class Gender extends Conclusion {
    private String type;    // The type of the gender.

    public Gender(){
        super();
        type = null;
    }

    @Override
    public String toString(){
        return "{     type: " + type + " }\n";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
