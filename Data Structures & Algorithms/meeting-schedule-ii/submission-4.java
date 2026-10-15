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
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        int res = 0;
        int n  = intervals.size();
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            Interval interval = intervals.get(i);
            if(!pq.isEmpty() && pq.peek()<=interval.start){
                pq.poll();
                pq.offer(interval.end);
            }
            else{
                pq.offer(interval.end);
                res++;
            }
        }
        return res;
    }
}
