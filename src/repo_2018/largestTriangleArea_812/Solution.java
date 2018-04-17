package repo_2018.largestTriangleArea_812;

/**
 * If we did not know the shoelace formula, we could derive it for triangles with the following approach: starting with points (px, py), (qx, qy), (rx, ry), the area of this triangle is the same under a translation by (-rx, -ry), so that the points become (px-rx, py-ry), (qx-rx, qy-ry), (0, 0).
 * shoelace formula
 * use j = i+1 and k = j+1 to save some O() Still O(n^3)
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}
