package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public class OtherDeath implements IFeature {
    private static final String DEATH_EVENT = "http://gedcomx.org/Death";

    private LabFeatureMaker owner;
    public OtherDeath(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Extract death string from base person
        String rawString = otherPerson.getPersons()[0].getDateForEventType(DEATH_EVENT);
        if(rawString == null) return new Value("missing");
        else {
            // Remember this for later
            owner.remember(LabFeatureMaker.OTHER_DEATH, rawString);
            return new Value(rawString);
        }
    }
}