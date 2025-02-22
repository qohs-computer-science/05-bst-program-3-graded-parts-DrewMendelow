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
      tree.add("O");
      tree.add("R");
      tree.add("C");
      tree.add("H");
      tree.add("A");
      tree.add("R");
      tree.add("D");

      tree.add("Q");
      tree.add("U");
      tree.add("I");
      tree.add("N");
      tree.add("C");
      tree.add("E");

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      // System.out.println(tree.find("P")); 
      // System.out.println(tree.find("A")); 
      // System.out.println(tree.find("E")); 
      // System.out.println(tree.find("o")); 
      // System.out.println(tree.find("Y")); 

      tree.delete("H");
      tree.delete("Q");

      System.out.println();
      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();
   }
 }