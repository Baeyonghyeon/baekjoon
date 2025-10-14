package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MeetingRoom[] meetingRooms = new MeetingRoom[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int token1 = Integer.parseInt(st.nextToken());
            int token2 = Integer.parseInt(st.nextToken());
            meetingRooms[i] = new MeetingRoom(token1, token2);
        }

        Arrays.sort(meetingRooms, ((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }
        }));

        int endTime = -1;
        for (int i = 0; i < n; i++) {
            if (meetingRooms[i].start >= endTime) {
                count++;
                endTime = meetingRooms[i].end;

//                System.out.println("start : " + meetingRooms[i].start);
//                System.out.println("end : " + meetingRooms[i].end);
            }
        }

        System.out.println(count);
    }

}

class MeetingRoom /*implements Comparator<MeetingRoom>*/ {
    int start;
    int end;

//    @Override
//    public int compare(MeetingRoom o1, MeetingRoom o2) {
//        if (o1.end == o2.end) {
//            return o1.start - o2.start;
//        } else {
//            return o1.end - o2.end;
//        }
//    }

    public MeetingRoom(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
