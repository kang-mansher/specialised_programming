public class WordleColors {

    public static void main(String[] args) {

        String[] list1 = {"BLOCK", "BLOCK", "BLURB", "ABBOT", "CANAL",
                "GREEN", "RATES","GMMPG", "OOIOI", "XXXRR",
                "CCDCD", "OOOOG", "OOOQO", "NNHNN", "CCTTC",
                "MRRRR", "RRNNN", "KKMMK", "TTTMM", "WWHWH"
        };
        String[] list2 = {"BRICK", "BLOBS", "BOBBY", "BOBBY", "AAAAA",
                "BLACK", "STARE", "KHWHH", "IIOOI", "RXXXX",
                "CCCDC", "GOGGO", "QQOOO", "HNHHH", "TCTTT",
                "MRMMR", "RNNNR", "MMKMK", "TTMTM", "WHWHH"
        };

        for (int i = 0; i < list1.length; i++) {
            System.out.println(color(list1[i], list2[i]));
        }
    }

    public static String color(String hidden, String guess) {

        int[] hiddenCharFreq = new int[26];
        char[] result = {'-', '-', '-', '-', '-'};

        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == hidden.charAt(i)) {
                result[i] = 'g';
            } else {
                hiddenCharFreq[hidden.charAt(i) - 'A']++;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (result[i] == '-' && hiddenCharFreq[guess.charAt(i) - 'A'] > 0) {
                result[i] = 'y';
                hiddenCharFreq[guess.charAt(i) - 'A']--;
            }
        }

        StringBuilder str = new StringBuilder();
        for (char c : result) {
            str.append(c);
        }
        return str.toString();
    }
}
