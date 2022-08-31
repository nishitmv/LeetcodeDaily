package com.nitron.leetcodedaily.TwoSum2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

    public static void main(String[] args) {

        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] numbers2 = {12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997};
        int target2 = 542;
        for (int i : new TwoSum2BinSrch().twoSum(numbers2, target2)) {
            System.out.print(i+" ");
        }

    }

    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++)
        {
            if(map.containsKey(numbers[i]) && numbers[i]*2 == target)
            {
                return new int[]{map.get(numbers[i]), i};
            }
            else {
                map.putIfAbsent(numbers[i], i);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            int key2 = target-entry.getKey();
            if(map.containsKey(key2))
            {
                return entry.getValue()< map.get(key2) ? new int[]{entry.getValue(), map.get(key2)} : new int[]{map.get(key2), entry.getValue()};
            }
        }

        return new int[]{};
    }

}
