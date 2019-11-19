public class Main {

  //////////////////////////////////////////////////////////////////////
  // NOTE: This algorithm assumes that all the nodes have unique values
  //
  // DEMO TREE:
  //
  //              1
  //      4               7
  //  2   6   8        9     3
  //                       5   0
  //
  // DEMO SUBTREE:
  //
  //     7
  //  9     3
  //
  // DEMO NOT SUBTREE:
  //
  //     1
  //  8     9
  //
  //////////////////////////////////////////////////////////////////////

  public static void main(String[] args) {
    // Initialize a Demo Tree to test the algorithm
    Tree tree = createDemoTree();
    Tree subtree = createDemoSubtree();
    Tree notSubtree = createDemoNotSubtree();

    // Make sure the tree corresponds to the Demo Tree
    printTrees(tree, subtree, notSubtree);

    // Run the algorithm
    runTest(tree, subtree, true);
    runTest(tree, notSubtree, false);
  }

  private static Tree createDemoTree() {
    Tree head, n1, n2, n3, n4, n5, n6, n7, n8, n9;

    head = new Tree(1);
    n1 = new Tree(4);
    n2 = new Tree(7);
    n3 = new Tree(2);
    n4 = new Tree(6);
    n5 = new Tree(8);
    n6 = new Tree(9);
    n7 = new Tree(3);
    n8 = new Tree(5);
    n9 = new Tree(0);

    n7.addChild(n8);
    n7.addChild(n9);

    n2.addChild(n6);
    n2.addChild(n7);

    n1.addChild(n3);
    n1.addChild(n4);
    n1.addChild(n5);

    head.addChild(n1);
    head.addChild(n2);

    return head;
  }

  private static Tree createDemoSubtree() {
    Tree head, n1, n2;

    head = new Tree(7);
    n1 = new Tree(9);
    n2 = new Tree(3);

    head.addChild(n1);
    head.addChild(n2);

    return head;
  }

  private static Tree createDemoNotSubtree() {
    Tree head, n1, n2, n3, n4;

    head = new Tree(7);
    n1 = new Tree(9);
    n2 = new Tree(3);
    n3 = new Tree(5);
    n4 = new Tree(4);

    n2.addChild(n3);
    n2.addChild(n4);

    head.addChild(n1);
    head.addChild(n2);

    return head;
  }

  private static void printTrees(Tree tree, Tree subtree, Tree notSubtree) {
    System.out.println("Tree:");
    System.out.println(tree.toString());
    System.out.println("Subtree:");
    System.out.println(subtree.toString());
    System.out.println("Not Subtree:");
    System.out.println(notSubtree.toString());
  }

  private static void runTest(Tree bigTree, Tree smallTree, boolean expected) {
    boolean result = bigTree.hasSubtree(smallTree);
    System.out.println("");
    System.out.println("Expected: " + expected);
    System.out.println("Actual: " + result);
    System.out.println((result == expected) ? "RESULTS MATCH!" : "ERROR... ACTUAL DOES NOT MATCH EXPECTED.");
  }
}
