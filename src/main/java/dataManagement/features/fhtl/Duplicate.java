package dataManagement.features.fhtl;

import dataManagement.Value;
import dataManagement.features.IFeature;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

import java.util.List;

public class Duplicate implements IFeature {
    private LabFeatureMaker owner;
    public Duplicate(LabFeatureMaker owner){this.owner = owner;}

    @Override
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson) {
        // Determine if the two people are duplicate or not
        String otherPID = otherPerson.getPersons()[0].getId();
        List<String> duplicates = (List<String>)this.owner.recall(LabFeatureMaker.DUPLICATE_KEY);
        if(duplicates.contains(otherPID)) return new Value("Y");
        else return new Value("N");
    }
}
