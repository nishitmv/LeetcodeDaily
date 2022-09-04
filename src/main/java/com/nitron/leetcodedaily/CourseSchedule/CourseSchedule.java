package com.nitron.leetcodedaily.CourseSchedule;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{1, 4}, {2, 4}, {3, 1}, {3,2}};
        System.out.println(new CourseSchedule().canFinish(numCourses,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length==0)
            return true;

        Map<Integer, Integer> vertexIndegreeMap = new HashMap<>();
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> subjects = new HashSet<>();
        Set<Integer> subsWithDepependency = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
            subjects.add(prerequisite[0]);
            subjects.add(prerequisite[1]);
            subsWithDepependency.add(prerequisite[0]);
            vertexIndegreeMap.computeIfPresent(prerequisite[0], (k, v) -> v + 1);
            vertexIndegreeMap.putIfAbsent(prerequisite[0], 1);
        }
        subjects.forEach(sub -> {
            if (!subsWithDepependency.contains(sub)) {
                queue.add(sub);
            }
        });
        for(int i=0;i<numCourses; i++)
        {
            if(!subjects.contains(i))
                queue.add(i);
        }
        int counter = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            counter++;

            adjacencyList.get(vertex).forEach(vx -> {
                if (vertexIndegreeMap.containsKey(vx))
                {
                    int indeg = vertexIndegreeMap.get(vx);
                 if(indeg>1)
                 {
                     vertexIndegreeMap.put(vx, indeg-1);
                 }
                 else{
                     vertexIndegreeMap.remove(vx);
                     queue.add(vx);
                 }
                }
            });
        }
        return counter==numCourses;
    }
}
