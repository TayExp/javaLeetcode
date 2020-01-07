package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class S_399_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map <String, Map<String, Double>> map = new HashMap<>();
        List<String> e = null;
        Map<String, Double> m = null;
        for(int i = 0; i < values.length; i++){
            e = equations.get(i);
            m = map.getOrDefault(e.get(0), new HashMap<>());
            m.put(e.get(1), values[i]);
            map.put(e.get(0), m);
            m = map.getOrDefault(e.get(1), new HashMap<>());
            if(Math.abs(values[i]) < 1e-5)
                m.put(e.get(0), -2.0); // division by zero
            else
                m.put(e.get(0), 1/values[i]);
            map.put(e.get(1), m);
        }
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            e = queries.get(i);
            result[i] = dfs(e.get(0), e.get(1), map, new HashSet<String>() ,1.0);
        }
        return result;
    }
    
    private double dfs(String A, String B, Map<String, Map<String, Double>> map, HashSet<String> set, double value) {
    	if(set.contains(A)) return -1.0;
    	if(!map.containsKey(A)) return -1.0;
    	if(A.equals(B)) return value;
    	set.add(A);
    	double tmp = -1;
    	Map<String, Double> m = map.get(A);
    	for(Entry entry : m.entrySet()) {
    		String s = (String) entry.getKey();
    		double v = (double) entry.getValue();
    		tmp = dfs(s, B, map, set, value * v);
    		if(tmp != -1.0)
    			break;
    	}
    	set.remove(A);
    	return tmp;
    }
    
    public static void main(String[] args) {
    	
		List<List<String>> equations = new ArrayList<>();
		List<String> query3 = new ArrayList<>();
		query3.add("a"); query3.add("b"); 
		List<String> query4 = new ArrayList<>();
		query4.add("b"); query4.add("c"); 
		equations.add(query3);
		equations.add(query4);
		
		double[] values = new double[] {2.0, 3.0};
		List<List<String>> queries = new ArrayList<>();
		
		List<String> query = new ArrayList<>();
		query.add("a"); query.add("c"); 
		List<String> query1 = new ArrayList<>();
		query1.add("b"); query1.add("a"); 
		queries.add(query);
		queries.add(query1);
		System.out.println(new S_399_EvaluateDivision().calcEquation(equations, values, queries));
		System.out.println();
	}
}
