package DetailPractice;

import java.util.HashMap;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 974. 和可被K整除的子数组
 * 标签：数组，哈希表
 */
public class Problem_974 {
    public int subarraysDivByK(int[] A, int K) {
        // 哈希表的键是前缀和mod K 的结果，值是mod结果相同的数量
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // 初始化哈希表，填入0，1可以保证前缀和直接整除的情况,这里的1是因为之后的循环过程中是先取same再维护map
        hashMap.put(0, 1);
        // sum储存前缀和
        int sum = 0;
        // ans储存符合要求的结果数
        int ans = 0;
        for (int elem : A) {
            sum = sum + elem;
            // Java在取模计算时，负数的模会是负数，因此需要额外处理
            int modular = (sum % K + K) % K;
            // 判断子数组的和能否被 K 整除就等价于判断 (P[j] - P[i-1]) mod K == 0,此处的i<j
            // 根据 同余定理，只要 P[j] mod K == P[i-1] mod K，就可以保证上面的等式成立。
            // 查询相同取模结果的数量,如果没有则返回0
            int same = hashMap.getOrDefault(modular, 0);
            ans += same;
            // 更新哈希表
            hashMap.put(modular, same + 1);
        }
        return ans;
    }
}
