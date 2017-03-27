package dataStruture.tree;

public class BinarySortTreeApp {
	private static int arr[] = { 3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9 };

	public static void main(String[] args) {
		BinarySortTree<Integer> tree = new BinarySortTree<Integer>();

		for (Integer i : arr) {
			tree.insert(i);
		}

		System.out.print("\npreOrder:");
		tree.preOrder();

		System.out.print("\ninOrder:");
		tree.inOrder();

		System.out.print("\npostOrder:");
		tree.postOrder();

		tree.remove(9);

		System.out.print("\ninOrder:");
		tree.inOrder();

		System.out.print("\ncontains:" + tree.contains(15));
		System.out.print("\nmin:" + tree.findMin());
		System.out.print("\nmax:" + tree.findMax());
	}

}
