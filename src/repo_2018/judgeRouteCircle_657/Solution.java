package repo_2018.judgeRouteCircle_657;

class Solution {
    public boolean judgeCircle(String moves) {
        int i =0;
        int j = 0;
        for (char c: moves.toCharArray()){
            if (c=='U'){
                j+=1;
            }else if(c=='D'){
                j-=1;
            }else if(c=='L'){
                i-=1;
            }else if(c=='R'){
                i+=1;
            }
        }
        if (i==0&&j==0){
            return true;
        }else{
            return false;
        }
    }
}
