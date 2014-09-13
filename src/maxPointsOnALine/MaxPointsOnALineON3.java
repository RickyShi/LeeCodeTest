package maxPointsOnALine;
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/**
 * @author Ricky
 * The worst way
 */
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Point() {
		this.x = 0;
		this.y = 0;
	}	
}
public class MaxPointsOnALineON3 {
	public int maxPoints(Point[] points) {
        int maxCount = 0;
        if (points == null) {
            return 0;
        }
        for (int i=0; i<points.length; i++){
            int x1 = points[i].x;
            int y1 = points[i].y;
            for (int j=i+1;j<points.length; j++){
                int x2 = points[j].x;
                int y2 = points[j].y;
                if ((x1 == x2) && (y1 == y2)){
                    continue;
                }
                int count = 0;
                for (int k = 0; k<points.length; k++){
                    int  x3 = points[k].x;
                    int y3 = points[k].y;
                    if (x2 * y3 + y1 * x3 + y2 * x1 == x1 * y3 + y2 * x3 + y1 * x2){
					    count++;
					}
    				if (count>maxCount){
    				  maxCount = count;  
    				}
                }
            }
        }
        if (maxCount ==0){
            return points.length;
        }
        return maxCount;
    }
}
