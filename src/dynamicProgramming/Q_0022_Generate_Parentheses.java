package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Q_0022_Generate_Parentheses {
	List<String> res = new ArrayList<String>();
	
	private void generate(String curr, int l, int r ) {
		// End case : only right one to add
		if(l == 0) {
			for(int i=0; i<r; i++) {
				curr += ')';
			}
			res.add(curr);
			return;
		}
		// Only one pair left to add
		if(l==1 && r==1) {
			curr += "()";
			res.add(curr);
			return;
		}
		// Append ')'
		if(l<=r-1) {
			generate(curr+')', l, r-1);
		}
		// Append '('
		generate(curr+'(', l-1, r);
	}
	
	public List<String> generateParenthesis(int n) {
		// Handle edge case 
		if(n==0) return res;
		if(n==1) {
			res.add("()");
			return res;
		}
		
		generate("", n, n);
		return res;
    }
}
