package familySearchModel.extensibleData;

import familySearchModel.ResourceReference;

/**
 * Attribution for genealogical information. Attribution is used to model who is contributing/modifying information,
 * when they contributed it, and why they are making the contribution/modification.
 */
public class Attribution extends ExtensibleData {
    private ResourceReference contributor;  // Reference to the contributor of the attributed data.
    private double modified;                // The modified timestamp for the attributed data.
    private String changeMessage;           // The "change message" for the attributed data provided by the contributor.
    private ResourceReference creator;      // Reference to the creator of the attributed data. The creator might be different from the contributor if the attributed data has been modified since it was created.
    private double created;                 // The created timestamp for the attributed data.

    public Attribution(){
        super();
        contributor = null;
        modified = -1;
        changeMessage = null;
        creator = null;
        created = -1;
    }

    public ResourceReference getContributor() {
        return contributor;
    }

    public void setContributor(ResourceReference contributor) {
        this.contributor = contributor;
    }

    public double getModified() {
        return modified;
    }

    public void setModified(double modified) {
        this.modified = modified;
    }

    public String getChangeMessage() {
        return changeMessage;
    }

    public void setChangeMessage(String changeMessage) {
        this.changeMessage = changeMessage;
    }

    public ResourceReference getCreator() {
        return creator;
    }

    public void setCreator(ResourceReference creator) {
        this.creator = creator;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }
}
