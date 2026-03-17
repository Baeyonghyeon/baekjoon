package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1043 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Union-Find 초기화
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람들을 0번 그룹(진실 그룹)과 합치기
        if (truthCount > 0) {
            union(0, Integer.parseInt(st.nextToken())); // 첫 번째 진실을 아는 사람과 0을 union
            for (int i = 1; i < truthCount; i++) {
                union(0, Integer.parseInt(st.nextToken()));
            }
        }

        // 파티 정보 저장
        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int guestCount = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < guestCount; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            // 같은 파티에 참석하는 사람들끼리 union
            for (int j = 0; j < guestCount - 1; j++) {
                union(party.get(j), party.get(j + 1));
            }
        }

        // 각 파티가 진실 그룹과 연결되어 있는지 확인
        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (find(person) == find(0)) { // 진실 그룹과 연결되어 있으면
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}