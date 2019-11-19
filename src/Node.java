import java.util.ArrayList;

public class Node {
  private int value;
  private ArrayList<Node> children;

  Node(int val) {
    this.value = val;
    this.children = new ArrayList<>();
  }

  public int getValue() {
    return this.value;
  }

  public ArrayList<Node> getChildren() {
    return this.children;
  }

  public void addChild(Node child) {
    this.children.add(child);
  }

  public boolean isLeaf() {
    return this.children.size() == 0;
  }

  public boolean hasSubtree(Node subtree) {
    if (this.value == subtree.value) {
      for (int i = 0; i < this.children.size(); i++) {
        if (!subtree.children.get(i).isLeaf()) {
          return this.children.get(i).hasSubtree(subtree.children.get(i));
        }
        if (this.children.get(i).value != subtree.children.get(i).value)
            return false;
      }
      return this.children.size() == subtree.children.size();
    } else if (!this.isLeaf()) {
      for (Node tree : this.children) {
        if (tree.hasSubtree(subtree)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Transform the tree to a string.
   *
   * @return Will return every element from head to leaf, level by level, from left to right.
   */
  @Override
  public String toString() {
    if (this.isLeaf())
      return Integer.toString(this.value) + " | ";
    else {
      StringBuilder retVal = new StringBuilder(Integer.toString(this.value) + " | ");
      for (Node child: this.children) {
        retVal.append(child.toString());
      }
      return retVal.toString();
    }
  }
}
