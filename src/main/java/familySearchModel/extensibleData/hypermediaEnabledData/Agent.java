package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.ResourceReference;
import familySearchModel.textValue.TextValue;
import familySearchModel.extensibleData.Address;
import familySearchModel.extensibleData.OnlineAccount;
import com.google.gson.annotations.JsonAdapter;
import serialization.IdentifiersAdapter;

import java.util.List;
import java.util.Map;

/**
 * An agent, e.g. person, organization, or group. In genealogical research, an agent often takes the role of a contributor.
 */
public class Agent extends HypermediaEnabledData {
    @JsonAdapter(IdentifiersAdapter.class)
    private List<Map<String,String>> identifiers;   // The list of identifiers for the agent.
    private TextValue[] names;                  // The list of names for the agent.
    private ResourceReference homepage;         // The homepage of the person or organization. Note this is different from the homepage of the service where the person or organization has an account.
    private ResourceReference openid;           // The openid of the person or organization.
    private OnlineAccount[] accounts;           // The accounts that belong to this person or organization.
    private ResourceReference[] emails;         // The emails that belong to this person or organization.
    private ResourceReference[] phones;         // The phones that belong to this person or organization.
    private Address[] addresses;                // The addresses that belong to this person or organization.

    public Agent(){
        super();
        identifiers = null;
        names = null;
        homepage =  null;
        openid = null;
        accounts = null;
        emails = null;
        phones = null;
        addresses = null;
    }

    public List<Map<String, String>> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Map<String, String>> identifiers) {
        this.identifiers = identifiers;
    }

    public TextValue[] getNames() {
        return names;
    }

    public void setNames(TextValue[] names) {
        this.names = names;
    }

    public ResourceReference getHomepage() {
        return homepage;
    }

    public void setHomepage(ResourceReference homepage) {
        this.homepage = homepage;
    }

    public ResourceReference getOpenid() {
        return openid;
    }

    public void setOpenid(ResourceReference openid) {
        this.openid = openid;
    }

    public OnlineAccount[] getAccounts() {
        return accounts;
    }

    public void setAccounts(OnlineAccount[] accounts) {
        this.accounts = accounts;
    }

    public ResourceReference[] getEmails() {
        return emails;
    }

    public void setEmails(ResourceReference[] emails) {
        this.emails = emails;
    }

    public ResourceReference[] getPhones() {
        return phones;
    }

    public void setPhones(ResourceReference[] phones) {
        this.phones = phones;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }
}
