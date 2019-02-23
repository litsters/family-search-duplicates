package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject;


import familySearchModel.ResourceReference;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Fact;

/**
 * The FamilySearch-proprietary model for a relationship between a child and a pair of parents.
 */
public class ChildAndParentsRelationship extends Subject {
    private ResourceReference father; // The father of the child.
    private ResourceReference mother; // The mother of the child.
    private ResourceReference child;  // The child in the relationship.
    private Fact[] fatherFacts;       // The fact conclusions for the father.
    private Fact[] motherFacts;       // The fact conclusions for the mother.

    public ChildAndParentsRelationship(){
        super();
        father = null;
        mother = null;
        child = null;
        fatherFacts = null;
        motherFacts = null;
    }

    public ResourceReference getFather() {
        return father;
    }

    public void setFather(ResourceReference father) {
        this.father = father;
    }

    public ResourceReference getMother() {
        return mother;
    }

    public void setMother(ResourceReference mother) {
        this.mother = mother;
    }

    public ResourceReference getChild() {
        return child;
    }

    public void setChild(ResourceReference child) {
        this.child = child;
    }

    public Fact[] getFatherFacts() {
        return fatherFacts;
    }

    public void setFatherFacts(Fact[] fatherFacts) {
        this.fatherFacts = fatherFacts;
    }

    public Fact[] getMotherFacts() {
        return motherFacts;
    }

    public void setMotherFacts(Fact[] motherFacts) {
        this.motherFacts = motherFacts;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[");
        if(father != null) builder.append("Father: " + father + ", ");
        if(mother != null) builder.append("Mother: " + mother + ", ");
        if(child != null) builder.append("Child: " + child);
        builder.append("]");
        return builder.toString();
    }
}
