package dataStruture.tree;

public class AVLTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	// 定义Node节点
	@SuppressWarnings("hiding")
	class TreeNode<T extends Comparable<T>> {
		public T key;
		public TreeNode<T> left;
		public TreeNode<T> right;
		public int height;

		public TreeNode(T key, TreeNode<T> left, TreeNode<T> right, int height) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
			this.height = height;
		}

		@Override
		public String toString() {
			return " key=" + key;
		}
	}

	private TreeNode<T> remove(TreeNode<T> root, T key) {
		// 空，移除返回
		if (root == null)
			return null;
		int compareResult = key.compareTo(root.key);
		if (compareResult < 0)
			root.left = remove(root.left, key);
		else if (compareResult > 0)
			root.right = remove(root.right, key);
		else if (root.left != null && root.right != null) {
			root.key = findMin(root.right).key;
			root.right = remove(root.right, root.key);
		} else
			root = (root.left != null) ? root.left : root.right;
		return blance(root);
	}

	private TreeNode<T> insert(TreeNode<T> root, T key) {

		if (root == null)
			root = new TreeNode<T>(key, null, null, 0);
		int compareResult = key.compareTo(root.key);
		if (compareResult < 0)
			root.left = insert(root.left, key);
		else if (compareResult > 0)
			root.right = insert(root.right, key);
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		return blance(root);
	}

	private static final int ALLOW_HEIGHT = 1;

	private TreeNode<T> blance(TreeNode<T> node) {
		if (node == null)
			return null;
		if (height(node.left) - height(node.right) > ALLOW_HEIGHT) {
			if (height(node.left.left) >= height(node.left.right))
				node = rotateWithLLChild(node);
			else if (height(node.left.left) < height(node.left.right))
				node = rotateWithLRChild(node);
		} else if (height(node.right) - height(node.left) > ALLOW_HEIGHT) {
			if (height(node.right.left) >= height(node.right.right))
				node = rotateWithRLChild(node);
			else if (height(node.right.left) < height(node.right.right))
				node = rotateWithRRChild(node);
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private TreeNode<T> rotateWithLRChild(TreeNode<T> k1) {
		k1.left = rotateWithRRChild(k1.left);
		return rotateWithLLChild(k1);
	}

	private TreeNode<T> rotateWithRLChild(TreeNode<T> k1) {
		k1.right = rotateWithLLChild(k1.right);
		return rotateWithRRChild(k1);
	}

	private TreeNode<T> rotateWithLLChild(TreeNode<T> k1) {
		TreeNode<T> k2 = k1.left;
		k1.left = k2.right;
		k2.right = k1;
		k1.height = Math.max(height(k1.left), height(k2.right)) + 1;
		k2.height = Math.max(height(k2.left), k1.height) + 1;
		return k2;
	}

	private TreeNode<T> rotateWithRRChild(TreeNode<T> k1) {

		TreeNode<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(k1.height, height(k1.right)) + 1;

		return k2;
	}

	public int height() {
		return height(root);
	}

	private int height(TreeNode<T> node) {
		if (node != null)
			return node.height;
		return 0;
	}

	private boolean contains(TreeNode<T> root, T key) {
		if (root == null)
			return false;
		int compareResult = key.compareTo(root.key);

		if (compareResult < 0)
			// 如果小于，比较左节点
			return contains(root.left, key);
		else if (compareResult > 0)
			return contains(root.right, key);
		else
			// 找到，返回
			return true;
	}

	private TreeNode<T> findMin(TreeNode<T> root) {
		if (root == null)
			return null;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private TreeNode<T> findMax(TreeNode<T> root2) {
		if (root == null)
			return null;
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	private void preOrder(TreeNode<T> root) {

		if (root != null) {
			System.out.print(root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private void inOrder(TreeNode<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root);
			inOrder(root.right);
		}
	}

	private void postOrder(TreeNode<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	public void inOrder() {
		inOrder(root);
	}

	public void postOrder() {
		postOrder(root);
	}

	public void insert(T key) {
		root = insert(root, key);
	}

	public void remove(T key) {
		root = remove(root, key);
	}

	public T findMin() {
		TreeNode<T> minNode = findMin(root);
		if (minNode != null)
			return minNode.key;
		return null;
	}

	public T findMax() {
		TreeNode<T> maxNode = findMax(root);
		if (maxNode != null)
			return maxNode.key;
		return null;
	}

	public boolean contains(T key) {
		return contains(root, key);
	}
}
