package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ResourceReference;

/**
 * A comment.
 */
public class Comment extends HypermediaEnabledData {
    private String text;                    // Get the text of the comment
    private double created;                 // Get the date of comment creation
    private ResourceReference contributor;  // Get the contributor who submitted this comment

    public Comment(){
        super();
        text = null;
        created = -1;
        contributor = null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public ResourceReference getContributor() {
        return contributor;
    }

    public void setContributor(ResourceReference contributor) {
        this.contributor = contributor;
    }
}
