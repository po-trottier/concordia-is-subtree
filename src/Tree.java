import java.util.ArrayList;

public class Tree {
  private int value;
  private ArrayList<Tree> children;

  Tree(int val) {
    this.value = val;
    this.children = new ArrayList<>();
  }

  public int getValue() {
    return this.value;
  }

  public ArrayList<Tree> getChildren() {
    return this.children;
  }

  public void addChild(Tree child) {
    this.children.add(child);
  }

  public boolean isLeaf() {
    return this.children.size() == 0;
  }

  public boolean hasSubtree(Tree subtree) {
    // The start of the tree matches the start of the subtree
    if (this.value == subtree.value) {
      // Make sure all the children match
      for (int i = 0; i < this.children.size(); i++) {
        // If the child is not a leaf, inspect its children
        if (!subtree.children.get(i).isLeaf())
          return this.children.get(i).hasSubtree(subtree.children.get(i));
        // If the child is a leaf, make sure its value matches the parent's value
        if (this.children.get(i).value != subtree.children.get(i).value)
            return false;
      }
      // Make sure the size of the subtree is the same as the parent tree
      return this.children.size() == subtree.children.size();
      // If the start doesn't match, try to match children trees
    } else if (!this.isLeaf()) {
      // Try to match every child tree
      for (Tree tree : this.children) {
        // If a subtree is found return true
        if (tree.hasSubtree(subtree)) {
          return true;
        }
      }
    }
    // If it's a leaf and it doesn't match, it's not a subtree
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
      for (Tree child: this.children) {
        retVal.append(child.toString());
      }
      return retVal.toString();
    }
  }
}
