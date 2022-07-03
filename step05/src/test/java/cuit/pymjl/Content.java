package cuit.pymjl;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/7/3 18:29
 **/
public class Content {
    @Test
    void test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1. 创建一个map，先把数组中的数字和出现的次数存入map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 2. 如果map中存在该数字，则该数字的出现次数加1，否则把该数字存入map中
            // key为数字，value为出现的次数
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 3. 创建一个优先级队列，先把map中的所有键值对存入优先级队列中(小顶堆)
        // 这里重写了优先级队列的比较器，比较的是value的大小，Lambda表达式
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        // 4. 循环map中的所有键值对，把键值对存入优先级队列中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 5. 如果优先级队列的长度小于k，则把该键值对存入优先级队列中
            pq.offer(entry);
            // 6. 如果优先级队列的长度大于k，则把优先级队列的最小值移除
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // 7. 创建一个数组，把优先级队列中的所有键值对的键存入数组中
        int[] res = new int[pq.size()];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
