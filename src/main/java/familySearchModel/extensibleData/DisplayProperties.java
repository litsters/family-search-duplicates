package familySearchModel.extensibleData;

import familySearchModel.extensibleData.hypermediaEnabledData.FamilyView;

/**
 * A set of display properties for the convenience of quick display, such as for a Web-based application.
 * All display properties are provided in the default locale for the current application context and are NOT
 * considered canonical for the purposes of data exchange.
 */
public class DisplayProperties extends ExtensibleData {
    private String name;                    // The displayable name of the person.
    private String gender;                  // The displayable label for the gender of the person.
    private String lifespan;                // The displayable label for the lifespan of the person.
    private String birthDate;               // The displayable label for the birth date of the person.
    private String birthPlace;              // The displayable label for the birth place of the person.
    private String deathDate;               // The displayable label for the death date of the person.
    private String deathPlace;              // The displayable label for the death place of the person.
    private String marriageDate;            // The displayable label for the marriage date of the person.
    private String marriagePlace;           // The displayable label for the marriage place of the person.
    private String ascendancyNumber;        // The context-specific ascendancy number for the person in relation to the other persons in the request. The ancestry number is defined using the Ahnentafel numbering system.
    private String descendancyNumber;       // The context-specific descendancy number for the person in relation to the other persons in the request. The descendancy number is defined using the d'Aboville numbering system.
    private FamilyView[] familiesAsParent;  // The family views where this person is a parent
    private FamilyView[] familiesAsChild;   // The family views where this person is a child

    public DisplayProperties(){
        super();
        name = null;
        gender = null;
        lifespan = null;
        birthDate = null;
        birthPlace = null;
        deathDate = null;
        deathPlace = null;
        marriageDate = null;
        marriagePlace = null;
        ascendancyNumber = null;
        descendancyNumber = null;
        familiesAsParent = null;
        familiesAsChild = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }

    public String getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(String marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getMarriagePlace() {
        return marriagePlace;
    }

    public void setMarriagePlace(String marriagePlace) {
        this.marriagePlace = marriagePlace;
    }

    public String getAscendancyNumber() {
        return ascendancyNumber;
    }

    public void setAscendancyNumber(String ascendancyNumber) {
        this.ascendancyNumber = ascendancyNumber;
    }

    public String getDescendancyNumber() {
        return descendancyNumber;
    }

    public void setDescendancyNumber(String descendancyNumber) {
        this.descendancyNumber = descendancyNumber;
    }

    public FamilyView[] getFamiliesAsParent() {
        return familiesAsParent;
    }

    public void setFamiliesAsParent(FamilyView[] familiesAsParent) {
        this.familiesAsParent = familiesAsParent;
    }

    public FamilyView[] getFamiliesAsChild() {
        return familiesAsChild;
    }

    public void setFamiliesAsChild(FamilyView[] familiesAsChild) {
        this.familiesAsChild = familiesAsChild;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("{\n");
        builder.append("     name: " + name + "\n");
        builder.append("     gender: " + gender + "\n");
        builder.append("     lifespan: " + lifespan + "\n");
        builder.append("     birthDate: " + birthDate + "\n");
        builder.append("     birthPlace: " + birthPlace + "\n");
        builder.append("     deathDate: " + deathDate + "\n");
        builder.append("     deathPlace: " + deathPlace + "\n");
        builder.append("     marriageDate: " + marriageDate + "\n");
        builder.append("     marriagePlace: " + marriagePlace + "\n");
        builder.append("     ascendancyNumber: " + ascendancyNumber + "\n");
        builder.append("     descendancyNumber: " + descendancyNumber + "\n");
        builder.append("}\n");

        return builder.toString();
    }


}
