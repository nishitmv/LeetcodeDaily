package com.nitron.leetcodedaily.queueReconstructByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructByHeight {
    public int[][] reconstruct(int[][] queue) {

        // Sort by height decending
        Arrays.sort(queue, (person1, person2)->{

            if(person1[0]==person2[0])
            {
               if(person1[1]<person2[1])
                   return -1;
               else if (person1[1]>person2[1])
                   return 1;
               return 0;
            }
            else if(person1[0]<person2[0]) {

                return 1;
            }
            return -1;

        });

        List<int[]> res = new ArrayList<>();


        // Insert in list at Kth place person[1] is k person[0] is height.
        for(int[] person: queue)
        {
            res.add(person[1], person);
        }

        return res.toArray(new int[queue.length][2]);
    }
}
