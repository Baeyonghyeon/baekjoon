package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek_2143 {
    static long T;
    static int n, m;
    static long A[];
    static long B[];
    static List<Long> subA = new ArrayList<>();
    static List<Long> subB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new long[n];
        for(int i=0; i<n; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        B = new long[m];
        for(int i=0; i<m; i++){
            B[i] = Long.parseLong(st.nextToken());
        }
        //-----------------------------input---------------------------

        //sub A 구하기
        for(int i=0; i<n; i++){
            long sum = A[i];
            subA.add(sum);
            for(int j= i+1; j<n; j++){
                sum += A[j];
                subA.add(sum);
            }
        }
        //sub B 구하기
        for(int i=0; i<m; i++){
            long sum = B[i];
            subB.add(sum);
            for(int j= i+1; j<m; j++){
                sum += B[j];
                subB.add(sum);
            }
        }

        //subA, subB 정렬
        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());

        long result = 0;
        int ptA= 0;
        int ptB= 0;
        while (ptA < subA.size() && ptB < subB.size()){
            long currentA = subA.get(ptA);
            long target = T - currentA;
            //currentB == target -> subA, subB 같은 수 체크 -> 답구하기. ptA+ ptB+
            if(subB.get(ptB) == target){
                long countA = 0;
                long countB = 0;
                while (ptA < subA.size() && subA.get(ptA) == currentA){
                    countA++;
                    ptA++;
                }
                while (ptB < subB.size() && subB.get(ptB) == target){
                    countB++;
                    ptB++;
                }
                result += countA * countB;
            }
            //currentB > target -> ptB++
            else if(subB.get(ptB) > target){
                ptB++;
            }
            //currentB < target -> ptA++
            else{
                ptA++;
            }
        }

        System.out.println(result);
    }
}
