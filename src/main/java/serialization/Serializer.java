package serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * A Singleton that handles JSON serialization.
 */
public class Serializer {
    private static Serializer SINGLETON = null;

    /**
     * Gets the Singleton instance of Serializer
     * @return Obvious.
     */
    public static Serializer get(){
        if(SINGLETON == null) SINGLETON = new Serializer();
        return SINGLETON;
    }

    private Gson gson;

    /**
     * This is private because this is a Singleton.
     */
    private Serializer(){
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    /**
     * Deserializes a JSON string into an Object.
     * @param json The JSON string being used.
     * @param klass The Class of the object being deserialized.
     * @return An Object deserialized from the JSON string.
     */
    public Object deserialize(String json, Class klass) throws SerializeException{
        if(json.trim().equals("")) throw new SerializeException("Can't deserialize empty string");
        try{
            return gson.fromJson(json, klass);
        }catch(Exception e){
            throw new SerializeException(e.getMessage());
        }
    }

    /**
     * Serializes an Object into a JSON String.
     * @param obj The Object to serialize into JSON
     * @return A JSON String representing the Object
     */
    public String serialize(Object obj){
        return gson.toJson(obj);
    }
}
