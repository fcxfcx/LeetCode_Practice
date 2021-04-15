package DetailPractice;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 990. 等式方程的可满足性
 * 标签：并查集
 */
public class Problem_990 {
    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        // 首先将并查集中每个字符的父节点指向它们自己，这也同时可以来判断根节点
        for (int i = 0; i < 26; i++) {
            parents[i] = i;
        }
        // 首先做并的操作，将所有相等的字符放置于同一父节点下
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                union(parents, index1, index2);
            }
        }
        // 之后对于不等式做判断，如果两个不等的字符在同一根节点下则等式不成立
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int index1 = equation.charAt(0) - 'a';
                int index2 = equation.charAt(3) - 'a';
                if (find(parents, index1) == find(parents, index2)) {
                    return false;
                }
            }
        }
        // 所有判断都成立后返回最终结果
        return true;
    }

    /**
     * 寻找某一结点的根节点
     *
     * @param parents 并查集
     * @param index   待寻找的结点
     * @return 根节点的index
     */
    public int find(int[] parents, int index) {
        while (parents[index] != index) {
            // 在寻找根节点的过程中，将查找过程中的每一个结点的父节点都更新为其父节点的父节点
            // 这个过程就像是向上溯源一样，由于提前判断了当前结点不是最终根节点，因此其父节点一定存在其值
            // 这个操作可以减小之后寻找根节点的时间
            parents[index] = parents[parents[index]];
            // 将index更新为父节点
            index = parents[index];
        }
        return index;
    }

    /**
     * 将两个结点并在同一根节点下
     *
     * @param parents 并查集
     * @param index1  第一个结点
     * @param index2  第二个结点
     */
    public void union(int[] parents, int index1, int index2) {
        parents[find(parents, index1)] = find(parents, index2);
    }
}