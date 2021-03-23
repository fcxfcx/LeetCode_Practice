package Bit_Manipulation;

public class Problem_136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }
}
