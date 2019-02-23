package dataManagement.features;

import dataManagement.Value;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

public interface IFeature {
    public Value process(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson);
}
