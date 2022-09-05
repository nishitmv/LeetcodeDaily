package com.nitron.leetcodedaily.CountFamilyLogins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountFamilyLogins {

    public static void main(String[] args) {

        String[] logins = {"abc", "def", "bcd", "bcd" };

        List<String> loginList = new ArrayList<>(logins.length);

        loginList.addAll(Arrays.asList(logins));

        System.out.println(new CountFamilyLogins().countFamilies(loginList));

    }

    private int countFamilies(List<String> logins) {

        Collections.sort(logins);
        int count = 0;
        List<String> visited = new ArrayList<>();
        for (String login : logins) {
            if(visited.contains(login))
                count++;
            char[] arr = new char[login.length()];
            int i = 0;
            for (char ch : login.toCharArray()) {
                if (ch == 'z')
                    arr[i] = 'a';
                else
                    arr[i] = ++ch;
                i++;
            }
            String str1 = new String(arr);
            if (logins.contains(str1)) {
                visited.add(str1);
                visited.add(login);
                count++;
            }


        }

        return count;
    }

}
