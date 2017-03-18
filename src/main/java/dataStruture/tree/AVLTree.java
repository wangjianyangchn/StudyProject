package dataStruture.tree;

public class AVLTree<T extends Comparable<T>> {
	private TreeNode<T> root; // 根结点

	@SuppressWarnings("hiding")
	// AVL树的节点(内部类)
	class TreeNode<T extends Comparable<T>> {
		T key; // 关键字(键值)
		int height; // 高度
		TreeNode<T> left; // 左孩子
		TreeNode<T> right; // 右孩子

		public TreeNode(T key, TreeNode<T> left, TreeNode<T> right) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.height = 1;
		}

		@Override
		public String toString() {
			return " key=" + key;
		}
	}

	/**
	 * 递归插入
	 * 
	 * @param root
	 * @param key
	 * @return
	 */
	private TreeNode<T> insert(TreeNode<T> root, T key) {
		if (root == null)
			// 插入，返回
			return new TreeNode<T>(key, null, null);
		int compareResult = key.compareTo(root.key);
		if (compareResult < 0)
			root.left = insert(root.left, key);
		if (compareResult > 0)
			root.right = insert(root.right, key);
		// 插入后平衡节点
		return balance(root);
	}

	private TreeNode<T> remove(TreeNode<T> root, T key) {
		if (root == null)
			return root;
		int compareResult = key.compareTo(root.key);
		if (compareResult < 0)
			// 移除左节点
			root.left = remove(root.left, key);
		else if (compareResult > 0)
			// 移除右节点
			root.right = remove(root.right, key);
		else if (root.left != null && root.right != null) {// 左右节点都不为空
			// 找到右子树下最小节点的值
			root.key = findMin(root.right).key;
			// 移除右子树下最小节点
			root.right = remove(root.right, root.key);
		} else
			// 只有一个节点
			root = (root.left != null) ? root.left : root.right;
		return balance(root);
	}

	public T findMin() {
		return findMin(root).key;
	}

	private TreeNode<T> findMin(TreeNode<T> t) {
		if (t == null)
			return t;
		while (t.left != null)
			t = t.left;
		return t;
	}

	private static final int ALLOWED_MIXBALANCE = 1;

	/**
	 * 平衡节点
	 * 
	 * @param t
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> t) {
		if (t == null)
			return t;
		if (height(t.left) - height(t.right) > ALLOWED_MIXBALANCE) {// 不平衡
			if (height(t.left.left) >= height(t.left.right))// LL
				t = rotateWithLLChild(t);
			else
				// LR
				t = rotateWithLRChild(t);
		} else if (height(t.right) - height(t.left) > ALLOWED_MIXBALANCE) {
			if (height(t.right.right) >= height(t.right.left))// RR
				t = rotateWithRRChild(t);
			else
				// RL
				t = rotateWithRLChild(t);
		}
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		return t;
	}

	private int height(TreeNode<T> tree) {
		if (tree != null)
			return tree.height;
		return 0;
	}

	public int height() {
		return height(root);
	}

	public TreeNode<T> rotateWithLLChild(TreeNode<T> k2) {
		TreeNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;

		return k1;
	}

	public TreeNode<T> rotateWithRRChild(TreeNode<T> k2) {
		TreeNode<T> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max(height(k2.left), height(k2.left)) + 1;
		k1.height = Math.max(k2.height, height(k1.right)) + 1;
		return k1;
	}

	public TreeNode<T> rotateWithLRChild(TreeNode<T> k3) {
		k3.left = rotateWithRRChild(k3.left);
		return rotateWithLLChild(k3);
	}

	public TreeNode<T> rotateWithRLChild(TreeNode<T> k3) {
		k3.right = rotateWithLLChild(k3.right);
		return rotateWithRRChild(k3);
	}

	private void preOrder(TreeNode<T> root) {
		if (root != null) {
			System.out.print(root.toString());
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private void inOrder(TreeNode<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.toString());
			inOrder(root.right);
		}
	}

	private void postOrder(TreeNode<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.toString());
		}

	}

	public void remove(T key) {
		remove(root, key);
	}

	public void insert(T key) {
		root = insert(root, key);
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

}
