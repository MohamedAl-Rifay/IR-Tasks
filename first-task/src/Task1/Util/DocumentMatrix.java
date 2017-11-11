package Task1.Util;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Mohamed
 */
public class DocumentMatrix {
    int x = 0;
    private HashMap<String, ArrayList<Boolean>> matrix;
    private ArrayList<Document> allDocs;
    private ArrayList<Boolean> booleanResult;
    
    public DocumentMatrix() {
        matrix = new HashMap<>();
        allDocs = new ArrayList<>();
    }

    public void addDocument(Document d) {
        allDocs.add(d);
    }
    
    public HashMap<String, ArrayList<Boolean>> getMatrix(){
        return matrix;
    }
    
    public ArrayList<Boolean> getBooleanResult(){
        return booleanResult;
    }
    
    public ArrayList<Document> ExcuteQuery(String query) {
        matrix.clear();
        String[] tokens = query.toLowerCase()
                .replaceAll("and|not|or", "")
                .replaceAll("\\(|\\)", " ")
                .replaceAll("[^\\w\\s]|_", "")
                .replaceAll("\\s+", " ")
                .trim()
                .split(" ");
        for (String token : tokens) {
            ArrayList<Boolean> list = new ArrayList<>();
            for (Document d : allDocs) {
                list.add(d.getWords().contains(token));
            }
            matrix.put(token, list);
        }
        ////////////////
        int Brackets = 0, OperatorPriority = 0;
        ArrayList<Operator> Operators = new ArrayList<>();
        ArrayList<String> Operands = new ArrayList<>();
        tokens = query.toLowerCase()
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
        //loop
        booleanResult = eval(Operands);
        ArrayList<Document> docs = new ArrayList<>();
        for (int i = 0; i < booleanResult.size(); i++) {
            if(booleanResult.get(i)){
                docs.add(allDocs.get(i));
            }
        }
        return docs;
    }

    private ArrayList<Boolean> eval(ArrayList<String> Operands) {
        x++;
        String term = Operands.remove(Operands.size() - 1);
        if (term.matches("not|or|and|andnot")) {
            ArrayList<Boolean> result = new ArrayList<>();
            if (term.equals("or")) {
                ArrayList<Boolean> term1 = eval(Operands);
                ArrayList<Boolean> term2 = eval(Operands);
                for (int i = 0; i < term1.size(); i++) {
                    result.add(term1.get(i) || term2.get(i));
                }
            } else if (term.equals("and")) {
                ArrayList<Boolean> term1 = eval(Operands);
                ArrayList<Boolean> term2 = eval(Operands);
                for (int i = 0; i < term1.size(); i++) {
                    result.add(term1.get(i) && term2.get(i));
                }
            } else if (term.equals("not")) {
                ArrayList<Boolean> term1 = eval(Operands);
                for (int i = 0; i < term1.size(); i++) {
                    result.add(!term1.get(i));
                }
            } else { // and not
                ArrayList<Boolean> term1 = eval(Operands);
                ArrayList<Boolean> term2 = eval(Operands);
                for (int i = 0; i < term1.size(); i++) {
                    result.add(term2.get(i) && !term1.get(i));
                }
            }
            return result;
        } else {
            if (matrix.get(term) == null) {
                return new ArrayList<>();
            }
            return matrix.get(term);
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
