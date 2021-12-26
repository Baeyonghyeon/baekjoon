package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class DFS{
    private int nV;  //정점의 개수
    public ArrayList<ArrayList<Integer>> graph;
    private boolean[] visit;

    //그래프 초기화
    public DFS(int nV){
        this.nV = nV;
        this.graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<this.nV+1; i++){
            this.graph.add(new ArrayList<Integer>());
        }
        this.visit = new boolean[this.nV];
    }

    //그래프 return
    public ArrayList<ArrayList<Integer>> getGraph(){
        return this.graph;
    }

    //그래프 특정 노드 return
    public ArrayList<Integer> getNode(int i){
        return this.graph.get(i);
    }

    //그래프 추가 (양방향)
    public void put(int x, int y){
        this.graph.get(x).add(y);
        this.graph.get(y).add(x);
    }

    //그래프 추가 (단방향)
    public void putSingle(int x, int y){
        this.graph.get(x).add(y);
    }

    //그래프 출력(인접리스트)
    public void print_NodeTONode(){
        for(int i=1; i<this.graph.size(); i++){
            System.out.print("정점 " + i + "의 인접리스트");
            for(int j=0; j<this.graph.get(i).size(); j++){
                System.out.print(" -> "+ this.graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    //정점 방문 여부 확인 배열 초기화
    public void clearVisit(){
        for(int i=0; i<this.visit.length; i++){
            this.visit[i] = false;
        }
        Arrays.fill(visit,false);
    }

    //그래프 탐색(재귀호출)
    public void dfs(int vIdx){
        //dfs()에 파라미터로 넘어온 vIdx는 방문한 것이므로
        //방문배열의 해당 index값을 true로 바꿔주고 값을 출력함.
        this.visit[vIdx] = true;
        System.out.println();
        //인접리스트로 구현된 그래프에서
        //해당 index에 맞는 리스트를 가져와서 반복
        for (int i : this.graph.get(vIdx)) {
            //해당 정점(i)이 정점 방문 여부 확인 배열에서
            //방문하지 않은 상태(false)인 경우
            if(this.visit[i] == false){
                dfs(i);
            }
        }
    }

}
public class baek_1260 {
    public static int N, M, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token[] = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);     //정점의 개수
        M = Integer.parseInt(token[1]);     //간선의 개수
        V = Integer.parseInt(token[2]);     //탐색 시작 번호
        DFS dfs = new DFS(N);

        for(int i=0; i<M; i++){
            String token2[] = br.readLine().split(" ");
            //int x = token2.;
            //int y =
        }
    }
}
