package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek_15829 {

    static int M = 1234567891;
    static long[] exponentiationStorage;

    /**
     * fast Exponentiation Algorithm 사용해서 31^i 값을 L 길이만큼 구해놓자
     * 구해둔 값을 각 항마다 곱해서 더하면 될듯.
     * 배열에 값을 할당해서 문제를 풀면 제한 시간에 걸린다 100 점 문제 해결 방법은 아래와 같음.
     * public static void main(String[] args) throws IOException {
     *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     *         int L = Integer.parseInt(br.readLine());
     *         int[] strValue = new int[L];
     *         long result = 0;
     *         long res = 1;
     *         String str = br.readLine();
     *
     *         for (int i = 0; i < str.length(); i++) {
     *             strValue[i] = str.charAt(i) - 96;
     *         }
     *
     *         for (int i = 0; i < L; i++) {
     *             result += strValue[i] * res % M;
     *             res = (res * 31) % M;
     *         }
     *
     *         System.out.println(result % M);
     *
     *         br.close();
     *     }
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] strValue = new int[L];
        exponentiationStorage = new long[49];
        exponentiationStorage[0] = 1;
        exponentiationStorage[1] = 31;
        long result = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            strValue[i] = str.charAt(i) - 96;
        }

        for (int i = 0; i < L; i++) {
            result += strValue[i] * shiftExponentiation(i) % M;
        }

        System.out.println(result % M);

        br.close();
    }

    public static long shiftExponentiation(int b) {
        if (b == 0 || b == 1) {
            return exponentiationStorage[b];
        }

        return exponentiationStorage[b] = exponentiationStorage[b-1] * 31 % M;
    }
}
