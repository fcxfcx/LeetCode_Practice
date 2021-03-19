package Sort;

public class Interview_1001 {
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            for(int i=0; i<n; i++){
                A[m+i] = B[i];
            }
            A = selectSort(A);
        }

        public int[] selectSort(int[] a){
            int length = a.length;
            for(int i=0; i<length-1; i++){
                int minIndex = i;
                for(int j=i; j<length; j++){
                    if(a[j] < a[minIndex]){
                        minIndex = j;
                    }
                }
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
            return a;
        }
    }
}
