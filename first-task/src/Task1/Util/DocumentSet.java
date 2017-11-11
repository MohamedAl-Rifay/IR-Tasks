package Task1.Util;

import java.util.*;

/**
 *
 * @author Mohamed
 */
public class DocumentSet {

    private final HashMap<String, LinkedHashSet<Document>> Docs;
    private final LinkedHashSet<Document> allDocs;
    private final ArrayList<String> queryTokens;

    public DocumentSet() {
        Docs = new HashMap<>();
        allDocs = new LinkedHashSet<>();
        queryTokens = new ArrayList<>();
    }

    public HashMap<String, LinkedHashSet<Document>> getQueryPostingList() {
        HashMap<String, LinkedHashSet<Document>> result = new HashMap<>();
        queryTokens.forEach((term) -> {
            result.put(term, Docs.getOrDefault(term, new LinkedHashSet<>()));
        });
        return result;
    }

    public void addDocument(Document d) {
        allDocs.add(d);
        for (String word : d.getWords()) {
            if (Docs.containsKey(word)) {
                Docs.get(word).add(d);
            } else {
                LinkedHashSet<Document> set = new LinkedHashSet<>();
                set.add(d);
                Docs.put(word, set);
            }
        }
    }

    public LinkedHashSet<Document> ExcuteQuery(String query) {
        queryTokens.clear();
        int Brackets = 0, OperatorPriority = 0;
        ArrayList<Operator> Operators = new ArrayList<>();
        ArrayList<String> Operands = new ArrayList<>();
        String[] tokens = query.toLowerCase()
                .replaceAll("or\\s+(not\\s+\\w+)", "or ($1)")
                .replaceAll("and not|not", "andnot")
                .replaceAll("^andnot", "not")
                .replaceAll("\\(\\s*andnot", "(not ")
                .replaceAll("\\(|\\)", " $0 ")
                .replaceAll("\\s+", " ")
                .replaceAll("[^\\w\\s\\(\\)]|_", "")
                .split(" ");
        for (String token : tokens) {
            if (token.matches("not|or|and|andnot")) {
                OperatorPriority = getPriority(token) + Brackets * 3;
                if (Operators.isEmpty()) {
                    Operators.add(new Operator(token, OperatorPriority));
                } else {
                    while (!Operators.isEmpty() && Operators.get(Operators.size() - 1).Priority > OperatorPriority) {
                        Operands.add(Operators.remove(Operators.size() - 1).Operator);
                    }
                    Operators.add(new Operator(token, OperatorPriority));
                }
            } else if (token.equals("(")) {
                Brackets++;
            } else if (token.equals(")")) {
                Brackets--;
            } else {
                Operands.add(token);
            }
        }
        while (!Operators.isEmpty()) {
            Operands.add(Operators.remove(Operators.size() - 1).Operator);
        }
        return eval(Operands);
    }

    private LinkedHashSet<Document> eval(ArrayList<String> Operands) {
        String term = Operands.remove(Operands.size() - 1);
        if (term.matches("not|or|and|andnot")) {
            LinkedHashSet<Document> result = new LinkedHashSet<>();
            if (term.equals("or")) {
                result.addAll(eval(Operands));
                result.addAll(eval(Operands));
            } else if (term.equals("and")) {
                result.addAll(eval(Operands));
                result.retainAll(eval(Operands));
            } else if (term.equals("not")) {
                result.addAll(allDocs);
                result.removeAll(eval(Operands));
            } else {
//                LinkedHashSet<Document> temp = eval(Operands);
//                result.addAll(eval(Operands));
//                result.removeAll(temp);
                /////
                result.addAll(allDocs);
                result.removeAll(eval(Operands));
                result.retainAll(eval(Operands));
            }
            return result;
        } else {
            queryTokens.add(term);
            if (Docs.get(term) == null) {
                return new LinkedHashSet<>();
            }
            return Docs.get(term);
        }
    }

    private int getPriority(String Operator) {
        if (Operator.matches("not|andnot")) {
            return 2;
        } else if (Operator.equals("and")) {
            return 1;
        } else {
            return 0;
        }
    }
}
