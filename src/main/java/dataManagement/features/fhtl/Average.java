package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public class Average implements IFeature {
    private LabFeatureMaker owner;
    public Average(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Calculate average of probability of birth and probability of death dates matching
        double pBirth = (double)owner.recall(LabFeatureMaker.PBIRTH);
        double pDeath = (double)owner.recall(LabFeatureMaker.PDEATH);

        return new Value((pBirth + pDeath) / 2.0);
    }
}
