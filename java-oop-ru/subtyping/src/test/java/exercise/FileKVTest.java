package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();
    private static Path testFilePath = Paths.get("src/test/resources/testFile.json").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void setFileTest() {
        FileKV storage =
                new FileKV(testFilePath.toString(), Map.of("key1", "value1", "key2", "value2"));
        storage.saveToFile();
        String fileSaveStr = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        assertThat(Utils.readFile(testFilePath.toString())).isEqualTo(fileSaveStr);
        storage.set("key3", "value3");
        assertThat(storage.toMap()).isNotEqualTo(Map.of("key1", "value1", "key2", "value2"));
        storage.loadFromFile();
        assertThat(storage.toMap()).isEqualTo(Map.of("key1", "value1", "key2", "value2"));
    }
    // END
}
