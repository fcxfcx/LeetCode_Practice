package Bit_Manipulation;

public class Interview_1601 {
    public int[] swapNumbers(int[] numbers) {
        if(numbers[0] == numbers[1]) return numbers;
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }
}
