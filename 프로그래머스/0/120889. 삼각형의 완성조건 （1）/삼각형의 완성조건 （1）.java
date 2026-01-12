class Solution {
    public int solution(int[] sides) {
        int max =0;
        int answer = 0;
        int hap =0;
        for(int i=0;i<sides.length;i++){
            hap += sides[i];
            if(sides[i]>max){
                max = sides[i];
            }
        }
        int big = hap-max;
        if(big<=max){
           answer = 2; 
        }
        else{
            answer =1;
        }
        return answer;
    }
}