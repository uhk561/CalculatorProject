package example.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int result = 0;


        while(true) {
            // 사칙연산을 위한 값 입력받기
            System.out.print("계산할 첫 번째 숫자를 입력해 주세요 :  ");
            int num1 = sc.nextInt();

            System.out.print("수행할 연산을 입력해 주세요 :  ");
            // 유연성 증가를 위해 char로 하지 않고 String으로 하였습니다.            양날의 검인가...
            String operator = sc.next();

            System.out.print("계산할 두 번째 숫자를 입력해 주세요 :  ");
            int num2 = sc.nextInt();


            if (operator.equals("+") || operator.equals("더하기")) {
                result = num1 + num2;
            } else if (operator.equals("-") || operator.equals("빼기")) {
                result = num1 - num2;
            } else if (operator.equals("X") || operator.equals("x") || operator.equals("곱하기") || operator.equals("*")) {
                result = num1 * num2;
            } else if  (operator.equals("/") || operator.equals("나누기")) {
                if(num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    result = num1 / num2;
                }
            } else {
                System.out.println("수행할 연산을 정확히 입력해주세요");
            }
            System.out.println("결과 : " + result);
            System.out.println("계속 계산하시려면 아무 키나 종료하시려면 exit를 입력해주세요" );
            String answer = sc.next();
            if(answer.equals("exit")) {
                System.out.println("종료되었습니다.");
                break;
            }
        }

    }
}
