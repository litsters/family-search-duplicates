package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ResourceReference;

/**
 * A family view, meaning up to two parents and a list of children who have those parents in common.
 * Relationships carry the canonical information for this view, and the relationships must be used to get
 * Facts (lineage types, marriages, etc.) about the relationships covered by a Family. The Family data type provides
 * a convenient way to see the typical family views without having to do the calculations to derive them.
 * There should only be one family for each unique set of parents, and only one for each single-parent family
 * with a particular parent.
 */
public class FamilyView extends HypermediaEnabledData {
    private ResourceReference parent1;      // A reference to a parent in the family. The name "parent1" is used only to distinguish it from the other parent in this family and implies neither order nor role.
    private ResourceReference parent2;      // A reference to a parent in the family. The name "parent2" is used only to distinguish it from the other parent in this family and implies neither order nor role.
    private ResourceReference[] children;   // A list of references to the children of this family.

    public FamilyView(){
        super();
        parent1 = null;
        parent2 = null;
        children = null;
    }

    public ResourceReference getParent1() {
        return parent1;
    }

    public void setParent1(ResourceReference parent1) {
        this.parent1 = parent1;
    }

    public ResourceReference getParent2() {
        return parent2;
    }

    public void setParent2(ResourceReference parent2) {
        this.parent2 = parent2;
    }

    public ResourceReference[] getChildren() {
        return children;
    }

    public void setChildren(ResourceReference[] children) {
        this.children = children;
    }
}
