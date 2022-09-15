
public class IsBinarySearchTreeTest {

	public static void main(String[] args) {
		/*
		 * Create a tree that satisfies the properties
		 * of a binary search tree, and test it.
		 */
		IsBinarySearchTree.add(20);
		IsBinarySearchTree.add(10);
		IsBinarySearchTree.add(5);
		IsBinarySearchTree.add(30);
		IsBinarySearchTree.add(40);
		IsBinarySearchTree.add(15);
		IsBinarySearchTree.add(45);
		IsBinarySearchTree.add(25);
		System.out.println();
		if (IsBinarySearchTree.isBSTUnknownMinMax()) {
			System.out.print("The tree is a binary search tree");
		}
		else {
			System.out.print("The tree does not satisfy the properties of ");
			System.out.println("a binary search tree.");
		}
		/*
		 * Move the node 25 to the right child of 15
		 * then test if the tree still satisfies the BST property.
		 */
		IsBinarySearchTree.remove(IsBinarySearchTree.find(25));
		IsBinarySearchTree.Node newNode = new IsBinarySearchTree.Node(25);
		IsBinarySearchTree.addChild(IsBinarySearchTree.find(15), newNode);
		System.out.println();
		if (IsBinarySearchTree.isBSTUnknownMinMax()) {
			System.out.print("The tree is a binary search tree");
		}
		else {
			System.out.print("The tree does not satisfy the properties of ");
			System.out.println("a binary search tree.");
		}
	}
}
