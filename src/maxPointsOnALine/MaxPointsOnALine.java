package maxPointsOnALine;

import java.util.HashMap;
import java.util.Set;

class RickyPoint {
	int x;
	int y;
	public RickyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public RickyPoint() {
		this.x = 0;
		this.y = 0;
	}	
}
/**
 * Use Hashmap O(n2)
 * @author Ricky
 *
 */
public class MaxPointsOnALine {
	public int maxPoints(RickyPoint[] points) {
	       if (points == null || points.length == 0){
	           return 0;
	       }
	       int max = 0;
	       int samNum = 0;
	       HashMap <Double, Integer> hashMap = new HashMap<Double, Integer>();
	       for (int i = 0; i<points.length; i++){
	           samNum = 0;
	           hashMap.clear();
	           for (int j = 0; j<points.length; j++){
	               if (points[i].x == points[j].x && points[i].y == points[j].y){
	                   samNum++;
	               // gradient is infinite
	               } else if (points[i].x == points[j].x){
	                   	if (hashMap.containsKey(Double.MAX_VALUE)) {
							hashMap.put(Double.MAX_VALUE,
									hashMap.get(Double.MAX_VALUE) + 1);
						} else {
							hashMap.put(Double.MAX_VALUE, 1);
						}
	               }
	                   else {
	                   double f = ((double)(points[i].y - points[j].y)) / ((double)(points[i].x - points[j].x));
	                   if (hashMap.containsKey(f)) {
	                       hashMap.put(f, hashMap.get(f)+1);
	                   } else {
	                       hashMap.put(f, 1);
	                   }
	               }
	           }
	           Set <Double> keySet = hashMap.keySet();
	           for (Double key : keySet){
	               if (samNum + hashMap.get(key) > max){
	                   max = samNum + hashMap.get(key);
	               }
	           }
	       }
	       if (max == 0){
	       return points.length;
	       }
	       return max;
	    }
}
