package example.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long result = 0;// 결과값 저장 변수    // long으로 자료형 변경
        int num1 = 0; // 연산할 값 저장 1    // 얘네도 변경할까 했지만 요구사항예시에 int인 걸로보아 입력값은 냅뒀습니다.
        int num2 = 0; // 연산할 값 저장 2
        String strOperator; // 연산자 유효성 검사 변수
        char operator = ' '; // 연산자 저장용 변수

        // 계산기 연산  반복문 시작
        while(true) {
            // 첫번째 값 입력받기
            // 숫자만 입력받기 문자나 기호등 입력시 안내문 출력 후 다시 입력 제시
            while (true) {
                System.out.print("계산할 첫 번째 숫자를 입력해 주세요 :  ");
                if (sc.hasNextInt()) {
                    num1 = sc.nextInt();
                    break;
                } else {  // 유효성 검사 숫자가 아닐 시
                    System.out.println("수가 너무 크거나 숫자가 아닙니다.");
                    sc.next();
                }
            }

            // 연산자 입력받기
            while (true) {
                // 유연성 증가를 위해 char로 하지 않고 String으로 하였습니다..
                System.out.print("수행할 연산을 입력해 주세요 :  ");
                strOperator = sc.next().trim();
                if(strOperator.equals("+") || strOperator.equals("더하기")) {
                    operator = '+';
                    break;
                } else if (strOperator.equals("-") || strOperator.equals("빼기")) {
                    operator = '-';
                    break;
                } else if (strOperator.equals("X") || strOperator.equals("x") || strOperator.equals("곱하기") || strOperator.equals("*")) {
                   operator = '*';
                    break;
                } else if  (strOperator.equals("/") || strOperator.equals("나누기")) {
                   operator = '/';
                    break;
                    } else { //유효성 검사 연산관련 문자가 아닐 시
                    System.out.println("더하기, 빼기, 나누기, 곱하기 또는 연산기호만 입력해주세요");
                        continue;
                    }
            }

            while (true) {
                // 두번째 값 입력받기
                System.out.print("계산할 두 번째 숫자를 입력해 주세요 :  ");
                if(sc.hasNextInt()) {
                    num2 = sc.nextInt();
                   if (operator == '/' && num2 == 0) { // 나누기일 때 0을 입력할 경우
                       System.out.println("0으로 나눌 수 없습니다.");
                       continue;
                   }
                   break;
                } else { // 유효성 검사 숫자가 아닐 시
                    System.out.println("수가 너무 크거나 숫자가 아닙니다.");
                    sc.next();
                  }



            }
            // 모든 입력이 맞게 입력됐을 때 연산기호에 맞게 계산 시작
            // 연산식에 long으로 형변환 (큰 수로 테스트해보니 음수값이 나오는 걸보고)
            if (operator == '+') {
                result = (long)num1 +(long)num2;
                if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    System.out.println("결과가 범위벗어남");
                    continue;
                }
            } else if (operator == '-') {
                result = (long)num1 - (long)num2;
                if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    System.out.println("결과가 범위벗어남");
                    continue;
                }
            } else if (operator == '*') {
                result = (long)num1 * (long)num2;
                if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    System.out.println("결과가 범위벗어남");
                    continue;
                }
            } else if (operator == '/') {
                result = (long)num1 / (long)num2;
                if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    System.out.println("결과가 범위벗어남");
                    continue;
                }
            }



            // 결과 출력 및 반복 여부 확인
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
