// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public double angleClock(int hour, int minutes) {
        double hhand, mhand;
        double angle;
        
        if(hour == 12)
            hour = 0;
        
        hhand = hour * 30 + minutes * 0.5;
        mhand = minutes * 6;
        
        angle = Math.abs(hhand - mhand);
        
        if(angle >= 180)
            angle = 360 - angle;
        
        return angle;
        
    }
}