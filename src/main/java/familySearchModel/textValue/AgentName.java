package familySearchModel.textValue;

/**
 * An element representing a text value that may be in a specific language.
 */
public class AgentName extends TextValue {
    private String type;    // No documentation.

    public AgentName(){
        super();
        type = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
