package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1717 {
    static int N, M;
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        initialize();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (select == 0) {
                union(a, b);
            } else if (select == 1) {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

    }

    //parent 배열에 i 원소에 대한 부모 노드 번호를 저장, 루트 노드인 경우 자기 자신의 번호를 저장
    public static void initialize() {
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    //하나의 루트 노드를 다른 하나의 루트 노드의 자식 노드로 넣어 두 트리를 합친다.
    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }

    //주어진 원소의 루트 노드 번호를 반환한다.
    public static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

}
