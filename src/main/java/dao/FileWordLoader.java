package dao;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileWordLoader implements WordLoader {

    private String path;
    private int length;

    public FileWordLoader(String pathToFile, int lengthOfSearchingWords) {
        this.path = pathToFile;
        this.length = lengthOfSearchingWords;
    }

    @Override
    public Set<CharSequence> loadWords() {
        Set<CharSequence> words = new HashSet<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(path));

            String word;
            while((word = reader.readLine()) != null) {
                if (word.length() == length) {
                    words.add(word.toLowerCase());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
