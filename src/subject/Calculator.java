package subject;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Calculator<T extends Number> {

    private T number1;
    private T number2;

    private ArrayList<T> list = new ArrayList<T>();

    Calculator(T number1, T number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public void addResult(T result) {  // ✅ 결과를 저장하는 메서드
        list.add(result);
    }

    public ArrayList<T> getResults() {  // ✅ 저장된 결과를 반환하는 메서드
        return list;
    }

    public void removeResult(Number result) {
        list.remove(result);
    }

    public ArrayList<T> getResultsGreaterThan(T threshold) {
        return (ArrayList<T>) list.stream()
                .filter(r -> r.doubleValue() > threshold.doubleValue())
                .collect(Collectors.toList());
    }
}