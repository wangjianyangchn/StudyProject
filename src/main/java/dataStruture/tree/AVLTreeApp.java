package dataStruture.tree;

public class AVLTreeApp {
	private static int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9 };

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();

		for (Integer i : arr) {
			tree.insert(i);
		}

		System.out.print("\npreOrder:");
		tree.preOrder();

		System.out.print("\ninOrder:");
		tree.inOrder();

		System.out.print("\npostOrder:");
		tree.postOrder();

		tree.remove(13);

		System.out.print("\ninOrder:");
		tree.inOrder();

		System.out.print("\nheight:" + tree.height());
		System.out.print("\ncontains:" + tree.contains(15));
		System.out.print("\nmin:" + tree.findMin());
		System.out.print("\nmax:" + tree.findMax());
	}
}
