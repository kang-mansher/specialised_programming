public class GuessForMoney {
    public static void main(String[] args) {
        long[] numbers = new long[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (long number : numbers) {
            System.out.println(number + ": " + balance(number)+" ");
        }
    }

    public static double balance(long N)
    {
        double p=0;
        for (int j=0; j<N;j++) {
            long mid = (N-1)/2;
            for (int k = 1; k <= N; k++) {
                if (mid == j) {
                    p = p + k;
                    break;
                } else if (mid < j) {
                    double l=Math.pow(2,k+1);
                    int y= (int) Math.ceil(( N / l));
                    mid = mid + y;

                } else if (mid > j) {
                    double l=Math.pow(2,k+1);
                    int y= (int) Math.ceil(( N / l));
                    mid = mid - y;
                }
            }
        }
        double q=p/N;
        String result = String.format("%.16f",q);
        return Double.parseDouble(result);
    }
}
