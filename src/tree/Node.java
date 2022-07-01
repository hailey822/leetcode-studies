package tree;

import java.util.List;

public class Node {
	// Variables
	public int val;
	public List<Node> children;
	
	// Contructors
	public Node() {}
	public Node(int _val) {
		this.val = _val;
	}
	public Node(int _val, List<Node> _children) {
		this.val = _val;
		this.children = _children;
	}
}
