package com.nitron.leetcodedaily.queueReconstructByHeight;

public class Main {

    public static void main(String[] args) {

        int[][] queue = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

       int[][] result =  new QueueReconstructByHeight().reconstruct(queue);

       for(int[] val:result)
       {
           System.out.println("{"+val[0]+", "+val[1]+" }");
       }

    }

}
