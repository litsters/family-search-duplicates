package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public class OtherBirth implements IFeature {
    private static final String BIRTH_EVENT = "http://gedcomx.org/Birth";

    private LabFeatureMaker owner;
    public OtherBirth(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Extract other person's birth string
        String rawString = otherPerson.getPersons()[0].getDateForEventType(BIRTH_EVENT);
        if(rawString == null) return new Value("missing");
        else {
            // Remember this for later
            owner.remember(LabFeatureMaker.OTHER_BIRTH, rawString);
            return new Value(rawString);
        }
    }
}
