package com.nitron.leetcodedaily.NumberOfIslands;

import javafx.util.Pair;

import java.util.*;

public class NumOfIslandsDFS_FAILED {
    public int countIslands(char[][] grid) {

        if(grid.length ==0)
            return 0;
        if(grid.length ==1 && grid[0].length==1)
            if(grid[0][0] == '1')
                return 1;
            else return 0;
        int m = grid.length-1;
        int n = grid[0].length-1;
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int numOfOnes =0;

        for(int i = 0; i< m+1; i++)
            for (int j = 0; j < n+1; j++) {
                if (grid[i][j] == '1')
                    numOfOnes++;
            }
        if(numOfOnes == (m+1)*(n+1))
            return 1;
        boolean[][] visited = new boolean[m+1][n+1];
        for(boolean[] v : visited)
            Arrays.fill(v, false);
        int numOfIslands = 0;
            if(grid[0][0] =='1' ) {
                Pair<Integer, Integer> pair = new Pair<>(0, 0);
                queue.push(pair);
                visited[0][0] = true;

            }
                for (int i = 1; i < m+1; i++) {
                    if(grid[i][0] =='1' && grid[i-1][0]=='0' ) {
                        Pair<Integer, Integer> pair = new Pair<>(i, 0);
                        queue.push(pair);
                        visited[i][0] = true;
                    }

                }
                for (int j = 1; j < n+1; j++) {
                    if(grid[0][j] =='1' &&grid[0][j-1]=='0') {
                        Pair<Integer, Integer> pair = new Pair<>(0, j);
                        queue.push(pair);
                        visited[0][j] = true;
                    }
                }

            for(int i = 1; i< m+1; i++)
                for (int j = 1; j < n+1; j++) {
                    if (grid[i][j] == '1') {
                        if (!queue.contains(new Pair<>(j, i)) && grid[i - 1][j] == '0' && grid[i][j - 1] == '0') {
                            Pair<Integer, Integer> pair = new Pair<>(i, j);
                            queue.push(pair);
                            visited[i][j] = true;
                        }

                    }
                }



            if(queue.size()=='0')
                return 0;


            List<Pair<Integer, Integer>> path = new ArrayList<>();

           while(!queue.isEmpty())
           {
               var pair = queue.pop();
               path.add(pair);
               System.out.println(path);

               int i = pair.getKey();
               int j = pair.getValue();

               if(m>1 && n>1) {
                   if ((i > 0 && (grid[i - 1][j] == '0' || visited[i - 1][j])) && (j > 0 && (grid[i][j - 1] == '0' || visited[i][j - 1])) && (i < m && (grid[i + 1][j] == '0' || visited[i + 1][j])) && (j < n && (grid[i][j + 1] == '0' || visited[i][j + 1]))) {
                       numOfIslands++;
                       path = new ArrayList<>();
                   } else if ((i == m && j == n) && (i > 0 && (grid[i - 1][j] == '0' || visited[i - 1][j])) && (j > 0 && (grid[i][j - 1] == '0' || visited[i][j - 1]))) {
                       numOfIslands++;
                       path = new ArrayList<>();
                   }
                   else populateQueue(grid, m, n, queue, visited, i, j);
               }
               else if(m+1==1){
                   if((j > 0 && (grid[i][j - 1] == '0' || visited[i][j - 1])) && (j < n && (grid[i][j + 1] == '0' || visited[i][j + 1]))) {
                       numOfIslands++;
                       path = new ArrayList<>();
                   }
                   else if(j == n && (j > 0 && (grid[i][j - 1] == '0' || visited[i][j - 1]))) {
                       numOfIslands++;
                       path = new ArrayList<>();
                   }
                   else populateQueue(grid, m, n, queue, visited, i, j);
               }
               else if(n+1==1)
               {
                   if(i > 0 && (grid[i - 1][j] == '0' || visited[i - 1][j]) && (i < m && (grid[i + 1][j] == '0' || visited[i + 1][j]))) {
                       numOfIslands++;
                       path = new ArrayList<>();
                   }
                       else if(i == m && (i > 0 && (grid[i-1][j] == '0' || visited[i-1][j])))
                   {
                       numOfIslands++;
                       path = new ArrayList<>();
                   }

                   else populateQueue(grid, m, n, queue, visited, i, j);
               }
           }

           if(!path.isEmpty())
               numOfIslands++;

        return numOfIslands;
    }

    private void populateQueue(char[][] grid, int m, int n, Deque<Pair<Integer, Integer>> queue, boolean[][] visited, int i, int j) {
        if (i > 0 && !queue.contains(new Pair<>(i-1, j)) && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            queue.push(new Pair<>(i - 1, j));

        }
        if (j > 0 &&!queue.contains(new Pair<>(i, j-1)) && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            queue.push(new Pair<>(i, j - 1));

        }
        if (i < m && !queue.contains(new Pair<>(i+1, j)) && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            queue.push(new Pair<>(i + 1, j));

        }
        if (j < n && !queue.contains(new Pair<>(i, j+1)) && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            queue.push(new Pair<>(i, j + 1));

        }
        visited[i][j] = true;
    }
}
