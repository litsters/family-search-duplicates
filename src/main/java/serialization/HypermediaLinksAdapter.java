package serialization;

import familySearchModel.Link;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class assists Gson when dealing with Hypermedia links, because they are truly awful for deserialization.
 * The Json from Family Search can be stupid. In particular, the 'links' field of Hypermedia objects can come as a single
 * map, or as a list of maps. To make it worse, each map has values that can be either a single Link or a list
 * of Links. This class handles the variability, always converting to a list of maps of strings to lists of Links.
 */
public class HypermediaLinksAdapter extends TypeAdapter<List<Map<String, List<Link>>>> {

    /**
     * Converts a dumb thing to JSON.
     * @param jsonWriter The JsonWriter to write the json to. Usually provided by Gson.
     * @param maps The dumb thing to convert.
     * @throws IOException If the JsonWriter's connection is lost.
     */
    @Override
    public void write(JsonWriter jsonWriter, List<Map<String, List<Link>>> maps) throws IOException {
        jsonWriter.beginArray();
        for(Map<String, List<Link>> map : maps){
            jsonWriter.beginObject();
            for(String key : map.keySet()){
                List<Link> links = map.get(key);
                jsonWriter.name(key);
                jsonWriter.beginArray();
                for(Link link : links){
                    jsonWriter.beginObject();

                    jsonWriter.name("offset").value(link.getOffset());
                    jsonWriter.name("href").value(link.getHref());
                    jsonWriter.name("template").value(link.getTemplate());
                    jsonWriter.name("title").value(link.getTitle());
                    jsonWriter.name("type").value(link.getType());
                    jsonWriter.name("accept").value(link.getAccept());
                    jsonWriter.name("allow").value(link.getAllow());
                    jsonWriter.name("hreflang").value(link.getHreflang());

                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
        jsonWriter.endArray();
    }

    /**
     * Reads a Link from Json.
     * @param in The JsonReader with the Json.
     * @return A Link object built from the Json.
     * @throws IOException If the connection to the JsonReader is lost.
     */
    private Link readLink(JsonReader in) throws IOException{
        in.beginObject();
        Link link = new Link();

        JsonToken token = in.peek();
        while(token.equals(JsonToken.NAME)){
            String name = in.nextName();
            if(name.matches("offset")){
                int value = in.nextInt();
                link.setOffset(value);
            } else {
                String value = in.nextString();
                switch(name){
                    case "href":
                        link.setHref(value);
                        break;
                    case "template":
                        link.setTemplate(value);
                        break;
                    case "title":
                        link.setTitle(value);
                        break;
                    case "type":
                        link.setType(value);
                        break;
                    case "accept":
                        link.setAccept(value);
                        break;
                    case "allow":
                        link.setAllow(value);
                        break;
                    case "hreflang":
                        link.setHreflang(value);
                        break;
                    default:
                        throw new MalformedJsonException("Unknown Link field: " + name);
                }
            }
            token = in.peek();
        }


        in.endObject();
        return link;
    }

    /**
     * Reads a map of String to list of Links from Json.
     * @param in The JsonReader with the Json.
     * @return A mapping of strings to lists of Links.
     * @throws IOException If the connection to the JsonReader is lost.
     */
    private Map<String, List<Link>> readMap(JsonReader in) throws IOException{
        in.beginObject();
        Map<String, List<Link>> map = new HashMap<>();
        JsonToken token = in.peek();
        while(token.equals(JsonToken.NAME)){
            String key = in.nextName();
            // Detect if the links are an array or a single object
            List<Link> list = new ArrayList<>();
            token = in.peek();
            if(token.equals(JsonToken.BEGIN_ARRAY)){
                // There is already a list of links
                in.beginArray();
                token = in.peek();
                while(token.equals(JsonToken.BEGIN_OBJECT)){
                    list.add(readLink(in));
                    token = in.peek();
                }
                in.endArray();
            } else {
                // There is only one link
                list.add(readLink(in));
            }
            map.put(key, list);
            token = in.peek();
        }

        in.endObject();
        return map;
    }

    /**
     * Reads a dumb thing from Json.
     * @param in The JsonReader with the Json.
     * @return A list of mappings of strings to lists of Links. This is used in the 'links' attribute of HypermediaEnabledObjects.
     * @throws IOException If the connection to the JsonReader is lost.
     */
    @Override
    public List<Map<String, List<Link>>> read(JsonReader in) throws IOException {
        List<Map<String, List<Link>>> list = new ArrayList<>();
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
}
