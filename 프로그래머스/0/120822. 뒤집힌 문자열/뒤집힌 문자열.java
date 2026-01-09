class Solution { // (1) 클래스 시작
    public String solution(String my_string) { // (2) 메서드 시작
        char a[] = my_string.toCharArray(); // (오타 수정!)
        int j = 0;
        char b[] = new char[a.length];
        
        for(int i = a.length - 1; i >= 0; i--) { // (3) for문 시작
            b[j] = a[i];
            j++;
        } // (3) for문 끝
        
        String answer = new String(b);
        return answer;
    } // (2) 메서드 끝
} // (1) 클래스 끝