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
    Node tree = createDemoTree();
    Node subtree = createDemoSubtree();
    Node notSubtree = createDemoNotSubtree();

    // Make sure the tree corresponds to the Demo Tree
    printTrees(tree, subtree, notSubtree);

    // Run the algorithm
    runTest(tree, subtree, true);
    runTest(tree, notSubtree, false);
  }

  private static Node createDemoTree() {
    Node head, n1, n2, n3, n4, n5, n6, n7, n8, n9;

    head = new Node(1);
    n1 = new Node(4);
    n2 = new Node(7);
    n3 = new Node(2);
    n4 = new Node(6);
    n5 = new Node(8);
    n6 = new Node(9);
    n7 = new Node(3);
    n8 = new Node(5);
    n9 = new Node(0);

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

  private static Node createDemoSubtree() {
    Node head, n1, n2;

    head = new Node(7);
    n1 = new Node(9);
    n2 = new Node(3);

    head.addChild(n1);
    head.addChild(n2);

    return head;
  }

  private static Node createDemoNotSubtree() {
    Node head, n1, n2;

    head = new Node(1);
    n1 = new Node(8);
    n2 = new Node(9);

    head.addChild(n1);
    head.addChild(n2);

    return head;
  }

  private static void printTrees(Node tree, Node subtree, Node notSubtree) {
    System.out.println("Tree:");
    System.out.println(tree.toString());
    System.out.println("Subtree:");
    System.out.println(subtree.toString());
    System.out.println("Not Subtree:");
    System.out.println(notSubtree.toString());
  }

  private static void runTest(Node bigTree, Node smallTree, boolean expected) {
    System.out.println("");
    System.out.println("Expected: " + expected);
    System.out.println("Actual: " + bigTree.hasSubtree(smallTree));
  }
}
