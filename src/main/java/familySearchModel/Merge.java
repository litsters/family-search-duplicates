package familySearchModel;

/**
 * The online documentation about Merge gives no information.
 * Find it here: https://www.familysearch.org/developers/docs/api/types/json_Merge
 */
public class Merge {
    private ResourceReference[] resourcesToDelete;
    private ResourceReference[] resourcesToCopy;

    public Merge(){
        resourcesToDelete = null;
        resourcesToCopy = null;
    }

    public ResourceReference[] getResourcesToDelete() {
        return resourcesToDelete;
    }

    public void setResourcesToDelete(ResourceReference[] resourcesToDelete) {
        this.resourcesToDelete = resourcesToDelete;
    }

    public ResourceReference[] getResourcesToCopy() {
        return resourcesToCopy;
    }

    public void setResourcesToCopy(ResourceReference[] resourcesToCopy) {
        this.resourcesToCopy = resourcesToCopy;
    }
}
