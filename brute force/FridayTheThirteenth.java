import java.util.*;
import java.util.stream.IntStream;

public class FridayTheThirteenth {

    public static int[] count(int firstDay, int isLeap) {

        int[] a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] b = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (isLeap >= 0 && isLeap <= 1 && firstDay >= 0 && firstDay <= 6) {

            if (isLeap == 1) {
                a[1] = 29;
            } else {
                a[1] = 28;
            }
            int d = firstDay;
            for (int i = 0; i < 12; i++) {
                for (int k = 1; k <= a[i]; k++) {
                    if (k == 13 && d == 4) {
                        b[i]++;
                    }
                    d++;
                    if (d > 6) {
                        d = 0;
                    }
                }

            }
            return b;
        }
        return null;
    }
    public static void main(String[] args) {

        int[] firstDayList = {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1};
        int[] isLeapList = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6};

        IntStream
                .range(0,15)
                .boxed()
                .forEach(i -> System.out.println(Arrays.toString(count(isLeapList[i], firstDayList[i]))));

    }
}