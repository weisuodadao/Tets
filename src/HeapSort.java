package src;

/**
 * Created by luoxianzhuo on 2019/4/8 16:01
 * 堆排序
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class HeapSort {

   /* */

    /**
     * 最大堆实现堆排序
     *//*
    private static void heapSort(int[] arr) {
        int len = arr.length - 1;
        for (int i = len / 2; i >= 0; i--) { //最大堆构造
            heapAdjust(arr, i, len);
        }
        //调整堆
        while (len >= 0) {
            swap(arr, 0, len--);    //将堆顶元素与尾节点交换后，长度减1，尾元素最大
            heapAdjust(arr, 0, len);    //再次对堆进行调整
        }
    }*/
    private static void heapSort(int[] arr) {
        int len = arr.length - 1;
        for (int i = len / 2; i >= 0; i--) {
            heapAdjust(arr, i, len);
        }
        while (len > 0) {
            swap(arr, 0, len--);
            heapAdjust(arr, 0, len);
        }
    }

 /*   public static void heapAdjust(int[] arr, int i, int len) {
        int left, right, j;
        while ((left = 2 * i + 1) <= len) {    //判断当前父节点有无左节点（即有无孩子节点，left为左节点）
            right = left + 1;  //右节点
            j = left;   //j"指针指向左节点"
            if (j < len && arr[left] < arr[right])    //右节点大于左节点
                j++;     //当前把"指针"指向右节点
            if (arr[i] < arr[j])    //将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
                swap(arr, i, j);
            else         //说明比孩子节点都大，直接跳出循环语句
                break;
            i = j;
        }
    }*/

    private static void heapAdjust(int[] arr, int i, int len) {
        int left, right, j;
        while ((left = 2 * i + 1) <= len) {
            right = left + 1;
            j = left;
            if (j < len && arr[left] < arr[right]) {
                j++;
            }
            if (arr[i] < arr[j]) {
                swap(arr, i, j);
            } else {
                break;
            }
            i = j;
        }
    }


    public static void swap(int[] arr, int i, int len) {
        int temp = arr[i];
        arr[i] = arr[len];
        arr[len] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 32, 5, 43};
        heapSort(arr);
        for (Integer a : arr) {
            System.out.print(a + " ");
        }
    }
}