package src;

/**
 * @ClassName Mouth
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/10/23 3:09 下午
 * @Version V1.0
 **/
public class Mouth {

    public int countMouse(int x, int n) {
        if (n < 0) {
            return 0;
        }
        int[] result = new int[n + 1];
        result[0] = x;
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 != 0) {
                if (i - 5 >= 0) {
                    if (i == 5) {
                        result[i] = result[i - 1] - result[0];
                    } else {
                        result[i] = result[i - 1] - (result[i - 5] - result[i - 7]);
                    }

                } else {
                    result[i] = result[i - 1];

                }
                if (i >= 3) {
                    result[i] -= -1;
                }
            } else {
                result[i] = result[i - 1] + result[i - 1] * 2;
            }
        }
        return result[n];
    }

}
