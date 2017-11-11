package irv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class IRV2 {

    static HashMap<String, LinkedHashMap<String, String>> Details = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<String> docs = new ArrayList<>();
        ArrayList<ArrayList<String>> docs_words = new ArrayList<>();
        HashMap<String, HashMap<String, Double>> term_frequensy = new HashMap<>();
        HashMap<String, Integer> max_values = new HashMap<>();

        Scanner reader = new Scanner(System.in);

        System.out.print("Number of Documents : ");
        int docNum = reader.nextInt();
        reader.nextLine();
        for (int i = 0; i < docNum; i++) {
            System.out.print("Doc " + (i + 1) + " : ");
            docs.add(reader.nextLine());
        }
//        String doc_1 = "new york times";
//        String doc_2 = "new york post";
//        String doc_3 = "los Angeles times";
//
//        docs.add(doc_1);
//        docs.add(doc_2);
//        docs.add(doc_3);

        for (int i = 0; i < docs.size(); i++) {
            String doc = docs.get(i);
            String name = "doc" + (i + 1);
            docs_words.add(new ArrayList<>(Arrays.asList(doc.split(" "))));
            max_values.put(name, 0);
            for (String word : docs_words.get(docs_words.size() - 1)) {
                if (!term_frequensy.containsKey(word)) {
                    term_frequensy.put(word, new HashMap<>());
                }
                for (int j = 1; j < docs.size() + 1; j++) {
                    if (!term_frequensy.get(word).containsKey("doc" + j)) {
                        term_frequensy.get(word).put("doc" + j, 0d);
                    }
                }

                term_frequensy.get(word).put(name, term_frequensy.get(word).get(name) + 1);
            }
        }

        for (Map.Entry<String, HashMap<String, Double>> entrySet : term_frequensy.entrySet()) {
            HashMap<String, Double> value = entrySet.getValue();
            for (Map.Entry<String, Double> subset : value.entrySet()) {
                String key1 = subset.getKey();
                Double value1 = subset.getValue();
                if (max_values.get(key1) < value1) {
                    max_values.put(key1, value1.intValue());
                }
            }
        }
        //System.out.println("max => " + max_values);

        for (Map.Entry<String, HashMap<String, Double>> entrySet : term_frequensy.entrySet()) {
            String key = entrySet.getKey();
            HashMap<String, Double> value = entrySet.getValue();
            int countDocs = 0;
            for (Double i : value.values()) {
                countDocs += i > 0 ? 1 : 0;
            }
            Double idf = Math.log10(docs.size() * 1.0 / countDocs) / Math.log10(2);
            addData(key, "idf", "" + idf, "");
            for (Map.Entry<String, Double> subset : value.entrySet()) {
                String key1 = subset.getKey();
                Double value1 = subset.getValue();
                Double tf = 1 + Math.log10(value1 / max_values.get(key1)) / Math.log10(2);
                if (tf.isInfinite()) {
                    tf = 0d;
                }
                term_frequensy.get(key).put(key1, tf * idf);
                addData(key, "tf", "" + tf, key1);
                addData(key, "tf*idf", "" + (tf * idf), key1);
            }
        }
        System.out.print("Query : ");
        String query = reader.nextLine();
        printDetails();
        reset();
        String[] query_words = query.toLowerCase().trim().split(" ");

        HashMap<String, Double> queryscore = new HashMap<>();
        HashMap<String, Integer> query_max = new HashMap<>();
        for (String word : query_words) {
            query_max.put(word, query_max.getOrDefault(word, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entrySet : query_max.entrySet()) {
            Integer value = entrySet.getValue();
            if (value > max) {
                max = value;
            }
        }
        //System.out.println("max : " + max);
        //System.out.println(query_max);
        for (Map.Entry<String, Integer> entrySet : query_max.entrySet()) {
            String key = entrySet.getKey();
            Integer value = entrySet.getValue();
            Double tf = 1.0 * value / max;
            int countDocs = 0;
            for (Double i : term_frequensy.getOrDefault(key, new HashMap<>()).values()) {
                countDocs += i > 0 ? 1 : 0;
            }
            Double idf = Math.log10(docs.size() * 1.0 / countDocs) / Math.log10(2);
            if (idf.isInfinite()) {
                idf = 0d;
            }
            addData(key, "idf", "" + idf, "");
            addData(key, "tf", "" + tf, "query");
            addData(key, "tf*idf", "" + (tf * idf), "query");
            queryscore.put(key, tf * idf);
        }
        System.out.println("\n\nQuery:-");
        printDetails();
    }

    static void addData(String word, String key, String value, String doc) {
        Details.put(word, Details.getOrDefault(word, new LinkedHashMap<>()));
        if (key.matches("idf")) {
            Details.get(word).put(key, value);
        } else if (doc.equals("query")) {
            Details.get(word).put(key, value);
        } else {
            Details.get(word).put(key, Details.get(word).getOrDefault(key, "") + doc + "->" + value + ", ");
        }
    }

    static void reset() {
        Details.clear();
    }

    static void printDetails() {
        for (Map.Entry<String, LinkedHashMap<String, String>> entry : Details.entrySet()) {
            String word = entry.getKey();
            LinkedHashMap<String, String> data = entry.getValue();
            System.out.println(word);
            for (Map.Entry<String, String> entry1 : data.entrySet()) {
                String key = entry1.getKey();
                String value = entry1.getValue();
                System.out.println(key + "\t = [" + value.replaceAll(", $", "") + "]");
            }
            System.out.println("-------------");
        }
    }
}
