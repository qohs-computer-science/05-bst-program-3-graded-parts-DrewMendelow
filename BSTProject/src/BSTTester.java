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

      tree.add("M");
      tree.add("T");
      tree.add("S");
      tree.add("Z");

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      System.out.println();
      System.out.println("P found: " + tree.find("P")); 
      System.out.println("A found: " + tree.find("A")); 
      System.out.println("E found: " + tree.find("E")); 
      System.out.println("o found: " + tree.find("o")); 
      System.out.println("O found: " + tree.find("O")); 
      System.out.println("Y found: " + tree.find("Y")); 

      tree.delete("Q");
      tree.delete("Z");

      System.out.println();
      System.out.println("Q and Z deleted. (Leaves)");
      System.out.println();

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      tree.delete("T");
      tree.delete("I");
      tree.delete("D");
      tree.delete("N");

      System.out.println();
      System.out.println("T, I, D, and N deleted. (1 Child Cases)");
      System.out.println();

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      tree.delete("H");

      System.out.println();
      System.out.println("H deleted. (2 Child Case)");
      System.out.println();

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      tree.delete("O");

      System.out.println();
      System.out.println("O deleted. (Root Case)");
      System.out.println();

      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      System.out.println();
      System.out.println("M replaced with K.");
      tree.replace("M", "K");

      System.out.println();
      tree.printPreOrder();
      tree.printInOrder();
      tree.printPostOrder();

      System.out.println();
      System.out.println("Size: " + tree.size());
      System.out.println("Is Empty: " + tree.isEmpty());

      System.out.println();
      System.out.println("Delete everything.");
      tree.delete("C");
      tree.delete("A");
      tree.delete("K");
      tree.delete("R");
      tree.delete("S");
      tree.delete("U");
      tree.delete("R");
      tree.delete("E");
      tree.delete("C");
      
      System.out.println();
      System.out.println("Size: " + tree.size());
      System.out.println("Is Empty: " + tree.isEmpty());
   }//end main
 }//end class