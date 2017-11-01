package test;
import java.util.*;

public class TupleTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Tuple> set = new TreeSet<Tuple>((a, b) -> a.orderID -b.orderID);
	}
	static class Tuple {
        int orderID;
        int volume;
        double price;
        public Tuple(int orderID, int volume, double price) {
            this.orderID = orderID;
            this.volume = volume;
            this.price = price;
        }
        public int getOrderID() {
            return orderID;
        }
        public int getVolume() {
            return volume;
        }
        public double getPrice() {
            return price;
        }
        public void setVolume(int volume) {
            this.volume = volume;
        }
    }

}
