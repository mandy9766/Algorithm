package d0205;

public class 순열_조합_부분집합_최태선 {
    
    static char[] src = { 'a', 'b', 'c', 'd' };

    public static void main(String[] args) {
        // 1. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
        makePermutation(3, new char[3], new boolean[src.length]);

        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("조합");
        // makeCombination(3,new char[3], 0);

        // 3. src로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("부분집합");
        powerSetDupPer(3, new boolean[3]);

    }

    static void makePermutation(int nthChoice, char[] choosed, boolean[] visited) {

    }

    static void makeCombination(int nthChoice, char[] choosed, int startIdx) {

    }

    static void powerSetDupPer(int toCheck, boolean[] checked) {

    }

    static void print(boolean[] temp) {

    }

}
