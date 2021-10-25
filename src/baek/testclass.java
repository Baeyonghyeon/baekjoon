package baek;

import java.io.IOException;
import java.util.ArrayList;

public class testclass {

    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        listadd();
        System.out.println(list.get(1000));
    }

    static void listadd(){
        int i=1;
        while (true){
            for(int j=0; j<i; j++){
                list.add(i);
                System.out.println(list.size());
            }
            i++;
            if (list.size() > 1001) break;
        }
    }
}
