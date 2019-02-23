package importer.proxy;


import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;
import importer.DataImportException;
import importer.ImportThread;

public interface IProxy {
    public void setThread(ImportThread thread);
    public FamilySearchPlatform getAncestry(String pid, String token, int generations) throws DataImportException;
    public FamilySearchPlatform getSpouses(String pid, String token) throws DataImportException;
    public FamilySearchPlatform getChildren(String pid, String token) throws DataImportException;
    public FamilySearchPlatform getParents(String pid, String token) throws DataImportException;
    public FamilySearchPlatform getDetails(String pid, String token) throws DataImportException;
    public FamilySearchPlatform getCurrentUser(String token) throws DataImportException;
}
