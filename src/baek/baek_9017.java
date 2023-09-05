package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_9017 {

    static Team[] teams = new Team[201];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] input = new int[n];
            init();

            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                input[j] = number;

                teams[number].countIncrease();

            }

            int score = 1;
            for (int j = 0; j < n; j++) {
                if (teams[input[j]].getCount() >= 6 && (teams[input[j]].getAddCount() < 4)) {
                    teams[input[j]].addScore(score);
                    teams[input[j]].addCountIncrease();
                } else if (teams[input[j]].getCount() >= 6 && teams[input[j]].getAddCount() == 4) {
                    teams[input[j]].setLastGrade(score);
                    teams[input[j]].addCountIncrease();
                }
                if (teams[input[j]].getCount() >= 6) {
                    score++;
                }
            }
//            System.out.println(teams[1].toString());
//            System.out.println(teams[2].toString());
//            System.out.println(teams[3].toString());

            int minScore = Integer.MAX_VALUE;
            int teamNumber = 0;
            int teamLastNumber = 0;
            for (int j = 1; j < 201; j++) {
                if (teams[j].getCount() == 6 && teams[j].getScore() < minScore) {
                    minScore = teams[j].getScore();
                    teamNumber = j;
                    teamLastNumber = teams[j].getLastGrade();
                }

                if (teams[j].getCount() == 6 && (teams[j].getScore() == minScore) && (teams[j].getLastGrade() < teamLastNumber)) {
                    minScore = teams[j].getScore();
                    teamNumber = j;
                    teamLastNumber = teams[j].getLastGrade();
                }
            }

            sb.append(teamNumber).append("\n");
        }

        System.out.print(sb);
    }

    private static void init() {
        for (int i = 0; i < 201; i++) {
            teams[i] = new Team();
        }
    }
}

class Team {
    private int score = 0;
    private int addCount = 0;
    private int count = 0;
    private int lastGrade = 0;

    public int getLastGrade() {
        return lastGrade;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void countIncrease() {
        this.count++;
    }

    public void addCountIncrease() {
        this.addCount++;
    }

    public int getAddCount() {
        return addCount;
    }

    public void setLastGrade(int lastGrade) {
        this.lastGrade = lastGrade;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Team{" +
                "score=" + score +
                ", addCount=" + addCount +
                ", count=" + count +
                ", lastGrade=" + lastGrade +
                '}';
    }
}
