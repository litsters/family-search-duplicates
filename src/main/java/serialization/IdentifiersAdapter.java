package serialization;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Assists Gson with serializing the Identifiers field, found in some classes. It is truly awful. The 'identifiers' field
 * of Agent and SourceDescription can come as a single map or as a list of maps, and to make it worse each map has values
 * that can come as either a string or a list of strings. This class deals with the ambiguity by always converting them
 * to a list of maps of strings to lists of strings.
 */
public class IdentifiersAdapter extends TypeAdapter<List<Map<String, List<String>>>> {

    /**
     * Writes stupid stuff to Json.
     * @param out The JsonWriter the Json is being written to. This is usually provided by Gson.
     * @param maps The stupid stuff being written to Json.
     * @throws IOException If the connection to the JsonWriter is lost.
     */
    @Override
    public void write(JsonWriter out, List<Map<String, List<String>>> maps) throws IOException {
        out.beginArray();
        for(Map<String, List<String>> map : maps){
            out.beginObject();
            for(String key : map.keySet()){
                List<String> identifiers = map.get(key);
                out.name(key);
                out.beginArray();
                for(String identifier : identifiers){
                    out.value(identifier);
                }
                out.endArray();
            }
            out.endObject();
        }
        out.endArray();
    }

    /**
     * Reads stupid stuff from Json.
     * @param in The JsonReader that is the source of the Json. It is usually provided by Gson.
     * @return Stupid stuff.
     * @throws IOException If the connection to the JsonReader is lost.
     */
    @Override
    public List<Map<String, List<String>>> read(JsonReader in) throws IOException {
        List<Map<String, List<String>>> list = new ArrayList<>();
        JsonToken token = in.peek();
        if(token.equals(JsonToken.BEGIN_ARRAY)){
            // This is an array
            in.beginArray();
            token = in.peek();
            while(token.equals(JsonToken.BEGIN_OBJECT)){
                list.add(readMap(in));
                token = in.peek();
            }
            in.endArray();
        } else {
            // This is an object
            list.add(readMap(in));
        }
        return list;
    }

    /**
     * Reads a map of strings to lists of strings from Json.
     * @param in The JsonReader that is the source of the Json. It is usually provided by Gson.
     * @return Obvious.
     * @throws IOException If the connection to the JsonReader is lost.
     */
    private Map<String, List<String>> readMap(JsonReader in) throws IOException{
        in.beginObject();
        Map<String, List<String>> map = new HashMap<>();
        JsonToken token = in.peek();
        while(token.equals(JsonToken.NAME)){
            String key = in.nextName();
            // Detect if the links are an array or a single object
            List<String> list = new ArrayList<>();
            token = in.peek();
            if(token.equals(JsonToken.BEGIN_ARRAY)){
                // There is already a list of links
                in.beginArray();
                token = in.peek();
                while(token.equals(JsonToken.STRING)){
                    list.add(in.nextString());
                    token = in.peek();
                }
                in.endArray();
            } else {
                // There is only one link
                list.add(in.nextString());
            }
            map.put(key, list);
            token = in.peek();
        }

        in.endObject();
        return map;
    }
}
