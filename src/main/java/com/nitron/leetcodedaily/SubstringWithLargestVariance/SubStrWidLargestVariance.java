package com.nitron.leetcodedaily.SubstringWithLargestVariance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStrWidLargestVariance {

    public static void main(String[] args) {

        String s = "lucmdweawziyvixyfesksmkxkbzzzqdmrmvdxeghlrlyteuhvumwppwltssrlboozoiudqegobjvnuinwoaaxbiqivtwabunqkzvjnczasvghsvrckpzelcqeloppxwmnbeocoiximllpvhahesjxznfphohoycaqsaghpoligtghoejodmhwuzjmpwkrpehheuubiespninbzfbqtiimtzbymdrxxbjzhqanmoocicqfhdrtfwjbxkgehjdqhmmjnrrgilsvyhonfmvywaejhxxgabogdqgttfiufrgpgpduwhzgmgoecwagwdvmnobiukuigphrkupqkeaphjsqhmetkgmcramydkosqqmayrdgfiokpanxznuknqpcqsbumyrxfsmmcxvherbjykpbwdzeqjgdhysauxflcdhkmlflmygylnxubaimtmsbbapfsrqdwwihubmemmhumzhmvalwkneehsxjofrcubyscgmlwfuzepmlyvpthqlvxrzcekmbemneozbtfajwkaizheoexbtdicgzmgnbytwyruexhigheujnolqafjmvtfgeduwtkisjovklsazfoslylmqjkgafbcfsawdjlyyobskeywidozxbmmapjrhqjjtoknpujwibccdotmnfxqcmhbelrireqfxmqoitciszlhecacxrpdbxeqravhrgwylhzpamvjjmghrzywpfpxjogidkkuolqscxuqgxzfmkuiagndjfhcmuwysojjmwtdrmicpnjpxonymsuwvrodwmfbtpwyxmesmkpuctrlabbknyoyueumfitkpdzsnkurzzyexeutmbqcdbmirqndghaksbpukszbkgvgswjrixuwvzsoymjuiungsnpytstwjbekzudtjxqkwkhgyophfllqvmdwvdlywtnsvlfwkesxdhdfwytgtwkgprlocjlcjqezcwpiwldnrqwyqxrgyyrkdotjhtsppwjkpecnpyarjftdbvzhdnqkqpbkwtkcfsomzwgxnwtsoslvxbwdkfvaeyxzkadctnngewqbwftphtfcdhjbwzytmrlolbgouoluyfyngtkijgwvxmjzqcapymvdssiirusnrnmuextfeosrdsudwixozufmwatfmjjumqmnprsqdrrerjkivjlnohkgckhuzbajvfjezbsivnhnexfryxghcxvetlwnjlutskdguwlsqhcuravxvfmzeycxifyjjqvbdmlmzfsuekrszqvdtmlfcytznjkplqpveqybkdmggrnyuoabxkepgbenzaufxwrmqufmnlgndjakvhbkkkzhgdoutdphnrqhtogbrpgdifgcqzheognwlgoqszqjsshaiciiwjqoxlznfgjtytrmkmypspmmsyencfxdjtzzlzgjzzoqwkzriqhvfqigezstcwcflbhyalipesdxddoyzcdskthyiasfdkgxgigirbixeaneynxedrbvfybpxxonssjylrahpkklrjgvbzllsfinxtcdkejynhxekkehqlizormtlmglsakfrketakpgsziogdgtfpwzeufejryluxjjuwfcgvbipmkrgtnfupqshysughfgnxtfgazdybvdtiqiimxibxlxhzsorqgshaauhgjszlfhaoxzfhnnfsdnsxqjmhaliuhavzqielpcqjzbzelrnruhqzxrynexubqpkhsoqrearfdxmliaiamfaorysjpuldzvuqnddmskegfmrxdgeonfhyuzhpgmghsvkvolhvrdyqvgqxshjjzrozkhkrsoktmvpkllizosqdsmybnwmybkyfqxyaeumgcubtdwtlbxuhcowgqvvrraazmeoamazjbljfzfvjmjhiifpskinydncsbcoefknvjzqinbfvgyyfjzqewxwdzivzeemqvxmjrsuxavjeqtbklezsqeas";

        System.out.println(new SubStrWidLargestVariance().calcVariance(s));

    }

    private int calcVariance(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            set.add(c);
        }
        char[] carr = s.toCharArray();
        int tempMax = 0;
        int max = 0;
        List<Character> charList = new ArrayList<>(set);

        for (int i = 0; i < charList.size(); i++) {
            char firstChar = charList.get(i);

            for (int j = i + 1; j < charList.size(); j++) {
                char secondChar = charList.get(j);

                tempMax = 0;
                for (int a = 0; a < s.length(); a++) {

                    int firstCharCount = 0;
                    int secondCharCount = 0;
                    for (int b = a ; b < s.length(); b++) {

                        if (carr[b] == firstChar) {
                            firstCharCount++;
                        } else if (carr[b] == secondChar) {
                            secondCharCount++;
                        }
                        if (firstCharCount > 0 && secondCharCount > 0)
                            tempMax = Math.max(tempMax, Math.abs(firstCharCount - secondCharCount));

                    }

                }
                max = Math.max(max, tempMax);
            }

        }


        return max;
    }


}
