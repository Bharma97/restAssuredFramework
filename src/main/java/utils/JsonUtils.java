package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, String> jsonObjectMapData(String fileName) throws IOException {
        String completeJasonPath = System.getProperty("user.dir")+"/src/test/resources/" + fileName;
        return objectMapper.readValue(new File(completeJasonPath), new TypeReference<Map<String, String>>() {});
    }
}
