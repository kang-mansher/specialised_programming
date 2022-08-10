import java.util.*;

public class FindBob {

    public static void main(String[] args) {

        int[] n = {6,6,6,6,6,6,41,48};
        int[][] arr = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, 2, -1, -1},
                {1, -1, -1, 2, -1, -1},
                {-1, -1, -1, -1, 3, -1},
                {-1, -1, -1, -1, 0, -1},
                {5, -1, -1, -1, -1, 5},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, 12,
                        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, 42, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        for(int i=0;i<n.length;i++) {
            System.out.println(Arrays.toString(find(n[i], arr[i])));
        }

    }

    public static int[] find(int N, int[] houses) {

        List<Set<Integer>> list = new ArrayList<>();
        boolean noHouseVisited = true;

        for (int i = 0; i < N; i++) {
            if (houses[i] != -1) {
                noHouseVisited = false;
                Set<Integer> set = new HashSet<>();
                if(i-houses[i]>=0)
                    set.add(i - houses[i]);
                if(i+houses[i]<N)
                    set.add(i + houses[i]);
                list.add(set);
            }
        }

        if (noHouseVisited) {
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                result[i] = i;
            }
            return result;
        }

        Set<Integer> finalSet = list.get(0);
        list.forEach(finalSet::retainAll);

        List<Integer> resultList = new ArrayList<>(finalSet);
        Collections.sort(resultList);
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;

    }

}
