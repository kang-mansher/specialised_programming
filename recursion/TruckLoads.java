import java.util.Scanner;

public class TruckLoads {
    public TruckLoads() {
    }

    public int numTruck(int crate, int size) {
        int[] arr = new int[crate + 1];

        for(int i = 1; i < crate + 1; ++i) {
            if (i <= size) {
                arr[i] = 1;
            } else if (i % 2 == 0) {
                if (i / 2 <= size) {
                    arr[i] = 2;
                } else {
                    arr[i] = 2 * arr[i / 2];
                }
            } else if (i / 2 + 1 <= size) {
                arr[i] = 2;
            } else if (i / 2 + 1 > size && i / 2 < size) {
                arr[i] = 1 + arr[i / 2 + 1];
            } else {
                arr[i] = arr[i / 2] + arr[i / 2 + 1];
            }
        }

        return arr[crate];
    }

    public static void main(String[] args) {
        TruckLoads arr = new TruckLoads();
        Scanner sc = new Scanner(System.in);
        int crate = sc.nextInt();
        int size = sc.nextInt();
        System.out.println(arr.numTruck(crate, size));
    }
}