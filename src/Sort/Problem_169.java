package Sort;

public class Problem_169 {
        public int majorityElement(int[] nums) {
            quickSort(nums);
            return nums[nums.length/2];
        }

        public static void quickSort(int[] arr){
            quickSort(arr,0,arr.length-1);
        }

        public static void quickSort(int[] arr, int start, int end){
            if(start >= end) return;
            int middle = partition(arr,start,end);
            quickSort(arr,start,middle-1);
            quickSort(arr,middle+1,end);
        }

        public static int partition(int[] arr, int start, int end){
            int pivot = arr[start];
            int left = start+1;
            int right = end;
            while(left < right){
                while(left<right && arr[left]<=pivot) left++;
                if(left < right){
                    exchange(arr, left, right);
                    right --;
                }
            }
            if(left == right && arr[right] > pivot) right--;
            if(right != start)exchange(arr, start, right);
            return right;
        }

        public static void exchange(int[]arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
