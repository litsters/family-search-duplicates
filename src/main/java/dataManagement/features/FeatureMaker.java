package dataManagement.features;

import csvInfo.RowInfo;
import dataManagement.Tuple;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FeatureMaker {
    private List<IFeature> features;
    private Map<String,Object> memory;

    public FeatureMaker(){
        features = featureList();
        memory = new HashMap<>();
    }

    public Tuple makeTuple(FamilySearchPlatform basePerson, FamilySearchPlatform otherPerson, RowInfo row) throws Exception{
        if(basePerson == null || otherPerson == null) throw new Exception("Missing family search data");
        clearMemory();      // Don't want previous runs to contaminate this one
        preProcess(row);    // In case there is anything that needs to be done before processing
        Tuple tuple = newTuple();
        for(IFeature feature : features){
            tuple.addValue(feature.process(basePerson, otherPerson));
        }
        return tuple;
    }

    private void clearMemory(){memory = new HashMap<>();}

    /**
     * Store a key-value pair for internal use, primarily by features that need to remember something
     * @param key The key to identify the data. Must be unique.
     * @param value The value to remember.
     */
    public void remember(String key, Object value){ memory.put(key, value);}

    /**
     * Retrieve a value for a given key.
     * @param key The key to use.
     * @return The value associated with the key, or null if no matching entry.
     */
    public Object recall(String key){return memory.get(key);}

    /**
     * Produce an empty tuple of the correct type.
     * @return Obvious
     */
    protected abstract Tuple newTuple();

    /**
     * Produce a list of all the features to be used in generating tuples.
     * @return Obvious
     */
    protected abstract List<IFeature> featureList();

    /**
     * Do any processing necessary before processing the row. May not be needed by all implementations.
     * @param row The row to pre-process.
     */
    protected abstract void preProcess(RowInfo row);
}
