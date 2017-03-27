package dataStruture.tree;

import java.util.Stack;

public class BinarySortTree<T extends Comparable<T>> {

	private TreeNode<T> root;

	@SuppressWarnings("hiding")
	// 定义Node节点
	class TreeNode<T extends Comparable<T>> {
		public T key;
		public TreeNode<T> left;
		public TreeNode<T> right;

		public TreeNode(T key, TreeNode<T> left, TreeNode<T> right) {
			super();
			this.key = key;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return " key=" + key;
		}
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

	private T findMin(TreeNode<T> root) {
		if (root == null)
			return null;
		while (root.left != null) {
			root = root.left;
		}
		return root.key;
	}

	private T findMax(TreeNode<T> root2) {
		if (root == null)
			return null;
		while (root.right != null) {
			root = root.right;
		}
		return root.key;
	}

	private TreeNode<T> remove(TreeNode<T> root, T key) {

		if (root == null)
			return null;
		int compareResult = key.compareTo(root.key);
		if (compareResult < 0)
			// 如果小于，移除左节点
			root.left = remove(root.left, key);
		else if (compareResult > 0)
			root.right = remove(root.right, key);
		else
			return null;
		return root;
	}

	private TreeNode<T> insert(TreeNode<T> root, T key) {

		if (root == null)
			return new TreeNode<T>(key, null, null);
		int compareResult = key.compareTo(root.key);
		if (compareResult < 0)
			// 如果小于，插入左节点
			root.left = insert(root.left, key);
		else if (compareResult > 0)
			root.right = insert(root.right, key);
		else
			;
		return root;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(TreeNode<T> root) {

		// if (root != null) {
		// System.out.print(root);
		// preOrder(root.left);
		// preOrder(root.right);
		// }

		Stack<TreeNode<T>> s = new Stack<>();

		while (!s.isEmpty() || root != null) {
			//左子树以此入栈
			while (root != null) {
				//入栈前访问
				System.out.print(root);
				s.push(root);
				root = root.left;
			}
			//退栈，右子树入站
			if (!s.isEmpty()) {
				root = s.pop();
				root = root.right;
			}
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(TreeNode<T> root) {
		// if (root != null) {
		// inOrder(root.left);
		// System.out.print(root);
		// inOrder(root.right);
		// }
		Stack<TreeNode<T>> s = new Stack<>();
		while (!s.isEmpty() || root != null) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			if (!s.isEmpty()) {
				root = s.pop();
				System.out.print(root);
				root = root.right;
			}
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(TreeNode<T> root) {
		// if (root != null) {
		// postOrder(root.left);
		// postOrder(root.right);
		// System.out.print(root);
		// }
		// 后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
		// 若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
		// 若是位于右子树，则直接访问根节点。
		Stack<TreeNode<T>> s = new Stack<>();
		TreeNode<T> curNode = root, lastVisitNode = null;
		while (curNode != null) {
			s.push(curNode);
			curNode = curNode.left;
		}

		while (!s.isEmpty()) {
			curNode = s.pop();
			if (curNode.right != null && curNode.right != lastVisitNode) {
				s.push(curNode);
				curNode = curNode.right;
				while (curNode != null) {
					s.push(curNode);
					curNode = curNode.left;
				}
			} else {
				System.out.print(curNode);
				lastVisitNode = curNode;
			}
		}
	}

	public void insert(T key) {
		root = insert(root, key);
	}

	public void remove(T key) {
		root = remove(root, key);
	}

	public T findMin() {
		return findMin(root);
	}

	public T findMax() {
		return findMax(root);
	}

	public boolean contains(T key) {
		return contains(root, key);
	}
}
