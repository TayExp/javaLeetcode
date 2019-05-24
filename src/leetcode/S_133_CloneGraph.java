package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class S_133_CloneGraph {
 
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	private HashMap<Integer, Node> map = new HashMap<>();
	
	// 深度优先遍历
	public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<Node>()) );
        dfs(node, map);
        return map.get(node);
	}
	
	public void dfs(Node node, HashMap<Node, Node> map ){
		for(Node neighbor : node.neighbors){
			if(!map.containsKey(neighbor)){
				map.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
				dfs(neighbor, map);
			}
	        map.get(node).neighbors.add(map.get(neighbor));
		}
	}
}
