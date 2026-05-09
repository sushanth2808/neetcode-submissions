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
        intervals.sort((a,b)->a.start-b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(Interval interval: intervals){
            if(pq.isEmpty() || pq.peek()>interval.start){
                pq.offer(interval.end);
            }
            else{
                pq.poll();
                pq.offer(interval.end);
            }
            res=Math.max(res,pq.size());
        }
        return res;
    }
}
