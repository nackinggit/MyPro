package permutation_combination;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * C(n,k)问题， 即n个不同数中取k个的组合
 * 本质上是深度遍历（dfs）
 */
public class KsComForN {
    //递归方式
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

    //非递归
    public static List<List<Integer>> cnkWithoutRe(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> curRes = new LinkedList<>();
        doCombination2(res, curRes, n, k);
        return res;
    }

    //用栈模拟递归
    private static void doCombination2(List<List<Integer>> res, List<Integer> curRes, int n, int k) {
        Stack<Integer> queue = new Stack<>();
        boolean needPop = false;
        queue.add(1);
        while (!queue.isEmpty()) {
            //有k个元素，满足条件
            if (queue.size() == k) {
                curRes = new LinkedList<>(queue);
                res.add(curRes);
                needPop = true;
            }

            //当前栈顶元素
            int j = queue.peek();

            if (j == n) {
                needPop = true;
                queue.pop();
                continue;
            }
            if (needPop) {
                queue.pop();
                needPop = false;
            }
            if (j < n) {
                queue.add(j + 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(cnk(3, 2));
        System.out.println(cnkWithoutRe(3, 2));
    }
}
