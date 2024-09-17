package com.lvwanjie.myapplication.kotlinTest.testAlgorithm;

public class TwoStrCompare {


    public static void main(String  args[]){
        System.out.println(compare("abc1","abc"));;
    }

    public static boolean compare(String str1,String str2){
        if(str1 == null || str2 == null){
            return false;
        }
        char c1 [] = str1.toCharArray();
        char c2 [] = str2.toCharArray();

        return isContain(c1,c2) || isContain(c2,c1);
    }

    public static boolean isContain(char[] c1,char[] c2){

        boolean isContain = true;
        for(int i = 0;i<c1.length;i++){
            char temp = c1[i];
            boolean tempHasEquals = false;
            for(int j = 0;j<c2.length;j++){
                if(temp == c2[j]){
                    tempHasEquals = true;
                    break;
                }
            }
            if(!tempHasEquals){
                isContain = false;
                break;
            }
        }

        return isContain;
    }
}
