class Solution {
    public int[] solution(int money) {
        // 1. 딱 2개만 들어갈 상자(배열)를 미리 만든다.
        int[] answer = new int[2]; 
        
        // 2. 계산하기
        int a = money / 5500; // 잔 수
        int b = money % 5500; // 잔돈
        
        // 3. 배열의 각 칸에 직접 넣어주기
        answer[0] = a;
        answer[1] = b;
        
        // 4. 약속했던 int[] 타입을 돌려준다!
        return answer;
    }
}