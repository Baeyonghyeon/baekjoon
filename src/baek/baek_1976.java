package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1976 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // Union-Find 초기화: 각 노드가 자기 자신을 부모로 설정
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 인접행렬 입력 및 Union 연산
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력 (1-indexed를 0-indexed로 변환)
        st = new StringTokenizer(br.readLine());
        int[] goal = new int[m];
        for (int i = 0; i < m; i++) {
            goal[i] = Integer.parseInt(st.nextToken()) - 1; // 1-indexed → 0-indexed
        }

        // 모든 도시가 연결되어 있는지 확인
        boolean canTravel = true;
        for (int i = 0; i < m - 1; i++) {
            if (find(goal[i]) != find(goal[i + 1])) {
                canTravel = false;
                break;
            }
        }

        System.out.println(canTravel ? "YES" : "NO");
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }
}
