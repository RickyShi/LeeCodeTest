package repo_2019_2020.first400.array;

public class q134_GasStation {

    /**
     * 我们首先要知道能走完整个环的前提是gas的总量要大于cost的总量，这样才会有起点的存在。
     * 假设开始设置起点start = 0, 并从这里出发，如果当前的gas值大于cost值，就可以继续前进，
     * 此时到下一个站点，剩余的gas加上当前的gas再减去cost，看是否大于0，若大于0，则继续前进。
     * 当到达某一站点时，若这个值小于0了，则说明从起点到这个点中间的任何一个点都不能作为起点，则把起点设为下一个点，继续遍历。
     * 当遍历完整个环时，当前保存的起点即为所求
     * 最后结束后我们还是看totoa是否大于等于0，如果其小于0的话，说明没有任何一个起点能走完全程，因为总油量都不够
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start=i+1;
            }
        }

        return (total < 0) ? -1 : start;

    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        for (int g = 0; g < n; g++) {
            int gIndex = (g + 1) % n;
            int cIndex;
            int fuel = gas[g];
            for (int c = 0; c < n; c++) {
                cIndex = (c + g) % n;
                if (fuel - cost[cIndex] < 0) {
                    break;
                }
                if (c == n - 1) {
                    return g;
                } else {
                    fuel = fuel - cost[cIndex] + gas[gIndex];
                    gIndex = (gIndex + 1) % n;
                }
            }
        }
        return -1;
    }
}
