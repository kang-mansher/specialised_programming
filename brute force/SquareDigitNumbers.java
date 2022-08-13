import java.util.Set;
import java.util.stream.IntStream;

public class SquareDigitNumbers {

    public static int getNumber(int num){

        Set<Character> set = Set.of('0', '1', '4', '9');
        int count = -1; //O is the Oth number so starting count from -1
        int number = 0;
        int itr = 0;
        while(count!=num) {
            String s = String.valueOf(itr);
            if(IntStream.range(0, s.length())
                    .boxed()
                    .allMatch(i -> set.contains(s.charAt(i)))) {
                number = itr;
                count++;
            }
            itr++;
        }

        return number;
    }


    public static void main(String[] args) {

        int[] inputs = {0,5,16,121,123,1000,4,16,64,256,914,788,343,857,225,89,8,511,255,63};
        for(int i : inputs) {
            System.out.println(getNumber(i));
        }

    }
}
