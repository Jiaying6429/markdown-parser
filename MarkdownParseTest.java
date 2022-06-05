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

    @Test
    public void testFile1 () throws IOException{
        ArrayList<String> test = new ArrayList<>();
        test.add("url.com");
        test.add("`google.com");
        test.add("google.com");
        test.add("ucsd.edu");

        Path fileName = Path.of("lab4_s1.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
        
    }

    @Test
    public void testFile2 () throws IOException{
        ArrayList<String> test = new ArrayList<>();
        test.add("a.com");
        test.add("a.com(())");
        test.add("example.com");

        Path fileName = Path.of("lab4_s2.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
        
    }

    @Test
    public void testFile3 () throws IOException{
        ArrayList<String> test = new ArrayList<>();
        test.add("https://www.twitter.com");
        test.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        test.add("https://cse.ucsd.edu/");

        Path fileName = Path.of("lab4_s3.md");
        String content = Files.readString(fileName);

        assertEquals(test, MarkdownParse.getLinks(content));
        
    }
}


