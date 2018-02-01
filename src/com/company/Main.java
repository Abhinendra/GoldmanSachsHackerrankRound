package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String pattern = "MMNM";
        System.out.println(findPossibleSmallestNumberMatchingPattern(pattern));
    }

    /*
      * Complete the function below.
      */
    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        if (pattern == " " || pattern == null || pattern == "")
            return -1;
        if (pattern.length() > 8)
            return -1;

        for (char charAt:pattern.toCharArray()){
            if(charAt !='M' && charAt!='N')
                return -1;
        }
        String output="";
        output="1";
        int nextInt=2;
        int index=0;
         for(char charAt:pattern.toCharArray()){
           if(charAt=='M'){
               int count=continuousCountOfM(pattern,index);
               String prefix="";
               if(index-count>1){
                 prefix=prefix+output.substring(0,index-count+1);
               }
               output=prefix+nextInt+output.substring(index-count+1);
               
           }
           if (charAt=='N'){
               output+=nextInt;
           }
           nextInt++;
           index++;
       }
        if(output=="")
            return -1;
        return Integer.parseInt(output);


    }

    static int continuousCountOfM(String pattern, int index){
        int count=0;
        while(count<=index){
            if(pattern.toCharArray()[index-count]=='M'){
                count++;
            }else {
                return count;
            }
        }
        return count;
    }
}
