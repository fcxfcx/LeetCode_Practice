package Sort;

public class Problem_Offer_51 {
    public class Solution{
        public int reversePairs(int[] nums){
            int len = nums.length;
            if(len<2) {
                return 0;
            }
            int[] temp = new int[len];
            return reversePairs(nums, 0, len-1, temp);
        }

        public int reversePairs(int[] nums, int start, int end, int[] temp) {
            if(start == end){
                return 0;
            }
            int middle = start + (end - start)/2;
            //归并左边部分
            int leftPairs = reversePairs(nums, start, middle, temp);
            //归并右边部分
            int rightPairs = reversePairs(nums, middle+1, end, temp);
            //如果已经归并完成，则结束
            if(nums[middle] < nums[middle+1]){
                return leftPairs+rightPairs;
            }
            //计算当前归并的逆序对数量
            int crossPairs = mergeSortAndCount(nums,start,middle,end,temp);
            return leftPairs+rightPairs+crossPairs;
        }

        public int mergeSortAndCount(int[] nums, int start, int middle, int end, int[] temp) {
            if (end + 1 - start >= 0) System.arraycopy(nums, start, temp, start, end + 1 - start);

            int i=start;
            int j= middle+1;
            int count = 0;
            for(int k=start; k<=end; k++){
                if(i == middle+1){
                    nums[k] = temp[j];
                    j++;
                }else if(j == end+1){
                    nums[k] = temp[i];
                    i++;
                }else if(temp[i] <= temp[j]){
                    nums[k] = temp[i];
                    i++;
                }else{
                    nums[k] = temp[j];
                    j++;
                    //右边每有一个数被挑选出来，左边每剩一个数就说明有一个逆序对
                    count += (middle+1-i);
                }
            }
            return count;
        }
    }
}
