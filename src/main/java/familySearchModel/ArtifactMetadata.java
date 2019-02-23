package familySearchModel;

/**
 * FamilySearch-specific metadata about an artifact.
 */
public class ArtifactMetadata {
    private String filename;        // The original filename of the memories item.
    private Qualifier[] qualifiers; // The qualifiers associated with this artifact.
    private double width;           // The width of the artifact (presumably an image).
    private double height;          // The height of the artifact (presumably an image).
    private double size;            // The size of the artifact.
    private String screeningState;  // The screening state of the artifact.
    private boolean editable;       // Whether or not the artifact is editable by the current user.

    public ArtifactMetadata(){
        filename = null;
        qualifiers = null;
        width = -1;
        height = -1;
        size = -1;
        screeningState = null;
        editable = false;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Qualifier[] getQualifiers() {
        return qualifiers;
    }

    public void setQualifiers(Qualifier[] qualifiers) {
        this.qualifiers = qualifiers;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getScreeningState() {
        return screeningState;
    }

    public void setScreeningState(String screeningState) {
        this.screeningState = screeningState;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
