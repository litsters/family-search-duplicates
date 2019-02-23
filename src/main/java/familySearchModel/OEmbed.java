package familySearchModel;

/**
 * The online documentation about OEmbed gives no information.
 * Find it here: https://www.familysearch.org/developers/docs/api/types/json_OEmbed
 */
public class OEmbed {
    private String type;
    private String version;
    private String title;
    private String author_name;
    private String author_url;
    private String provider_name;
    private String provider_url;
    private String cache_age;
    private String thumbnail_url;
    private String thumbnail_width;
    private String thumbnail_height;
    private String url;
    private String width;
    private String height;
    private String html;
    private String long_lived_url;
    private String citation;
    private String collection;
    private String collection_uri;
    private String record_contains;

    public OEmbed(){
        type = null;
        version = null;
        title = null;
        author_name = null;
        provider_name = null;
        provider_url = null;
        cache_age = null;
        thumbnail_url = null;
        thumbnail_width = null;
        thumbnail_height = null;
        url = null;
        width = null;
        height = null;
        html = null;
        long_lived_url = null;
        citation = null;
        collection = null;
        collection_uri = null;
        record_contains = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    public void setAuthor_url(String author_url) {
        this.author_url = author_url;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_url() {
        return provider_url;
    }

    public void setProvider_url(String provider_url) {
        this.provider_url = provider_url;
    }

    public String getCache_age() {
        return cache_age;
    }

    public void setCache_age(String cache_age) {
        this.cache_age = cache_age;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getThumbnail_width() {
        return thumbnail_width;
    }

    public void setThumbnail_width(String thumbnail_width) {
        this.thumbnail_width = thumbnail_width;
    }

    public String getThumbnail_height() {
        return thumbnail_height;
    }

    public void setThumbnail_height(String thumbnail_height) {
        this.thumbnail_height = thumbnail_height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getLong_lived_url() {
        return long_lived_url;
    }

    public void setLong_lived_url(String long_lived_url) {
        this.long_lived_url = long_lived_url;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getCollection_uri() {
        return collection_uri;
    }

    public void setCollection_uri(String collection_uri) {
        this.collection_uri = collection_uri;
    }

    public String getRecord_contains() {
        return record_contains;
    }

    public void setRecord_contains(String record_contains) {
        this.record_contains = record_contains;
    }
}
