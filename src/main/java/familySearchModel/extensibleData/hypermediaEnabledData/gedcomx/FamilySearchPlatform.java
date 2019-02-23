package familySearchModel.extensibleData.hypermediaEnabledData.gedcomx;


import familySearchModel.Feature;
import familySearchModel.Merge;
import familySearchModel.MergeAnalysis;
import familySearchModel.extensibleData.hypermediaEnabledData.Discussion;
import familySearchModel.extensibleData.hypermediaEnabledData.User;
import familySearchModel.extensibleData.hypermediaEnabledData.UserMessageThreadsSummary;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject.ChildAndParentsRelationship;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject.Person;

/**
 * The FamilySearch data types define serialization formats that are specific to the FamilySearch developer platform.
 * These data formats are extensions of the GEDCOM X media types and provide concepts and data types that are specific
 * to FamilySearch and therefore haven't been adopted into a formal, more general specification.
 */
public class FamilySearchPlatform extends Gedcomx {
    private UserMessageThreadsSummary[] userMessageThreadSummaries;     // The user message thread userMessageThreadSummary included in this data set.
    private ChildAndParentsRelationship[] childAndParentsRelationships; // The child-and-parents relationships for this data set.
    private Discussion[] discussions;                                   // The discussions included in this data set.
    private User[] users;                                               // The users included in this data set.
    private Merge[] merges;                                             // The merges for this data set.
    private MergeAnalysis[] mergeAnalyses;                              // The merge analysis results for this data set.
    private Feature[] features;                                         // The set of features defined in the platform API.
    private String description;                                         // Not specified in API; sometimes shows up though.

    public FamilySearchPlatform(){
        super();
        userMessageThreadSummaries = null;
        childAndParentsRelationships = null;
        discussions = null;
        users = null;
        merges = null;
        mergeAnalyses = null;
        features = null;
        description = null;
    }

    public UserMessageThreadsSummary[] getUserMessageThreadSummaries() {
        return userMessageThreadSummaries;
    }

    public void setUserMessageThreadSummaries(UserMessageThreadsSummary[] userMessageThreadSummaries) {
        this.userMessageThreadSummaries = userMessageThreadSummaries;
    }

    public ChildAndParentsRelationship[] getChildAndParentsRelationships() {
        return childAndParentsRelationships;
    }

    public void setChildAndParentsRelationships(ChildAndParentsRelationship[] childAndParentsRelationships) {
        this.childAndParentsRelationships = childAndParentsRelationships;
    }

    public Discussion[] getDiscussions() {
        return discussions;
    }

    public void setDiscussions(Discussion[] discussions) {
        this.discussions = discussions;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Merge[] getMerges() {
        return merges;
    }

    public void setMerges(Merge[] merges) {
        this.merges = merges;
    }

    public MergeAnalysis[] getMergeAnalyses() {
        return mergeAnalyses;
    }

    public void setMergeAnalyses(MergeAnalysis[] mergeAnalyses) {
        this.mergeAnalyses = mergeAnalyses;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode(){
        if(getId() != null) return getId().hashCode();
        else if(getPersons() != null) return getPersons().length * getPersons()[0].getId().hashCode();
        else return 0;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("{\n");
        builder.append("     id: " + getId() + "\n");
        builder.append("     persons: [\n");
        if(getPersons() != null) for(Person person : getPersons()) builder.append(person + "\n");
        builder.append("     ]\n");
        builder.append("    childAndParentsRelationships: [\n");
        if(childAndParentsRelationships != null) for(ChildAndParentsRelationship r : childAndParentsRelationships) builder.append(r + "\n");
        builder.append("     ]\n");

        builder.append("}\n");


        return builder.toString();
    }
}
