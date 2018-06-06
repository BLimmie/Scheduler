package main.java.servlet;
//org.codehaus.jackson:jackson-mapper-asl:1.9.13
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

    public void read(T someT) {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.typeParameterClass.getResourceAsStream(this.filepath);
        try {someT = mapper.readValue(is, this.typeParameterClass);} catch (Exception e){}
    }
}