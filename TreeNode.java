
public class TreeNode<T> {
	T data;
	TreeNode<T> left, right;
	
	public TreeNode(T dataNode) {
		this.data = dataNode;
		this.left = this.right = null;
	}
	
	public TreeNode(TreeNode<T> node) {
		if(node == null) {
			throw new IllegalArgumentException("Invalid Node State: NULL");
		}
		
		this.data = node.data;
		
		if(node.left != null) {
			this.left = new TreeNode<>(node.left);
		}
		
		if(node.right != null	) {
			this.right = new TreeNode<>(node.right);
		}
	}
	
	public T getData() {
		return this.data;
	}
	
}
