package familySearchModel;

/**
 * A common representation of an error on the FamilySearch platform.
 */
public class Error {
    private int code;           // The error code. Intepreted per RFC 2616, Section 10 (HTTP Status Code Definitions).
    private String label;       // A text label associated with the error code.
    private String message;     // A message associated with the error.
    private String stacktrace;  // The back-end stack trace associated with the error, useful for debugging.

    public Error(){
        code = -1;
        label = null;
        message = null;
        stacktrace = null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }
}
