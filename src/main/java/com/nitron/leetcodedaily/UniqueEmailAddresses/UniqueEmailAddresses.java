package com.nitron.leetcodedaily.UniqueEmailAddresses;

import java.util.*;

public class UniqueEmailAddresses {


    public static void main(String[] args) {

        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

        new UniqueEmailAddresses().numUniqueEmails(emails);

    }


    public int numUniqueEmails(String[] emails) {

        Map<String, Set<String>> map = new HashMap<>();

        for(String email: emails)
        {

            String[] parts = email.split("@");
            map.computeIfPresent(parts[1], (k,v)-> {
                String mailUser ;
                if(parts[0].contains("+"))
                    mailUser = parts[0].split("\\+")[0];
                else
                    mailUser = parts[0];

                v.add(mailUser.replace(".", ""));
                return v;
            });

            map.computeIfAbsent(parts[1], (k)-> {

                Set<String> list = new HashSet<>();

                String mailUser ;
                if(parts[0].contains("+"))
                    mailUser = parts[0].split("\\+")[0];
                else
                    mailUser = parts[0];

                list.add(mailUser.replace(".", ""));
                return list;

            });
        }

        int count =0;

        for( Map.Entry<String, Set<String>> entry : map.entrySet())
        {
            count+=entry.getValue().size();
        }

        return count;

    }
}
