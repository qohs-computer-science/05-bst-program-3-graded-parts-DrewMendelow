/*
    Drew Mendelow
    2/20/25
    pd 7
    tests the BST class by creating and manipulating it with functions
    made by me
*/

 public class BSTTester {
   public static void main(String[] args) {
      BST tree = new BST();
      tree.add("d");
      tree.add("e");
      tree.add("a");
      tree.add("y");
      tree.add("p");

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();
   }
 }