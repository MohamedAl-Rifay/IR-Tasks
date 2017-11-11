/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task1.Util;

import java.util.*;

/**
 *
 * @author Mohamed
 */
public class Document {
    private final String _title;
    private final String _doc;
    private final HashSet<String> _words;
    private static final List<String> StopWords = Arrays.asList(new String[]{"a", "able", "about", "across", "after", "all",
        "almost", "also", "am", "among", "an", "and", "any", "are", "as", "at", "be", "because", "been", "but", "by", "can",
        "cannot", "could", "dear", "did", "do", "does", "either", "else", "ever", "every", "for", "from", "get", "got", "had",
        "has", "have", "he", "her", "hers", "him", "his", "how", "however", "i", "if", "in", "into", "is", "it", "its", "just",
        "least", "let", "like", "likely", "may", "me", "might", "most", "must", "my", "neither", "no", "nor", "not", "of", "off",
        "often", "on", "only", "or", "other", "our", "own", "rather", "said", "say", "says", "she", "should", "since", "so", "some",
        "than", "that", "the", "their", "them", "then", "there", "these", "they", "this", "tis", "to", "too", "twas", "us", "wants",
        "was", "we", "were", "what", "when", "where", "which", "while", "who", "whom", "why", "will", "with", "would", "yet", "you", "your"});
    public Document(String title, String doc) {
        this._title = title;
        this._doc = doc;
        _words = new HashSet<>(Arrays.asList(doc.toLowerCase().replace("\n", " ").trim().replaceAll("[^\\w\\s-_]|^\\s", "").split("\\s+")));
        _words.removeAll(StopWords);
    }

    public String getTitle() {
        return _title;
    }

    public String getDoc() {
        return _doc;
    }

    public HashSet<String> getWords() {
        return _words;
    }

    @Override
    public String toString() {
        return _title;
    }
    
    
    
}
