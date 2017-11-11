package Task1.Util;

public class Operator {

    String Operator;
    int Priority;

    public Operator(String Operator, int Priority) {
        this.Operator = Operator;
        this.Priority = Priority;
    }

    @Override
    public String toString() {
        return "Operator{" + "Operator=" + Operator + ", Priority=" + Priority + '}';
    }
}
