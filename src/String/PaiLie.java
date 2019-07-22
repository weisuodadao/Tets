package src.String;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by luoxianzhuo on 2019/3/26 14:20
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public class PaiLie {
    public List<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) return null;
        char[] chars = str.toCharArray();
        TreeSet<String> temp = new TreeSet<>();
        Permutation(chars, 0, temp);
        result.addAll(temp);
        return result;
    }

    private void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if (chars == null || chars.length == 0 || begin < 0 || begin > chars.length - 1) return;
        if (begin == chars.length - 1) {
            result.add(String.valueOf(chars));
        } else {
            for (int i = begin; i <= chars.length - 1; i++) {
                swap(chars, begin, i);
                Permutation(chars, begin + 1, result);
                swap(chars, begin, i);
            }
        }
    }

    private void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void main(String[] args) {
        PaiLie p=new PaiLie();
        System.out.println(p.Permutation("lol"));
    }


}