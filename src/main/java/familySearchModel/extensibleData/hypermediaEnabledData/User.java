package familySearchModel.extensibleData.hypermediaEnabledData;

/**
 * Family Tree User Service User
 * Online documentation doesn't give information about any properties.
 * Find it here: https://www.familysearch.org/developers/docs/api/types/json_User
 */
public class User extends HypermediaEnabledData {
    private String contactName;
    private String helperAccessPin;
    private String fullName;
    private String givenName;
    private String familyName;
    private String email;
    private String alternateEmail;
    private String country;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private String mobilePhoneNumber;
    private String mailingAddress;
    private String preferredLanguage;
    private String displayName;
    private String personId;
    private String treeUserId;

    public User(){
        super();
        contactName = null;
        helperAccessPin = null;
        fullName = null;
        givenName = null;
        familyName = null;
        email = null;
        alternateEmail = null;
        country = null;
        gender = null;
        birthDate = null;
        phoneNumber = null;
        mobilePhoneNumber = null;
        mailingAddress = null;
        preferredLanguage = null;
        displayName = null;
        personId = null;
        treeUserId = null;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getHelperAccessPin() {
        return helperAccessPin;
    }

    public void setHelperAccessPin(String helperAccessPin) {
        this.helperAccessPin = helperAccessPin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getTreeUserId() {
        return treeUserId;
    }

    public void setTreeUserId(String treeUserId) {
        this.treeUserId = treeUserId;
    }
}
