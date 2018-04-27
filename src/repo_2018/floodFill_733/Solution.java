package repo_2018.floodFill_733;

public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        //Check whether the color is the same, otherwise cause stack overflow
        if (oldColor != newColor)  dfs(image,sr,sc,newColor,oldColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int newColor, int oldColor){
        if (image[r][c]==oldColor){
            image[r][c]=newColor;

            if(r>0) dfs(image ,r-1,c,newColor,oldColor);
            if(r<image.length-1) dfs(image ,r+1,c,newColor,oldColor);
            if(c>0) dfs(image ,r,c-1,newColor,oldColor);
            if(c<image[0].length-1) dfs(image ,r,c+1,newColor,oldColor);
        }
    }
}
