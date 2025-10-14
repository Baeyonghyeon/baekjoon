package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_1414 {

    private static List<int[]> graph = new ArrayList<>();
    private static int[] unionFind;
    private static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int edgeCount = 0;
        unionFind = new int[n];

        for (int i = 0; i < n; i++) {
            unionFind[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] inputs = st.nextToken().toCharArray();

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (inputs[j] >= 97 && inputs[j] <= 122) {
                        graph.add(new int[]{i, j, inputs[j] - 96});
                        total += inputs[j] - 96;
                    } else if (inputs[j] >= 65 && inputs[j] <= 90) {
                        graph.add(new int[]{i, j, inputs[j] - 38});
                        total += inputs[j] - 38;
                    }
                } else {
                    if (inputs[j] >= 97 && inputs[j] <= 122) {
                        total += inputs[j] - 96;
                    } else if (inputs[j] >= 65 && inputs[j] <= 90) {
                        total += inputs[j] - 38;
                    }
                }
            }
        }

        graph.sort(Comparator.comparingInt(o -> o[2]));

        for (int[] ints : graph) {
            int a = ints[0];
            int b = ints[1];
            int cost = ints[2];

            if (find(a) != find(b)) {
                union(a, b, cost);
                edgeCount++;
            }

            if (edgeCount == n - 1) {
                break;
            }
        }

        System.out.println(edgeCount == n - 1 ? total : -1);

    }

    private static void union(int a, int b, int cost) {
        int fa = find(a);
        int fb = find(b);

        if (fa != fb) {
            unionFind[fb] = fa;
            total -= cost;
        }

    }

    private static int find(int a) {
        if (a == unionFind[a]) return a;
        else return unionFind[a] = find(unionFind[a]);
    }
}
