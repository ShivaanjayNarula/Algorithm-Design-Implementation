/*
It is the Heapify algorithm for minHeap.
 */

import java.util.*;
public class Heapify2{
    public static void main(String[] args) {
        int[] arr = {10,50,5,25,100,30,40,150,90};
        System.out.println(isMinHeap(arr,arr.length));
        heapMin(arr,arr.length);
        System.out.println(isMinHeap(arr,arr.length));
        System.out.println(Arrays.toString(arr));
        heapSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    // Verifies if the given array satisfies the properties of a min heap.

    public static boolean isMinHeap(int[] arr, int n) {
        for(int i=n/2-1;i>=0;i--) {
            while(true) {
                int crr = i,left = 2*i+1, right = 2*i+2;
                if(left<n && arr[crr]>arr[left]) {
                    crr = left;
                }
                if(right<n && arr[crr]>arr[right]) {
                    crr = right;
                }
                if(crr!=i) {
                    return false;
                }else {
                    break;
                }
            }
        }
        return true;
    }

    // Performs heap sort to sort the array.

    public static void heapSort(int[] arr, int n) {
        for(int i=0;i<n;i++) {
            delete(arr,n-i-1);
        }
    }

    // Removes the root element (the smallest in the min heap) and restores the heap property for the remaining elements.

    public static int delete(int[] arr,int end) {
        if(arr.length==0) return -1;
        int temp = arr[0];
        arr[0] = arr[end];
        arr[end--] = temp;
        heapMin(arr,end+1);
        return temp;
    }

    // Builds or maintains a min heap from an unsorted array or a partially sorted array.

    public static void heapMin(int[] arr,int n) {
        for(int i=n/2-1;i>=0;i--) {
            while(true) {
                int crr = i,left = 2*i+1, right = 2*i+2;
                if(left<n && arr[crr]>arr[left]) {
                    crr = left;
                }
                if(right<n && arr[crr]>arr[right]) {
                    crr = right;
                }
                if(crr!=i) {
                    int temp = arr[i];
                    arr[i] = arr[crr];
                    arr[crr] = temp;
                    i = crr;
                }else {
                    break;
                }
            }
        }
    }
}
