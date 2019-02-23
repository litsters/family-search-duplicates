package familySearchModel;

/**
 * The online documentation about MergeAnalysis gives no information.
 * Find it here: https://www.familysearch.org/developers/docs/api/types/json_MergeAnalysis
 */
public class MergeAnalysis {
    private ResourceReference[] survivorResources;
    private ResourceReference[] duplicateResources;
    private MergeConflict[] conflictingResources;
    private ResourceReference survivor;
    private ResourceReference duplicate;

    public MergeAnalysis(){
        survivorResources = null;
        duplicateResources = null;
        conflictingResources = null;
        survivor = null;
        duplicate = null;
    }

    public ResourceReference[] getSurvivorResources() {
        return survivorResources;
    }

    public void setSurvivorResources(ResourceReference[] survivorResources) {
        this.survivorResources = survivorResources;
    }

    public ResourceReference[] getDuplicateResources() {
        return duplicateResources;
    }

    public void setDuplicateResources(ResourceReference[] duplicateResources) {
        this.duplicateResources = duplicateResources;
    }

    public MergeConflict[] getConflictingResources() {
        return conflictingResources;
    }

    public void setConflictingResources(MergeConflict[] conflictingResources) {
        this.conflictingResources = conflictingResources;
    }

    public ResourceReference getSurvivor() {
        return survivor;
    }

    public void setSurvivor(ResourceReference survivor) {
        this.survivor = survivor;
    }

    public ResourceReference getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(ResourceReference duplicate) {
        this.duplicate = duplicate;
    }
}
