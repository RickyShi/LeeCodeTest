package repo_2018.fizzBizz_412;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> rtn = new ArrayList<>();
        for (int i = 1;i<=n;i++){
            if (i%15==0){
                rtn.add("FizzBuzz");
            }else if(i%3==0){
                rtn.add("Fizz");
            }else if(i%5==0){
                rtn.add("Buzz");
            }else{
                rtn.add(String.valueOf(i));
            }
        }
        return rtn;
    }
}
