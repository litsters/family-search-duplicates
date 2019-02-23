package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public class BaseBirth implements IFeature {
    private static final String BIRTH_EVENT = "http://gedcomx.org/Birth";

    private LabFeatureMaker owner;
    public BaseBirth(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Extract birth string
        String rawString = basePerson.getPersons()[0].getDateForEventType(BIRTH_EVENT);
        if(rawString == null) return new Value("missing");
        else {
            // Remember this for later
            owner.remember(LabFeatureMaker.BASE_BIRTH, rawString);
            return new Value(rawString);
        }
    }
}
