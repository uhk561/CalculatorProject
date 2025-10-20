package example.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Calculator calculator = new Calculator();
        ArithmeticCalculator calculator = new ArithmeticCalculator();


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
                result = calculator.calculate(num1,num2,operator);


            // 결과 출력 및 반복 여부 확인 메뉴
            System.out.println("\n\n\n결과 : " + result  + "\n\n\n");
            System.out.println("1. 계속 계산하기");
            System.out.println("2. 종료하기(exit)");
            System.out.println("3. 저장된 결과 보기(list)");
            System.out.println("4. 첫번째로 저장된 결과 삭제하기(remove)");
            String answer = sc.next();
            switch (answer) {
                case "1":
                    break;

                case "2":
                case "exit":
                case "종료하기":
                    System.out.println("종료되었습니다.");
                    return;

                case "3":
                case "list":
                    System.out.println("저장된 연산 결과 : " + calculator.getResults());
                    System.out.println("삭제하려면 'remove' 입력, 계속하려면 아무 키나 입력");
                    answer = sc.next();
                    if(answer.equals("remove")) {
                        calculator.removeResults();
                    }
                    break;

                case "4":
                case "remove":
                    calculator.removeResults();
                    break;


            }

        }

    }
}
