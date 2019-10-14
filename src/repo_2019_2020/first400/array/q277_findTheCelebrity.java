package repo_2019_2020.first400.array;

/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * You are given a helper function bool knows(a, b) which tells you whether A knows B.
 * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * <p>
 * There will be exactly one celebrity if he/she is in the party.
 * Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class q277_findTheCelebrity {
    public int findCelebrity(int n) {
        int celeb = 0;
        // We find a 'i' which is known by everyone, but doesn't know anyone.
        // 如果 名人 不认识 i， 那么 i 不被人认识， 所以 i 也不是 名人。所以那个i就不用在被检查了
        for (int i = 1; i < n; i++) {
            if (knows(celeb, i))
                celeb = i;
        }
        /*
         * To make sure the value we find out is actually the celebrity, we
         * check if celeb knows none and everyone knows him.
         */
        for (int i = 0; i < n; i++) {
            if (i != celeb && (knows(celeb, i) || !knows(i, celeb)))
                return -1;
        }

        return celeb;
    }

    /**
     * 我们还可以进一步减少 API 的调用量，找候选者的方法跟上面相同，
     * 但是在验证的时候，分为两段，先验证候选者前面的所有人，若候选者认识任何人，或者任何人不认识候选者，直接返回 -1。
     * 再验证候选者后面的人，这时候只需要验证是否有人不认识候选者就可以了，
     * 因为我们在最开始找候选者的时候就已经保证了候选者不会认识后面的任何人，参见代码如下：
     */
    public int findCelebrityBetterSolution(int n) {
        int celeb = 0;
        // We find a 'i' which is known by everyone, but doesn't know anyone.
        // 如果 名人 不认识 i， 那么 i 不被人认识， 所以 i 也不是 名人。所以那个i就不用在被检查了
        for (int i = 1; i < n; i++) {
            if (knows(celeb, i))
                celeb = i;
        }
        /*
         * To make sure the value we find out is actually the celebrity, we
         * check if celeb knows none and everyone knows him.
         */
        for (int i = 0; i < celeb; i++) {
            if ((knows(celeb, i) || !knows(i, celeb)))
                return -1;
        }

        for (int i = celeb + 1; i< n; i++){
            if(!knows(i, celeb)){
                return -1;
            }
        }

        return celeb;
    }
    /**
     * You are given a helper function bool knows(a, b) which tells you whether A knows B.
     * Template here
     */
    private boolean knows(int a, int b){
        return true;
    }
}
