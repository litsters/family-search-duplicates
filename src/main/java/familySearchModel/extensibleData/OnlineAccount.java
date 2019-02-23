package familySearchModel.extensibleData;

import familySearchModel.ResourceReference;

/**
 * An online account for a web application.
 */
public class OnlineAccount extends ExtensibleData {
    private ResourceReference serviceHomepage;  // The homepage of the service that provides this account.
    private String accountName;                 // The name associated the holder of this account with the account.

    public OnlineAccount(){
        super();
        serviceHomepage = null;
        accountName = null;
    }

    public ResourceReference getServiceHomepage() {
        return serviceHomepage;
    }

    public void setServiceHomepage(ResourceReference serviceHomepage) {
        this.serviceHomepage = serviceHomepage;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
