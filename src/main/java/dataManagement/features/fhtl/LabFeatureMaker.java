package dataManagement.features.fhtl;

import csvInfo.RowInfo;
import dataManagement.CSVTuple;
import dataManagement.Tuple;
import dataManagement.features.FeatureMaker;
import dataManagement.features.IFeature;

import java.util.ArrayList;
import java.util.List;

public class LabFeatureMaker extends FeatureMaker {
    public static final String BASE_PID_KEY = "BASE_PID";
    public static final String DUPLICATE_KEY = "DUPLICATES";
    public static final String NOT_DUPLICATE_KEY = "NOT_DUPLICATES";
    public static final String BASE_BIRTH = "BASE_BIRTH";
    public static final String OTHER_BIRTH = "OTHER_BIRTH";
    public static final String PBIRTH = "PBIRTH";
    public static final String BASE_DEATH = "BASE_DEATH";
    public static final String OTHER_DEATH = "OTHER_DEATH";
    public static final String PDEATH = "PDEATH";

    @Override
    protected Tuple newTuple() {
        return new CSVTuple();
    }

    @Override
    protected List<IFeature> featureList() {
        List<IFeature> features = new ArrayList<>();
        features.add(new BasePID());
        features.add(new OtherPID());
        features.add(new BaseBirth(this));
        features.add(new OtherBirth(this));
        features.add(new PBirth(this));
        features.add(new BaseDeath(this));
        features.add(new OtherDeath(this));
        features.add(new PDeath(this));
        features.add(new Product(this));
        features.add(new Average(this));
        features.add(new Duplicate(this));
        return features;
    }

    @Override
    protected void preProcess(RowInfo row) {
        // Store info about the labels
        remember(BASE_PID_KEY, row.getBasePid());
        remember(DUPLICATE_KEY, row.getDuplicates());
        remember(NOT_DUPLICATE_KEY, row.getNotDuplicates());
    }
}
