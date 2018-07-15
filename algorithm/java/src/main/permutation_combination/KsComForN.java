package permutation_combination;

import java.util.LinkedList;
import java.util.List;

/**
 * C(n,k)问题， 即n个不同数中取k个的组合
 * 本质上是深度遍历（dfs）
 */
public class KsComForN {
    public static List<List<Integer>> cnk(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curRes = new LinkedList<>();
        doCombination(res, curRes, n, k, 1);
        return res;
    }

    private static void doCombination(List<List<Integer>> res, List<Integer> curRes, int n, int k, int startVal) {
        if (n < 1 || k > n) throw new IllegalArgumentException(n + "," + k);

        if (curRes.size() == k) {
            res.add(new LinkedList<>(curRes));
        } else {
            for (int i = startVal; i <= n; i++) {
                curRes.add(i);
                doCombination(res, curRes, n, k, i + 1);
                curRes.remove(curRes.size() - 1); //还原
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(cnk(3, 2));
    }
}
