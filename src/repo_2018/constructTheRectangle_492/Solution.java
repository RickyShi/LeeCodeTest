package repo_2018.constructTheRectangle_492;

public class Solution {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }

    public static  void main(String[] args){
        System.out.println(Math.ceil(Math.sqrt(17)));
        System.out.println(Math.floor(Math.sqrt(17)));
    }
}
