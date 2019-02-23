package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public class Product implements IFeature {
    private LabFeatureMaker owner;
    public Product(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Calculate product of probability of birth and probability of death dates matching
        double pBirth = (double)owner.recall(LabFeatureMaker.PBIRTH);
        double pDeath = (double)owner.recall(LabFeatureMaker.PDEATH);

        return new Value(pBirth * pDeath);
    }
}
