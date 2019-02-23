package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public class BaseDeath implements IFeature {
    private static final String DEATH_EVENT = "http://gedcomx.org/Death";

    private LabFeatureMaker owner;
    public BaseDeath(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Extract death string from base person
        String rawString = basePerson.getPersons()[0].getDateForEventType(DEATH_EVENT);
        if(rawString == null) return new Value("missing");
        else {
            // Remember this for later
            owner.remember(LabFeatureMaker.BASE_DEATH, rawString);
            return new Value(rawString);
        }
    }
}
