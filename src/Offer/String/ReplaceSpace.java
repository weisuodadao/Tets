package src.Offer.String;

/**
 * @ClassName ReplaceSpace
 * @Description:
 * @Author xianzhuo
 * @Date 2021/7/31 5:57 下午
 * @Version V1.0
 * 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 **/
public class ReplaceSpace {

    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '&';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }


}
