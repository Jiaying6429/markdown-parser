import static org.junit.Assert.*;
<<<<<<< HEAD
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-thing.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testLinkAtBeginning() {
        String contents= "[link title](a.com)";
        List<String> expect = List.of("a.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceInURL() {
        String contents = "[title](space in-url.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSpaceBeforeParen() {
        String contents = "[title]   (should-not-count.com)";
        List<String> expect = List.of();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testNestedParens() throws IOException {
        String contents = Files.readString(Path.of("test-parens-inside-link.md"));
        List<String> expect = List.of("something.com()", "something.com((()))", "something.com", "boring.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testMissingCloseParen() throws IOException {
        String contents = Files.readString(Path.of("test-missing-paren-plus-test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
}
=======
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


>>>>>>> 50e94256fbed7420c61ac234383e2a1524d4e9f5
