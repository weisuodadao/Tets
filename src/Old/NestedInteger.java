package src.Old;

import java.util.List;

/**
 * Created by luoxianzhuo on 2019/4/8 16:49
 *
 * @author luoxianzhuo
 * @copyright Copyright 2014-2017 JD.COM All Right Reserved
 */
public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}