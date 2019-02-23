package familySearchModel;

/**
 * Extra information about a person.
 */
public class PersonInfo {
    private boolean readOnly;               // Set if this person is a readOnly person.
    private boolean privateSpaceRestricted; // Get if this person is a private space restricted person.

    public PersonInfo(){
        readOnly = false;
        privateSpaceRestricted = false;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isPrivateSpaceRestricted() {
        return privateSpaceRestricted;
    }

    public void setPrivateSpaceRestricted(boolean privateSpaceRestricted) {
        this.privateSpaceRestricted = privateSpaceRestricted;
    }
}
