package src.cpu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Machine
 * @Description: TODO
 * @Author xianzhuo
 * @Date 2021/8/5 4:05 下午
 * @Version V1.0
 *
 *
 * 问题描述
 *
 * 设有n个独立的作业{1, 2, …, n}, 由m台相同的机器进行加工处理. 作业i所需时间为t i. 约定:任何作业可以在任何一台机器上加工处理,
 * 但未完工前不允许中断处理,任何作业不能拆分成更小的子作业。要求给出一种作业调度方案，使所给的n 个作业在尽可能短的时间内由m台机器加工处理完成
 *
 * 贪心策略：
 * n≤m  将机器i的[0, ti]时间区间分配给作业i
 * n>m 将n个作业依其所需的处理时间从大到小排序,然后依次将作业分配给空闲的处理
 *
 **/
public class Machine {


    public static class JobNode implements Comparable {

        //作业的标号
        int id;
        //作业时间
        int time;

        public JobNode(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Object o) {
            int times = ((JobNode) o).time;
            if (time > times) {
                return -1;
            }
            if (time == times) {
                return 0;
            }
            return 1;

        }
    }

    public static class MachineNode implements Comparable {

        //机器的标号
        int id;
        //机器空闲的时间（即机器做完某一项工作的时间）
        int avail;

        public MachineNode(int id, int avail) {
            this.id = id;
            this.avail = avail;
        }

        @Override
        public int compareTo(Object o) {
            int xs = ((MachineNode) o).avail;
            if (avail < xs) {
                return -1;
            }
            if (avail == xs) {
                return 0;
            }
            return 1;
        }
    }

    public static int greedy(int[] a, int m) {
        // a的下标从1开始，所以n（作业的数目）=a.length-1
        int n = a.length - 1;
        int sum = 0;
        if (n <= m) {
            for (int i = 0; i <= n; i++) {
                sum += a[i + 1];
                System.out.println("为每个作业分别分配一台机器");
                return sum;
            }
        }
        //d保存所有的作业
        List<JobNode> jobList = new ArrayList<>();
        //将所有的作业存入List中，每一项包含标号和时间
        for (int i = 0; i < n; i++) {
            JobNode jb = new JobNode(i + 1, a[i + 1]);
            jobList.add(jb);
        }
        //对作业的List进行排序
        Collections.sort(jobList);
        LinkedList<MachineNode> machineLinkedList = new LinkedList<>();
        //将所有的机器存入LinkedList中

        for (int i = 0; i <= m; i++) {
            //初始时，每台机器的空闲时间（完成上一个作业的时间）都为0
            MachineNode machineNode = new MachineNode(i, 0);
            machineLinkedList.add(machineNode);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(machineLinkedList);
            MachineNode machineNode = machineLinkedList.peek();
            System.out.println(
                "将机器" + machineNode.id + "从" + machineNode.avail + "到" + (machineNode.avail + jobList.get(i).time)
                    + "的时间段分配给作业" + jobList.get(i).id);
            machineNode.avail += jobList.get(i).time;
            sum = machineNode.avail;

        }
        return sum;

    }


}
