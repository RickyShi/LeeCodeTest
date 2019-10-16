package repo_2019_2020.first400.array;

import java.util.HashMap;
import java.util.Map;

public class q299_BullsAndCows {

    public String getHintArray(String secret, String guess) {
        int[] counts = new int[10];  // number in string can be in range 0-9
        int len = guess.length(), bullCount = 0, cowCount = 0;

        for(int i = 0; i < len; i++){
            char currGuess = guess.charAt(i);
            char currSecret = secret.charAt(i);
            // if both char match
            if(currGuess == currSecret){
                bullCount++;
            } else{
                // if guess char count is 0 we haven't seen it yet in secret so set the count to -1

                if(counts[currGuess -'0'] > 0) cowCount++; // if the count is > 0 we have seen it before in secret string
                counts[currGuess - '0']--; // reduce the count as the char we are processing is guess char

                if(counts[currSecret -'0'] < 0) cowCount++; // if count is < 0 that means you have seen it in guess string before
                counts[currSecret - '0']++; // increase the count as the char we are processing is secret char
            }
        }
        return bullCount+"A"+cowCount+"B";
    }

    public String getHintHashMapQuick(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                if (map.getOrDefault(s,0)<0){
                    cows++;
                }
                map.put(s, map.getOrDefault(s, 0) + 1);

                if (map.getOrDefault(g,0)>0){
                    cows++;
                }
                map.put(g, map.getOrDefault(g, 0) - 1);

            }
        }
        return String.valueOf(bulls).concat("A").concat(String.valueOf(cows)).concat("B");
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> mapSecret = new HashMap<>();
        Map<Character, Integer> mapGuess = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                mapGuess.put(g, mapGuess.getOrDefault(g, 0) + 1);
                mapSecret.put(s, mapSecret.getOrDefault(s, 0) + 1);
            }
        }
        for (char c : mapSecret.keySet()) {
            cows += Math.min(mapSecret.getOrDefault(c, 0), mapGuess.getOrDefault(c, 0));
        }
        return String.valueOf(bulls).concat("A").concat(String.valueOf(cows)).concat("B");
    }
}
