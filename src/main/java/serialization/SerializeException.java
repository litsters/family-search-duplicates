package serialization;

/**
 * This exception is used to indicate an error while serializing or deserializing Json objects.
 */
public class SerializeException extends Exception {
    public SerializeException(){super();}
    public SerializeException(String message){super(message);}
}
