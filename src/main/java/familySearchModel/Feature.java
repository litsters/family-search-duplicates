package familySearchModel;

/**
 * A description of a FamilySearch feature.
 */
public class Feature {
    private String name;            // The name of the feature.
    private String description;     // A description of the feature.
    private boolean enabled;        // Whether the feature is enabled for the current request.
    private double activationDate;  // The date that this feature is scheduled to activate permanently.

    public Feature(){
        name = null;
        description = null;
        enabled = false;
        activationDate = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public double getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(double activationDate) {
        this.activationDate = activationDate;
    }
}
