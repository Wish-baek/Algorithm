class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int len = sizes.length;
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        for(int i= 0; i<len;i++){
            for(int j= 0; j<2;j++){
                int w = Math.min(sizes[i][0], sizes[i][1]);
                int h = Math.max(sizes[i][0], sizes[i][1]);
                width = Math.max(width, w);
                height = Math.max(height, h);
            }
        }
        answer = width * height;
        return answer;
    }
}