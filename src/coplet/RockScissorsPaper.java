package coplet;

import java.util.ArrayList;
import java.util.Arrays;

public class RockScissorsPaper {
    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(3);
        for (String[] loop : output){
            System.out.println(Arrays.toString(loop));
        }
    }
    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> outcomes = new ArrayList<>();

        return permutation(rounds, new String[]{}, outcomes);
    }

    public static ArrayList<String[]> permutation(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes) {
        if(roundsToGo == 0) {
            outcomes.add(playedSoFar);
            return outcomes;
        }

        String[] rps = new String[]{"rock", "paper", "scissors"};

        for(int i = 0; i < rps.length; i++) {
            String currentPlay = rps[i];

            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length + 1);
            concatArray[concatArray.length - 1] = currentPlay;

            outcomes = permutation(roundsToGo - 1, concatArray, outcomes);
        }

        return outcomes;
    }
}
