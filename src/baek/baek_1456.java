package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1456 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int limit = (int) Math.sqrt(b);  // √b 까지만 소수 필요
        boolean[] isPrime = new boolean[limit + 1];

        // 초기화: 모든 수를 소수라고 가정
        for (int i = 2; i <= limit; i++) isPrime[i] = true;

        // 에라토스테네스의 체
        for (int i = 2; i * i <= limit; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= limit; j += i) {
                isPrime[j] = false;
            }
        }

        int result = 0;
        // 각 소수의 거듭제곱을 범위 안에서 카운트
        for (int i = 2; i <= limit; i++) {
            if (!isPrime[i]) continue;

            long power = (long) i * i;  // 최소 제곱부터 시작
            while (power <= b) {
                if (power >= a) result++;

                // 다음 곱셈에서 b를 초과할 경우 반복 종료
                if (power > b / i) break;
                power *= i;
            }
        }

        System.out.println(result);
    }
}
