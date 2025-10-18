package example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private List<Long> results = new ArrayList<>();

    /* Getter 메서드 구현 */
    public List getResults() {
        return results;
    }

    /* Setter 메서드 구현 */
    public void setResults(List results) {
        this.results = results;
    }

    public void removeResults() {
        this.results.remove(0); // 저장된 첫번째 값 삭제 0번인덱스
    }


    public long calculate(long a, long b, char operator) {
        /* 위 요구사항에 맞게 구현 */
        long result = 0;
        /* return 연산 결과 */
        if (operator == '+') {
          result = a + b;
        } else if (operator == '-') {
            result = a - b;
        } else if (operator == '*') {
            result = a * b;
        } else if (operator == '/') {
            if(b == 0) {
                System.out.println("0으로 나눌 수 없습니다");
                return 0;
            }
            result = a / b;
            }
            results.add(result);
            return result;

    }
}
