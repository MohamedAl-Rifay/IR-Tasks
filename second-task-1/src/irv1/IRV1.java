/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irv1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class IRV1 {

    public static HashMap<String, HashMap<String, HashSet<Integer>>> pIndex = new HashMap<String, HashMap<String, HashSet<Integer>>>();
    public static HashMap<String, HashSet<Integer>> poIndex = new HashMap<String, HashSet<Integer>>();

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> docs = new ArrayList<>();
        ArrayList<ArrayList<String>> docs_words = new ArrayList<>();

//        Scanner reader = new Scanner(new File("D:\\Drive\\Desktop\\1.txt"));
        Scanner reader = new Scanner(System.in);

        System.out.print("Number of Documents : ");
        int docNum = reader.nextInt();
        reader.nextLine();
        for (int i = 0; i < docNum; i++) {
            System.out.print("Doc " + (i + 1) + " : ");
            docs.add(reader.nextLine());
        }

        for (String doc : docs) {
            docs_words.add(new ArrayList<>(Arrays.asList(doc.replaceAll("\\s+", " ").split(" "))));
        }

        System.out.print("Query : ");
        String query = reader.nextLine();

        String[] query_words = query.toLowerCase().trim().replaceAll("\\s+", " ").split(" ");

        for (int i = 0; i < query_words.length; i++) {
            pIndex.put(query_words[i], new HashMap<String, HashSet<Integer>>());
            for (int j = 0; j < docs_words.size(); j++) {
                pIndexCreator(query_words[i], docs_words.get(j), "doc" + (j + 1));
            }
            System.out.println(query_words[i] + "=>" + pIndex.get(query_words[i]));
        }

        ArrayList<ArrayList<String>> query_docs = new ArrayList<>();

        for (int i = 0; i < query_words.length; i++) {
            poIndex = pIndex.get(query_words[i]);
            query_docs.add(new ArrayList<>());
            for (String key : poIndex.keySet()) {
                query_docs.get(i).add(key);
            }
        }

        ArrayList<String> MatchedDocs = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        result.addAll(query_docs.get(0));
        for (ArrayList<String> query_doc : query_docs) {
            result.retainAll(query_doc);
        }

        boolean match = true;
        for (String doc : result) {
            HashSet<Integer> locations = pIndex.get(query_words[0]).get(doc);
            match = true;
            for (Integer location : locations) {
                for (int i = 1; i < query_words.length; i++) {
                    if (!pIndex.get(query_words[i]).get(doc).contains(location + i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    break;
                }
            }
            if (match) {
                MatchedDocs.add(doc);
            }
        }
        System.out.println("MatchedDocs : " + MatchedDocs);

    }

    public static void pIndexCreator(String queryTerm, ArrayList<String> docWords, String docName) {
        for (int i = 0; i < docWords.size(); i++) {
            if (docWords.get(i).equals(queryTerm)) {
                if (!pIndex.get(queryTerm).containsKey(docName)) {
                    pIndex.get(queryTerm).put(docName, new HashSet<>());
                }
                pIndex.get(queryTerm).get(docName).add(i);
            }
        }
    }

}
