package test;

import java.util.*;

public class RandomizedCollection {
	ArrayList<Integer> data;
    HashMap<Integer,HashSet<Integer>> locations;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        data = new ArrayList<>();
        locations = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean present = locations.containsKey(val);
        locations.computeIfAbsent(val,k->new HashSet<>()).add(data.size());
        data.add(val);
        return !present;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!locations.containsKey(val)) return false;
        Iterator<Integer> iter = locations.get(val).iterator();
        int loc = iter.next();
        iter.remove();
        if (loc < data.size() - 1 ) {
            int lastVal = data.get( data.size()-1 );
    	    data.set( loc , lastVal );
    	    locations.get(lastVal).remove( data.size()-1);
    	    locations.get(lastVal).add(loc);
        }
	    data.remove(data.size()-1);
	    if(locations.get(val).isEmpty())
	        locations.remove(val);
	   return true;
        
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return data.get(rand.nextInt(data.size()));
    }
}
