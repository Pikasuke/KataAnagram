package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Anagramme {

    private List<String> dictionary;

    public Anagramme(String path) throws IOException {
        loadDictionary(path);
    }


    public boolean isAnagram(String word1, String word2) {
        if (word1.equals(word2)) {
            return false;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] arrayWord1 = word1.toCharArray();
        char[] arrayWord2 = word2.toCharArray();
        Arrays.sort(arrayWord1);
        Arrays.sort(arrayWord2);
        for (int i = 0; i < arrayWord1.length; i++) {
            if (arrayWord1[i] != arrayWord2[i]) {
                return false;
            }
        }
        return true;
    }

    public List<String> getWords(String source) throws IOException {

        List<String> results = new ArrayList<>();


        //List<String> dictionary = Anagramme.dictionary("src/main/resources/dico.txt");


        for (String word : this.dictionary ) {
            if (this.isAnagram(source, word)) {
                results.add(word);
            }
        }
        Collections.sort(results);
        return results;
    }

    public static List<String> dictionary(String path) throws IOException {
        String content = Files.readString(Paths.get(path));
        return Arrays.asList(content.split("\n"));
    }

    public void loadDictionary(String dicoPath) throws IOException {
        this.dictionary = dictionary(dicoPath);
    }
}

