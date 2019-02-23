package dataManagement.features.fhtl;

import DateComparison.support.DateRange;
import DateComparison.support.Duration;
import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;
import familySearchModel.support.FormalDateConverter;

public class PDeath implements IFeature {
    private static final double WHEN_IN_DOUBT = 0.5;    // Use this value when one or both dates are missing

    private LabFeatureMaker owner;
    public PDeath(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Calculate the probability that the two birthdays are the same
        String rawBaseDeath = (String)owner.recall(LabFeatureMaker.BASE_DEATH);
        String otherBaseDeath = (String)owner.recall(LabFeatureMaker.OTHER_DEATH);

        double probability;
        if(rawBaseDeath == null || otherBaseDeath == null){
            probability = WHEN_IN_DOUBT;
        } else {
            // Calculate actual probability
            FormalDateConverter converter = new FormalDateConverter();
            DateRange base = converter.convert(rawBaseDeath);
            DateRange other = converter.convert(otherBaseDeath);
            probability = base.sameAs(other, new Duration());
        }
        owner.remember(LabFeatureMaker.PDEATH, probability);

        return new Value(probability);
    }
}
