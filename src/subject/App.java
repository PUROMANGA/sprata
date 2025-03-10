package subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        Calculator<Integer> calculator;

        while (true) {

            while (true) {
                try {
                    System.out.print("첫 번째 정수를 넣으시오");
                    num1 = sc.nextInt();
                    if (num1 >= 0) {
                        System.out.println("첫 번째 정수 = " + num1);
                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                    }
                } catch (Exception e) {
                    System.out.println("유효한 입력이 아닙니다!");
                    sc.next();
                }
            }

            while (true) {
                try {
                    System.out.print("두 번째 정수를 넣으시오");
                    num2 = sc.nextInt();
                    if (num2 >= 0) {
                        System.out.println("두 번째 정수 = " + num2);
                        break;
                    } else {
                        System.out.println("다시 입력해주세요");
                    }
                } catch (Exception e) {
                    System.out.println("유효한 입력이 아닙니다!");
                    sc.next();
                }
            }

            calculator = new Calculator<>(num1, num2);

            while (true) {

                System.out.println("사칙 연산(+,-,*,/)을 입력해주세요");
                String operatorInput = sc.next();

                Operator operator = Operator.isOperator(operatorInput);

                int result;

                if (operator == null) {
                    System.out.println("옳바른 사칙 연산을 입력해주세요");
                    continue;
                } else {
                    result = operator.apply(num1, num2);
                }
                System.out.println("결과 값 = " + result);
                calculator.addResult(result);
                break;
            }

            System.out.println("저장된 결과: " + calculator.getResults());

            System.out.print("비교할 기준 값을 입력하세요: ");
            Integer threshold = sc.nextInt();
            ArrayList<Integer> greaterResults = calculator.getResultsGreaterThan(threshold);

            if (greaterResults.isEmpty()) {
                System.out.println("입력한 값보다 큰 결과가 없습니다.");
            } else {
                System.out.println("입력한 값보다 큰 결과 목록: " + greaterResults);
            }

            System.out.println("계산을 종료할까요? EXIT을 입력하면 계산을 종료합니다.");
            String exit = sc.next();

            if (exit.equals("exit")) {
                System.out.println("계산을 종료합니다");
                sc.close();
                break;
            } else {
                System.out.println("다른 입력이 감지되었습니다.");
                System.out.println("계산을 다시 시작합니다.");
            }
        }
    }
}