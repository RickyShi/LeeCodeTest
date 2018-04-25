package repo_2018.bestMeetingPoint_296;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 * <p>
 * Hint:
 * <p>
 * Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 * <p>
 * <p>
 * 这道题让我们求最佳的开会地点，该地点需要到每个为1的点的曼哈顿距离之和最小，题目中给了我们提示，让我们先从一维的情况来分析，那么我们先看一维时有两个点A和B的情况,
 * <p>
 * ______A_____P_______B_______
 * <p>
 * 那么我们可以发现，只要开会为位置P在[A, B]区间内，不管在哪，距离之和都是A和B之间的距离，如果P不在[A, B]之间，那么距离之和就会大于A和B之间的距离，那么我们现在再加两个点C和D：
 * <p>
 * ______C_____A_____P_______B______D______
 * <p>
 * Approach1
 * 我们通过分析可以得出，P点的最佳位置就是在[A, B]区间内，这样和四个点的距离之和为AB距离加上CD距离，在其他任意一点的距离都会大于这个距离，那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，然后用最后一个坐标减去第一个坐标，即CD距离，倒数第二个坐标减去第二个坐标，即AB距离，以此类推，直到最中间停止，那么一维的情况分析出来了，二维的情况就是两个一维相加即可
 */
/**
 * Approach1
 * 我们通过分析可以得出，P点的最佳位置就是在[A, B]区间内，这样和四个点的距离之和为AB距离加上CD距离，在其他任意一点的距离都会大于这个距离，那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，然后用最后一个坐标减去第一个坐标，即CD距离，倒数第二个坐标减去第二个坐标，即AB距离，以此类推，直到最中间停止，那么一维的情况分析出来了，二维的情况就是两个一维相加即可
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Approach2
 * 为了尽量保证右边的点向左走，左边的点向右走，那我们就应该去这些点中间的点作为交点。由于是曼哈顿距离，我们可以分开计算横坐标和纵坐标，结果是一样的。所以我们算出各个横坐标到中点横坐标的距离，加上各个纵坐标到中点纵坐标的距离，就是结果了。
 */
public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> ipos = new ArrayList<Integer>();
        List<Integer> jpos = new ArrayList<Integer>();
        // 统计出有哪些横纵坐标
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ipos.add(i);
                    jpos.add(j);
                }
            }
        }
        int sum = 0;
        // 计算纵坐标到纵坐标中点的距离，这里不需要排序，因为之前统计时是按照i的顺序
        for (Integer pos : ipos) {
            sum += Math.abs(pos - ipos.get(ipos.size() / 2));
        }
        // 计算横坐标到横坐标中点的距离，这里需要排序，因为统计不是按照j的顺序
        Collections.sort(jpos);
        for (Integer pos : jpos) {
            sum += Math.abs(pos - jpos.get(jpos.size() / 2));
        }
        return sum;
    }
}
