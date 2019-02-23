package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ResourceReference;

/**
 * A discussion.
 */
public class Discussion extends HypermediaEnabledData {
    private String title;                   // get the one-line summary or "subject" of the discussion
    private String details;                 // Get detailed text of the discussion
    private double created;                 // Get the date of discussion creation
    private ResourceReference contributor;  // Get the contributor who submitted this discussion
    private double modified;                // Last date of any change to comments or discussion details
    private int numberOfComments;           // Get the number of comments associated with this discussion
    private Comment[] comments;             // The comments on this discussion.

    public Discussion(){
        super();
        title = null;
        details = null;
        created = -1;
        contributor = null;
        modified = -1;
        numberOfComments = -1;
        comments = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

    public double getModified() {
        return modified;
    }

    public void setModified(double modified) {
        this.modified = modified;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}
