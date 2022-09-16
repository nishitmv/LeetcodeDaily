package com.nitron.leetcodedaily.FindOrigArrFromDoubleArr;

import java.util.*;

public class FindOrigArrFromDoubleArr {

    public static void main(String[] args) {

      int[] changed =   {1,3,4,2,6,8};

        for (int i : new FindOrigArrFromDoubleArr().findOriginalArray(changed)) {
            System.out.print(i+" ");
        }

    }


    public int[] findOriginalArray(int[] changed) {

        if(changed.length%2 !=0)
        {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        for (int val : changed) {
            list.add(val);
        }
        Collections.sort(list);
       List<Integer> result = new ArrayList<>();
        int i =0;
       while(i<(changed.length/2))
       {
           i++;
           Integer val = list.get(0);
           list.remove(val);
           if(list.contains(val *2)) {
               result.add(val);
               list.remove(Integer.valueOf(val*2));
           }
       }
       int[] resArr = new int[changed.length/2];
       if(result.isEmpty() || result.size()<changed.length/2)
           return new int[]{};
       else if ( result.size() == changed.length/2)
       {
           int j =0;
          for(int val : result)
          {
              resArr[j] = val;
              j++;
          }
       }
       return resArr;
    }


}
