import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile () throws IOException{
        ArrayList<String> test = new ArrayList<>();
        test.add("https://something.com");
        test.add("some-thing.html");

        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
        
    }
}


