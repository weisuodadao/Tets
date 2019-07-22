package src.Array;

/**
 * Created by luoxianzhuo on 2019/3/22 16:05
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class SecondMax {
    public static void main(String[] args) {
        int[] arr = {12, 49, 23, 32, 148, 48,};

        int max = arr[0];
        int secondMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }

        }


        System.out.println("最大值:" + max + ",第二大数" + secondMax);

    }
}