class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long t_len = t.length();
        long p_len = p.length();
        long p_num = Long.parseLong(p);
        
        for(int i=0;i<t_len;i++){
            String tmp ="";
            
            if(i+p_len>t_len) break;
            for(int j =i; j<i+p_len;j++){
                tmp+=t.charAt(j);
            }
            System.out.println(tmp);
            if(Long.parseLong(tmp)<=p_num)answer++;
        }
        
        return answer;
    }
}