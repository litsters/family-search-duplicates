package familySearchModel.extensibleData.hypermediaEnabledData.gedcomx;

import familySearchModel.extensibleData.Attribution;
import familySearchModel.extensibleData.hypermediaEnabledData.Agent;
import familySearchModel.extensibleData.hypermediaEnabledData.HypermediaEnabledData;
import familySearchModel.extensibleData.hypermediaEnabledData.SourceDescription;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject.Person;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject.PlaceDescription;
import familySearchModel.extensibleData.hypermediaEnabledData.conclusion.subject.Relationship;

/**
 * The GEDCOM X data formats define the serialization formats of the GEDCOM X conceptual model.
 */
public class Gedcomx extends HypermediaEnabledData {
    private Attribution attribution;                // The attribution of this genealogical data.
    private Person[] persons;                       // The persons included in this genealogical data set.
    private Relationship[] relationships;           // The relationships included in this genealogical data set.
    private SourceDescription[] sourceDescriptions; // The descriptions of sources included in this genealogical data set.
    private Agent[] agents;                         // The agents included in this genealogical data set.
    private Object[] events;                        // The events included in this genealogical data set. No information in online documentation.
    private PlaceDescription[] places;              // The places included in this genealogical data set.
    private Object[] documents;                     // The documents included in this genealogical data set. No information in online documentation.

    public Gedcomx(){
        super();
        attribution = null;
        persons = null;
        relationships = null;
        sourceDescriptions = null;
        agents = null;
        events = null;
        places = null;
        documents = null;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public Relationship[] getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationship[] relationships) {
        this.relationships = relationships;
    }

    public SourceDescription[] getSourceDescriptions() {
        return sourceDescriptions;
    }

    public void setSourceDescriptions(SourceDescription[] sourceDescriptions) {
        this.sourceDescriptions = sourceDescriptions;
    }

    public Agent[] getAgents() {
        return agents;
    }

    public void setAgents(Agent[] agents) {
        this.agents = agents;
    }

    public Object[] getEvents() {
        return events;
    }

    public void setEvents(Object[] events) {
        this.events = events;
    }

    public PlaceDescription[] getPlaces() {
        return places;
    }

    public void setPlaces(PlaceDescription[] places) {
        this.places = places;
    }

    public Object[] getDocuments() {
        return documents;
    }

    public void setDocuments(Object[] documents) {
        this.documents = documents;
    }
}
