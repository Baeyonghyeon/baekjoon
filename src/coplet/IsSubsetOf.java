package coplet;

public class IsSubsetOf {
    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output); // --> true

        sample = new int[]{6, 7};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false
    }

    static boolean[] visit = new boolean[50001];

    public static boolean isSubsetOf(int[] base, int[] sample) {
        if (base.length < sample.length) {
            return false;
        }

        for (int loop : base) {
            visit[loop] = true;
        }

        for (int loop : sample) {
            if(!visit[loop]){
                return false;
            }
        }

        return true;
    }
}
