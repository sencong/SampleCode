package test;
import java.util.*;

public class InsertInterval {
	static class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> inputs = new ArrayList<>();
		inputs.add(new Interval(1,3));
		inputs.add(new Interval(6,9));
		insert(inputs,new Interval(2,5));
	}
	static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for(Interval interval: intervals){
            if(interval.end < newInterval.start)
                res.add(interval);
            else if(newInterval.end < interval.start){
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }   
        }
        res.add(newInterval);
        return res;
    }

}
