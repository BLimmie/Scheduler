//org.codehaus.jackson:jackson-mapper-asl:1.9.13
package servlet;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsonIO<T> {
    private final Class<T> typeParameterClass;

    private String filepath;

    public JsonIO(String filepath, Class<T> typeParameterClass) {
        this.filepath = filepath;
        this.typeParameterClass = typeParameterClass;
    }

    public void write(T someT) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Writing to a file
            mapper.writeValue(new File(this.filepath), someT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T read() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = JsonIO.class.getResourceAsStream(this.filepath);
        T someT;
        try {
            someT = mapper.readValue(is, this.typeParameterClass);
            return someT;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}