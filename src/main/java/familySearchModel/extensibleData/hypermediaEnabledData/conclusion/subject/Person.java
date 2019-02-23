package familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject;

import familySearchModel.extensibleData.*;
import familySearchModel.extensibleData.hypermediaEnabledData.DiscussionReference;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Fact;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Gender;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.Name;
import com.google.gson.annotations.SerializedName;

/**
 * A person.
 */
public class Person extends Subject {
    @SerializedName("discussion-references")
    private DiscussionReference[] discussionReferences;  // Not in the documentation, but it shows up anyways.

    private DisplayProperties display;      // Display properties for the person. Display properties are not specified by GEDCOM X core, but as extension elements by GEDCOM X RS.

    @SerializedName("private")
    private boolean isPrivate;              // Whether this person has been designated for limited distribution or display.
    private boolean living;                 // Living status of the person as treated by the system. The value of this property is intended to be based on a system-specific calculation and therefore has limited portability. Conclusions about the living status of a person can be modeled with a fact.
    private Gender gender;                  // The gender conclusion for the person.
    private Name[] names;                   // The name conclusions for the person.
    private Fact[] facts;                   // The fact conclusions for the person.

    public Person(){
        super();
        discussionReferences = null;
        display = null;
        isPrivate = false;
        living = false;
        gender = null;
        names = null;
        facts = null;
    }

    public String getDateForEventType(String eventType){
        if(getFacts() == null) return null;
        Fact targetFact = null;
        for(Fact fact : getFacts()) if(fact.getType().matches(eventType)) targetFact = fact;
        if(targetFact == null || targetFact.getDate() == null) return null;

        // Get date for event
        String date = targetFact.extractStringValue();
        if(date == null) return null;   // Does not parse it!

        return date;
    }

    public DiscussionReference[] getDiscussionReferences() {
        return discussionReferences;
    }

    public void setDiscussionReferences(DiscussionReference[] discussionReferences) {
        this.discussionReferences = discussionReferences;
    }

    public DisplayProperties getDisplay() {
        return display;
    }

    public void setDisplay(DisplayProperties display) {
        this.display = display;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Name[] getNames() {
        return names;
    }

    public void setNames(Name[] names) {
        this.names = names;
    }

    public Fact[] getFacts() {
        return facts;
    }

    public void setFacts(Fact[] facts) {
        this.facts = facts;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Person)) return false;

        Person other = (Person)o;
        if(this.getId() != null) return this.getId().matches(other.getId());
        else return other.getId() == null;
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("{\n");
        builder.append("     id: " + getId() + "\n");
        builder.append("     sortKey: " + getSortKey() + "\n");
        builder.append("     extracted: " + isExtracted() + "\n");
        builder.append("     living: " + living + "\n");
        builder.append("     private: " + isPrivate + "\n");
        builder.append("     gender: " + gender + "\n");
        builder.append("     name: [\n");
        if(names != null) for(Name name : names) builder.append(name + "\n");
        else builder.append("null\n");
        builder.append("     ]\n");
        builder.append("     facts:[\n");
        if(facts != null) for(Fact fact : facts) builder.append(fact + "\n");
        else builder.append("null\n");
        builder.append("     ]\n");
        builder.append("     display: " + display + "\n");
        builder.append("}\n");

        return builder.toString();
    }
}
