package familySearchModel;

/**
 * The online documentation about MergeConflict has no information.
 * Find it here: https://www.familysearch.org/developers/docs/api/types/json_MergeConflict
 */
public class MergeConflict {
    private ResourceReference survivorResource;
    private ResourceReference duplicateResource;

    public MergeConflict(){
        survivorResource = null;
        duplicateResource = null;
    }

    public ResourceReference getSurvivorResource() {
        return survivorResource;
    }

    public void setSurvivorResource(ResourceReference survivorResource) {
        this.survivorResource = survivorResource;
    }

    public ResourceReference getDuplicateResource() {
        return duplicateResource;
    }

    public void setDuplicateResource(ResourceReference duplicateResource) {
        this.duplicateResource = duplicateResource;
    }
}
