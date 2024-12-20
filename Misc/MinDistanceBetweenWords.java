package Misc;

public class MinDistanceBetweenWords {
    
    public static void main(String[] args) {
        String sentence = "the quick the brown quick brown the frog";
        String word1 = "quick";
        String word2 = "frog";
        System.out.println(minDistanceBetweenWords(sentence, word1, word2));
    }

    private static int minDistanceBetweenWords(String s, String w1, String w2) {
        String[] sList = s.split(" ");
        int ans = Integer.MAX_VALUE;
        int lastPos = -1;
        for(int i = 0; i < sList.length; i++) {
            if(w1.equals(sList[i]) || w2.equals(sList[i])) {
                if(lastPos != -1) {
                    if(sList[lastPos] == sList[i]) {
                        lastPos = i;
                    } else {
                        ans = Math.min(ans, i - lastPos - 1);
                    }
                } else {
                    lastPos = i;
                }
            }
        }
        return ans;
    }

}
