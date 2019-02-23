package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject;


import familySearchModel.ResourceReference;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Fact;

/**
 * A relationship between two or more persons.
 */
public class Relationship extends Subject {
    private String type;                  // The type of this relationship.
    private ResourceReference person1;    // A reference to a person in the relationship. The name "person1" is used only to distinguish it from the other person in this relationship and implies neither order nor role. When the relationship type implies direction, it goes from "person1" to "person2".
    private ResourceReference person2;    // A reference to a person in the relationship. The name "person2" is used only to distinguish it from the other person in this relationship and implies neither order nor role. When the relationship type implies direction, it goes from "person1" to "person2".
    private Fact[] facts;                 // The fact conclusions for the relationship.

    public Relationship(){
        super();
        type = null;
        person1 = null;
        person2 = null;
        facts = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResourceReference getPerson1() {
        return person1;
    }

    public void setPerson1(ResourceReference person1) {
        this.person1 = person1;
    }

    public ResourceReference getPerson2() {
        return person2;
    }

    public void setPerson2(ResourceReference person2) {
        this.person2 = person2;
    }

    public Fact[] getFacts() {
        return facts;
    }

    public void setFacts(Fact[] facts) {
        this.facts = facts;
    }
}
