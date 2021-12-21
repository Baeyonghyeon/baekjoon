package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baek_1485 {
    public static int T;
    public static StringBuilder sb = new StringBuilder();
    public static location lo[] = new location[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        double value[] = new double[6];

        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                lo[j] = new location();
                String token[] = br.readLine().split(" ");
                lo[j].setXY(Long.parseLong((token[0])), Long.parseLong(token[1]));
            }

            int cnt = 0;
            for (int k = 0; k < 4; k++) {
                for (int l = k + 1; l < 4; l++) {
                    double a = Math.pow(lo[k].getX() - lo[l].getX(), 2);
                    double b = Math.pow(lo[k].getY() - lo[l].getY(), 2);
                    value[cnt] = Math.sqrt(a + b);
                    cnt++;
                }
            }
            Arrays.sort(value);
            if (value[0] == value[1] && value[0] == value[2] && value[0] == value[3] && value[4] == value[5]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class location {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
}