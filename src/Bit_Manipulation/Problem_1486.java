package Bit_Manipulation;

public class Problem_1486 {
    public int xorOperation(int n, int start) {
        int num = 0;
        for(int i=0; i<n; i++){
            int newNum = start + 2*i;
            num ^= newNum;
        }
        return num;
    }
}
