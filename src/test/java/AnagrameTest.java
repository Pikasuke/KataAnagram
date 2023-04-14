import org.example.Anagramme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AnagrameTest {
    Anagramme anagramme;

    @BeforeEach
    public void setUp() throws IOException {
        anagramme = new Anagramme("src/main/resources/example.txt");
    }

     @Test
    public void isTotoIsAnagramOfOtot() {
        Assertions.assertEquals(true, anagramme.isAnagram("toto", "otot"));
     }
    @Test
    public void isMotoIsAnagramofToto() {
        Assertions.assertEquals(false, anagramme.isAnagram("moto", "otot"));
    }
    @Test
    public void totoIsNotAnagramofToto() {
        Assertions.assertEquals(false, anagramme.isAnagram("toto", "toto"));
    }
    @Test
    public void toBeAnagramWordsShouldBeSameLength() {
        Assertions.assertEquals(false, anagramme.isAnagram("azertyuiopmlkjhgfdsq", "a"));
    }
    @Test
    public void givenAWordAnagramExampleGivesWords() throws IOException {
        anagramme.loadDictionary("src/main/resources/example.txt");
        Assertions.assertEquals(List.of("chine", "niche"), anagramme.getWords("chien"));
        Assertions.assertEquals(List.of("chien", "chine"), anagramme.getWords("niche"));
    }

    //Method ask the system
    @Test
    public void givenATextLookInside() {
           Path result = Paths.get("src/main/resources/dico.txt");
        Assertions.assertEquals("dico.txt", result.getFileName().toString());
    }
    //Method ask the system
    @Test
    public void givenAPathConvertToString() throws IOException {
        Path fileName = Paths.get("src/main/resources/example.txt");
        String content = Files.readString(fileName);
        Assertions.assertEquals("chien\nchine\nniche", content);
    }
    //Method ask the system
    @Test
    public void givenAStringSplitIntoArrayListOfString() {
        String content  = "toto\ntutu";
        List<String> result = Arrays.asList(content.split("\n"));
        Assertions.assertEquals(List.of("toto", "tutu"), result);
    }
    @Test
    public void fromDictionaryToArrayListOfString() throws IOException {
        List<String> dico = anagramme.dictionary("src/main/resources/example.txt");
        Assertions.assertEquals("chien", dico.get(0));
    }
    @Test
    public void findAnagrameOfPOLI() throws IOException {
        anagramme.loadDictionary("src/main/resources/dico.txt");
        Assertions.assertEquals(List.of("POIL"), anagramme.getWords("POLI"));
    }

}
