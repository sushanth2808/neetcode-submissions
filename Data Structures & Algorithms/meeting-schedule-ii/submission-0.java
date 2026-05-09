/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        int index=0;
        for(Interval interval : intervals){
            start[index]=interval.start;
            end[index++]=interval.end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int p1=0;
        int p2=0;
        int count=0;
        int res=0;
        while(p1<n){
            if(start[p1]<end[p2]){
                count++;
                p1++;
            }
            else{
                count--;
                p2++;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}
