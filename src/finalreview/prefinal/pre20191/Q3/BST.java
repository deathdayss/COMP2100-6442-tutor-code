package finalreview.prefinal.pre20191.Q3;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * @author huy.pham
 */
public class BST {	
	Node root;

	/**
	 * Node class
	 */
	public class Node {
		String value;
		Node parent;
		Node left;
		Node right;

		public Node(String value) {
			this.value = value;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		private int compareStrings(String a, String b) {
			int commonLength = Math.min(a.length(), b.length());
			for (int i = 0; i < commonLength; ++i) {
				if (a.charAt(i) < b.charAt(i)) {
					return -1;
				}
				else if (a.charAt(i) > b.charAt(i)) {
					return 1;
				}
			}
			if (a.length() == b.length()) {
				return 0;
			}
			else if (a.length() < b.length()) {
				return -1;
			}
			else {
				return 1;
			}
		}

		/**
		 * @param s
		 * @return the node that has the given value.
		 */
	    public Node find(String s) {
			// TODO: Add your implementation here.

	        return null;
	    }

		/**
		 * Insert a new node into the tree
		 * @param s
		 * @return {@link Node}
		 */
		public Node insert(String s) {
			// TODO: Add your implementation here.

			return this;
		}
		
		/**
		 * @return pre-order traversal of the nodes that have odd number of children.
		 */
		public String printOddNodes() {
			// TODO: Add your implementation here.

			return null;
		}

		private boolean isOddNodes() {
			if (left == null && right != null || left != null && right == null) {
				return  true;
			}
			return false;
		}
	}

	public String printOddNodes() {
		return root.printOddNodes();
	}
	
	public BST() {
		root = null;
	}

	public Node insert(String value) {
		if (root == null) {
			root = new Node(value);
			return root;
		}

		return root.insert(value);
	}
	
	public Node find(String s) {
		if (root == null) {
			return null;
		}
		
		return root.find(s);
	}
}