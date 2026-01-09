class Solution {
    public int solution(int n, int k) {
        int sheep = n * 12000;
        int cola = k * 2000;
        int service = n/10*2000;
        //일단 서비스 생각 없이 얼마를 내야 하는지 계산해
        int answer = sheep + cola-service;
        //여기서 서비스를 빼주면 총 지불 할 값
        return answer;
    }
}