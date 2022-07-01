package tree;

public class Q_0559_Maximum_Depth_Of_Nary_Tree {
	public int maxDepth(Node root) {
		// Depth First Search
        if(root == null) return 0;
        if(root.children == null) return 1;
        int depth = 0;
        for(Node child : root.children) {
        	depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }
}
