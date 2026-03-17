package baek;

import java.util.*;

public class Coupon {
    public static void main(String[] args) {
        int currentPrice = 101000;
        int[][] coupons = {
                {50000, 4000, 0},     // 일반
                {100000, 10000, 0},   // 일반
                {150000, 10000, 0},   // 일반
                {101000, 3000, 1},    // 중복
                {30000, 1000, 1},     // 중복
                {100000, 10000000, 1},     // 중복
        };

        // 방법 1: 정렬을 통한 최적화
        System.out.println("=== 방법 1: 정렬 최적화 ===");
        optimizedWithSorting(currentPrice, coupons);

        // 방법 2: 미리 계산을 통한 최적화
        System.out.println("\n=== 방법 2: 미리계산 최적화 ===");
        optimizedWithPrecomputation(currentPrice, coupons);
    }

    // 방법 1: 정렬을 통한 최적화 O(n log n + m log m)
    public static void optimizedWithSorting(int currentPrice, int[][] coupons) {
        List<int[]> normal = new ArrayList<>();
        List<int[]> overlap = new ArrayList<>();

        for (int[] c : coupons) {
            if (c[2] == 0) normal.add(c);
            else overlap.add(c);
        }

        // 할인금액 기준 내림차순 정렬 (같으면 최소조건 오름차순)
        normal.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);
        overlap.sort((a, b) -> a[1] != b[1] ? b[1] - a[1] : a[0] - b[0]);

        int minPayment = currentPrice;

        // 일반 쿠폰만 사용
        for (int[] n : normal) {
            if (currentPrice >= n[0]) {
                int payment = Math.max(0, currentPrice - n[1]);
                minPayment = Math.min(minPayment, payment);
                break; // 정렬되어 있으므로 첫 번째가 최적
            }
        }

        // 일반 + 중복 쿠폰 조합
        for (int[] n : normal) {
            if (currentPrice >= n[0]) {
                for (int[] o : overlap) {
                    int base = Math.max(currentPrice, Math.max(n[0], o[0]));
                    int payment = Math.max(0, base - (n[1] + o[1]));
                    minPayment = Math.min(minPayment, payment);
                }
                break; // 일반쿠폰은 가장 할인 큰 것만 확인
            }
        }

        System.out.println("최소 결제금액: " + minPayment);
    }

    // 방법 2: 미리 계산을 통한 최적화 O(n + m)
    public static void optimizedWithPrecomputation(int currentPrice, int[][] coupons) {
        int bestNormalDiscount = 0;
        int bestOverlapDiscount = 0;
        int maxCondition = 0;

        // 한 번의 순회로 최적값들 찾기
        for (int[] c : coupons) {
            if (currentPrice >= c[0]) { // 사용 가능한 쿠폰만
                if (c[2] == 0) { // 일반 쿠폰
                    bestNormalDiscount = Math.max(bestNormalDiscount, c[1]);
                } else { // 중복 쿠폰
                    bestOverlapDiscount = Math.max(bestOverlapDiscount, c[1]);
                    maxCondition = Math.max(maxCondition, c[0]);
                }
            }
        }

        int minPayment = currentPrice;

        // 일반 쿠폰만 사용
        if (bestNormalDiscount > 0) {
            minPayment = Math.min(minPayment, currentPrice - bestNormalDiscount);
        }

        // 일반 + 중복 쿠폰 조합
        if (bestNormalDiscount > 0 && bestOverlapDiscount > 0) {
            int base = Math.max(currentPrice, maxCondition);
            int payment = Math.max(0, base - (bestNormalDiscount + bestOverlapDiscount));
            minPayment = Math.min(minPayment, payment);
        }

        System.out.println("최소 결제금액: " + minPayment);
    }
}
