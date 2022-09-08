package com.nitron.leetcodedaily.SubstringWithLargestVariance;

import javafx.util.Pair;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SubStrWidLargestVarianceThreaded {
    Map< Pair<Character,Integer>, Integer> map= new HashMap<>();
    public static void main(String[] args)  {
        String s = "lucmdweawziyvixyfesksmkxkbzzzqdmrmvdxeghlrlyteuhvumwppwltssrlboozoiudqegobjvnuinwoaaxbiqivtwabunqkzvjnczasvghsvrckpzelcqeloppxwmnbeocoiximllpvhahesjxznfphohoycaqsaghpoligtghoejodmhwuzjmpwkrpehheuubiespninbzfbqtiimtzbymdrxxbjzhqanmoocicqfhdrtfwjbxkgehjdqhmmjnrrgilsvyhonfmvywaejhxxgabogdqgttfiufrgpgpduwhzgmgoecwagwdvmnobiukuigphrkupqkeaphjsqhmetkgmcramydkosqqmayrdgfiokpanxznuknqpcqsbumyrxfsmmcxvherbjykpbwdzeqjgdhysauxflcdhkmlflmygylnxubaimtmsbbapfsrqdwwihubmemmhumzhmvalwkneehsxjofrcubyscgmlwfuzepmlyvpthqlvxrzcekmbemneozbtfajwkaizheoexbtdicgzmgnbytwyruexhigheujnolqafjmvtfgeduwtkisjovklsazfoslylmqjkgafbcfsawdjlyyobskeywidozxbmmapjrhqjjtoknpujwibccdotmnfxqcmhbelrireqfxmqoitciszlhecacxrpdbxeqravhrgwylhzpamvjjmghrzywpfpxjogidkkuolqscxuqgxzfmkuiagndjfhcmuwysojjmwtdrmicpnjpxonymsuwvrodwmfbtpwyxmesmkpuctrlabbknyoyueumfitkpdzsnkurzzyexeutmbqcdbmirqndghaksbpukszbkgvgswjrixuwvzsoymjuiungsnpytstwjbekzudtjxqkwkhgyophfllqvmdwvdlywtnsvlfwkesxdhdfwytgtwkgprlocjlcjqezcwpiwldnrqwyqxrgyyrkdotjhtsppwjkpecnpyarjftdbvzhdnqkqpbkwtkcfsomzwgxnwtsoslvxbwdkfvaeyxzkadctnngewqbwftphtfcdhjbwzytmrlolbgouoluyfyngtkijgwvxmjzqcapymvdssiirusnrnmuextfeosrdsudwixozufmwatfmjjumqmnprsqdrrerjkivjlnohkgckhuzbajvfjezbsivnhnexfryxghcxvetlwnjlutskdguwlsqhcuravxvfmzeycxifyjjqvbdmlmzfsuekrszqvdtmlfcytznjkplqpveqybkdmggrnyuoabxkepgbenzaufxwrmqufmnlgndjakvhbkkkzhgdoutdphnrqhtogbrpgdifgcqzheognwlgoqszqjsshaiciiwjqoxlznfgjtytrmkmypspmmsyencfxdjtzzlzgjzzoqwkzriqhvfqigezstcwcflbhyalipesdxddoyzcdskthyiasfdkgxgigirbixeaneynxedrbvfybpxxonssjylrahpkklrjgvbzllsfinxtcdkejynhxekkehqlizormtlmglsakfrketakpgsziogdgtfpwzeufejryluxjjuwfcgvbipmkrgtnfupqshysughfgnxtfgazdybvdtiqiimxibxlxhzsorqgshaauhgjszlfhaoxzfhnnfsdnsxqjmhaliuhavzqielpcqjzbzelrnruhqzxrynexubqpkhsoqrearfdxmliaiamfaorysjpuldzvuqnddmskegfmrxdgeonfhyuzhpgmghsvkvolhvrdyqvgqxshjjzrozkhkrsoktmvpkllizosqdsmybnwmybkyfqxyaeumgcubtdwtlbxuhcowgqvvrraazmeoamazjbljfzfvjmjhiifpskinydncsbcoefknvjzqinbfvgyyfjzqewxwdzivzeemqvxmjrsuxavjeqtbklezsqeas";
        String s2 = "aabacbcbbc";
        System.out.println(new SubStrWidLargestVarianceThreaded().calcVariance(s));
    }

    private int calcVariance(String s)  {

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }
        char[] carr = s.toCharArray();
        var pool = Executors.newFixedThreadPool(6);
        int max = 0;
        List<Character> charList = new ArrayList<>(set);
    Instant start = Instant.now();
    List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < charList.size(); i++) {
            char firstChar = charList.get(i);

            for (int j = i + 1; j < charList.size(); j++) {
                char secondChar = charList.get(j);
                futures.add(pool.submit(() -> {
                            int tempMax = 0;
                            for (int a = 0; a < s.length(); a++) {
                                int firstCharCount = 0;
                                int secondCharCount = 0;
                                for (int b = a; b < s.length(); b++) {
                                    if (carr[b] == firstChar) {
                                        firstCharCount++;
                                    } else if (carr[b] == secondChar) {
                                        secondCharCount++;
                                    }

                                    if (firstCharCount > 0 && secondCharCount > 0)
                                        tempMax = Math.max(tempMax, Math.abs(firstCharCount - secondCharCount));

                                }
                            }
                            return tempMax;
                        }));
            }
        }
        pool.shutdown();
        try {
            pool.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(Future<Integer> future : futures)
        {
            try {
                max = Math.max(max, future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("TIME : "+ Duration.between(start, Instant.now()).toMillis());
        return max;
    }
}