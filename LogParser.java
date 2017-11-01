package test;

import java.io.*;
import java.text.*;
import java.util.*;

public class LogParser {
	public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "test3.txt";
        if (args.length > 0) {
        	filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
    	 *  Don't modify this function
    	 */
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();

//        return parseLines(allLines.toArray(new String[allLines.size()]));
        return parseLog(lines);
    }
    public static String parseLog(List<String> lines) {
        long start = 0, end = 0, connected = 0, eventTime = 0;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split("::");
            String left = parts[0].trim();
            String status = parts[1].trim();
            String time = left.substring(1, left.length()-1);
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss"); 
            Date date = new Date();
            try {
                date = format.parse(time);
            }
            catch(ParseException e){
                e.printStackTrace();
            }

            long cur = date.getTime();
            switch(status){
            	case ("START"): start =cur; 
            					break;
            	case ("CONNECTED"): eventTime = cur;
            						break;
            	case ("DISCONNECTED"):connected += cur - eventTime;
            						eventTime = 0;
            						break;
            	case ("SHUTDOWN") : connected += eventTime==0? 0 : cur - eventTime;
            						end = cur;
            						break;
            }

//            if (status.equals("START")) {
//                start = cur;
//            }
//            else if (status.equals("CONNECTED")) {
//                eventTime = cur;
//            }
//            else if (status.equals("DISCONNECTED")) {
//                connected += cur - eventTime;
//                eventTime = 0;
//            }
//            else if (status.equals("SHUTDOWN")) {
//                if (eventTime != 0) {
//                    connected += cur - eventTime;
//                }
//                end = cur;
//            }
        }
        double res = (double)connected / (end - start);
        String result = String.format("%d%s",(int)(res * 100) , "%");

        return result;
    }

//    private static Date convertDate(String dateString) {
//	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
//	    Date date = new Date();
//	    try {
//	      date = df.parse(dateString);
//	    } catch (ParseException ignored) {}
//	    return date;
//	}
//    
//    static String parseLines(String[] lines) {
//    	Map<String, Integer> status = new HashMap<>();
//    	status.put("START", 0);
//        status.put("CONNECTED", 1);
//        status.put("DISCONNECTED", -1);
//        status.put("SHUTDOWN", -1);
//        List<Date> times = new ArrayList<Date>();
//        List<String> events = new ArrayList<String>();
//        for (int i = 0; i < lines.length; i++) {
//	        String[] line = lines[i].split(" :: ");
//	        if(!status.containsKey(line[1])) {
//	        	continue;
//	        }
//	        times.add(convertDate(line[0].substring(1, line[0].length()-1)));
//	        events.add(line[1]);
//        }
//        long totalTime = times.get(times.size()-1).getTime() - times.get(0).getTime();
//        long connectedTime = 0;
//        long lastTimePoint = 0;
//        for (int i=1; i<times.size(); i++) {
//        	String currentEvent = events.get(i);
//        	long currentTime = times.get(i).getTime();
//        	if (status.get(currentEvent) > 0) {
//        		lastTimePoint = currentTime;
//        	} else if (lastTimePoint > 0) {
//	            connectedTime += currentTime - lastTimePoint;
//	            lastTimePoint = -1;
//        	}
//        }
//        double ratio = (double) connectedTime / totalTime * 100;
//        return String.format("%d%s", (int) ratio, "%");
//    }
}
