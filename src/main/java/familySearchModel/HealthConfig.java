package familySearchModel;

/**
 * The online documentation for HealthConfig has no information about its purpose.
 * Find it here: https://www.familysearch.org/developers/docs/api/types/json_HealthConfig
 */
public class HealthConfig {
    private String[] xPart1;
    private String[] xPart2;
    private String platformVersion;
    private String buildVersion;
    private String buildDate;
    private String systemName;
    private String serviceConfigurationName;
    private String catalinaBase;
    private String hostname;
    private String username;
    private String osName;
    private String osVersion;
    private String osArch;
    private String javaVersion;
    private String javaRuntimeVersion;
    private String javaSpecificationVendor;
    private String baseUri;
    private String originalPath;

    public HealthConfig(){
        xPart1 = null;
        xPart2 = null;
        platformVersion = null;
        buildVersion = null;
        buildDate = null;
        systemName = null;
        serviceConfigurationName = null;
        catalinaBase = null;
        hostname = null;
        username = null;
        osName = null;
        osVersion = null;
        osArch = null;
        javaVersion = null;
        javaRuntimeVersion = null;
        javaSpecificationVendor = null;
        baseUri = null;
        originalPath = null;
    }

    public String[] getxPart1() {
        return xPart1;
    }

    public void setxPart1(String[] xPart1) {
        this.xPart1 = xPart1;
    }

    public String[] getxPart2() {
        return xPart2;
    }

    public void setxPart2(String[] xPart2) {
        this.xPart2 = xPart2;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getServiceConfigurationName() {
        return serviceConfigurationName;
    }

    public void setServiceConfigurationName(String serviceConfigurationName) {
        this.serviceConfigurationName = serviceConfigurationName;
    }

    public String getCatalinaBase() {
        return catalinaBase;
    }

    public void setCatalinaBase(String catalinaBase) {
        this.catalinaBase = catalinaBase;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getJavaRuntimeVersion() {
        return javaRuntimeVersion;
    }

    public void setJavaRuntimeVersion(String javaRuntimeVersion) {
        this.javaRuntimeVersion = javaRuntimeVersion;
    }

    public String getJavaSpecificationVendor() {
        return javaSpecificationVendor;
    }

    public void setJavaSpecificationVendor(String javaSpecificationVendor) {
        this.javaSpecificationVendor = javaSpecificationVendor;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }
}
