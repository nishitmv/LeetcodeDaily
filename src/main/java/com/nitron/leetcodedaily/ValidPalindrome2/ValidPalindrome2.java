package com.nitron.leetcodedaily.ValidPalindrome2;

public class ValidPalindrome2 {

    public static void main(String[] args) {

        String s = "sxigqizmbopbyluwxmehcqudofdjadhsteappejrnxyfoxobpdlpuhzkojxabyybmlsviemdjtptxoatpiztvebbbsmozxcomjyudelcmzmpadftmegvhudcivnpuondhapibzvtrlokydxswdihcmsoupfohwuyoamglrwptvixhgjhskjiyyymwciynhmdjtavvzrlxgqwmzkcpoainizfgacmixzmoakwwrslrsbfcapinwobhfufvtzgqznlqwzwdmztztxchnnbmqdpapxsyyjscseeevzinrmiittqpgkuvusayuldlfzdrjokwygavfvkmjljedflzkmvvhlwriwsavptnfqhqcxgdsnsbughdhkxjtzwnkzaioltvqfwayupkxzkmioxpgdlzsrkahteoptjyihxuzbmxyonxwnglfphosvgaytvrexeprlduttetlugjrhrmatssanekatiugnfluwvyuiqlndefpvhujgshmgltcamniqktfaajyekhmbzqishcebfovgjmvtuqjsakwoxganxckbflctlelanyxfoyvxpxrtbigiwbxaddqdfyehuntzzsavbvsynxiqgxuhpcjfplpbphfvkrqczzoaxebqxpbwxqiamxbruxskbodjivaoyrfnjaauxhqcylssaxcblrvvfhvyirsubmrtiqjxnulobfzumohiuxmuwbygeamnxirxwcfsjnxmnqcbkrkhclvfhzmphncjpefxnvhulztbemyvvpqaogkioyrxfxpanlkiitzxrrvfwjsluihbcujsarmufmiuxnzftrhpjfkwkgdqsshyhshaoerkefsfxzpmrdzxmlbvkjturdwxlrjdwrhfswtjwmctendxgwydktzbevgbecxoqgxofdyzmzmfcniantmcsjlohyltlykthfrcywwbnscrjasofwmdzxiejggfwrkbkygwnuzzgalysocrheemksgypnit";
            String s2 = new StringBuilder(s).reverse().toString();
        System.out.println(new ValidPalindrome2().validPalindrome(s, s2));

    }

    public boolean validPalindrome(String s, String s2) {

        if(s.equals(s2))
            return true;
        else {
            char charToRemove = 0;
            char charToRemove2 = 0;

            for(int i =0;i<s.length();i++)
            {
                if(s.charAt(i)!=s2.charAt(i))
                {
                    charToRemove = s.charAt(i);
                    charToRemove2 = s2.charAt(i);

                    break;
                }
            }

           String s3= s.replace(String.valueOf(charToRemove), "");
            String s4 = s2.replace(String.valueOf(charToRemove), "");

            if(s3.equals(s4)) {
                return true;
            }
                else{

                s3= s.replace(String.valueOf(charToRemove2), "");
                s4 = s2.replace(String.valueOf(charToRemove2), "");
            }

           return s3.equals(s4);
        }

    }

}
