class Solution {
    public long solution(int n, long l, long r) {
        long right = cntOne(n, r);
        long left = cntOne(n, l - 1);
        return right - left;
    }
    
    long cntOne(int n, long pos){
        if(n == 1) return pos <= 2 ? pos : pos - 1;
        
        long lenSub = (long)Math.pow(5, n - 1);
        long onePerSection = (long)Math.pow(4, n - 1);
        int section = (int)(pos / lenSub);
        
        if(pos % lenSub == 0) section -= 1;
        
        if(section < 2) 
            return onePerSection * section + cntOne(n - 1, pos - section * lenSub);
        else if(section == 2)
            return onePerSection * section;
        else
            return onePerSection * (section - 1) + cntOne(n - 1, pos - section * lenSub);
    }
}