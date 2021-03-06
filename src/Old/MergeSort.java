package src.Old;

public class MergeSort {
    public static void mergeSort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        if (low > high) return;
        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {
        // 临时数组
        int[] tmpArr = new int[a.length];
        // 右数组第一个元素索引
        int firstRight = mid + 1;
        // third 记录临时数组的索引
        int tmpArrIndex = low;
        // 缓存左数组第一个元素的索引
        int firstLeft = low;

        while (low < mid && firstRight <= high) {
            // 从两个数组中取出最小的放入临时数组
            if (a[low] < a[firstRight]) {
                tmpArr[tmpArrIndex++] = a[low++];
            } else {
                tmpArr[firstLeft++] = a[firstRight];
            }
        }
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
        while (firstRight <= high) {
            tmpArr[tmpArrIndex++] = a[firstRight];
        }
        while (low <= mid) {
            a[firstLeft] = tmpArr[firstLeft++];
        }

    }


}
