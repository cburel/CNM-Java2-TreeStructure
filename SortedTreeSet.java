/**
 * The Sorted Tree Set class. Takes given values and inserts them into a tree,
 * sorted alphabetically. Note that this is a "tree of trees", so each tree can
 * also be thought of as a node.
 */
public class SortedTreeSet implements SortedTreeSetInterface {

    private SortedTreeSet parent;
    private SortedTreeSet leftChild;
    private SortedTreeSet rightChild;
    private Person person;
    private boolean hasValue;

    /**
     * Constructor. Sets the current node's parent, children, person data to none.
     * Sets hasValue flag to false.
     */
    public SortedTreeSet() {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.person = null;
        this.hasValue = false;
    }

    /**
     * Fetches this node's person data
     * 
     * @return The person data contained in this node
     */
    public Person getPerson() {
        return this.person;
    }

    /**
     * Checks whether this node has a left child
     * 
     * @return True if there is a left child, false otherwise
     */
    public boolean hasLeft() {
        return this.leftChild != null;
    }

    /**
     * Sets this node's left child
     * 
     * @param left The left child node
     */
    public void setLeft(SortedTreeSet left) {
        this.leftChild = left;
    }

    /**
     * Fetches this node's left child
     * 
     * @return This node's left child
     */
    public SortedTreeSet getLeft() {
        return this.leftChild;
    }

    /**
     * Checks whether this node has a right child
     * 
     * @return True if there is a right child, false otherwise
     */
    public boolean hasRight() {
        return this.rightChild != null;
    }

    /**
     * Sets this node's right child
     * 
     * @param right This node's right child
     */
    public void setRight(SortedTreeSet right) {
        this.rightChild = right;
    }

    /**
     * Fetches this node's right child
     * 
     * @return This node's right child
     */
    public SortedTreeSet getRight() {
        return this.rightChild;
    }

    /**
     * Fetches this node's parent node
     * 
     * @return This node's parent
     */
    public SortedTreeSet getParent() {
        return this.parent;
    }

    /**
     * Sets this node's parent
     * 
     * @param parent This node's parent
     */
    public void setParent(SortedTreeSet parent) {
        this.parent = parent;
    }

    /**
     * Fetches whether this node has a value or is null
     * 
     * @return True if there is a value, false otherwise
     */
    public boolean getHasValue() {
        return this.hasValue;
    }

    /**
     * Adds a given person to the tree
     * 
     * @param p The person to add to the tree
     */
    public void add(Person p) {

        // if this node is null, add the person to it and set its hasValue flag to true
        if (!hasValue) {
            this.person = p;
            this.hasValue = true;
            return;
        }

        // otherwise, check where to put the person
        int i = this.getPerson().compareTo(p);

        // since this tree is sorted, duplicates will always try to go to the same spot.
        // therefore, if i == 0, this.person is a duplicate. the dupe will overwrite the
        // data in the current spot, but since it is the same data, we end up without
        // duplicate data.
        if (i == 0) {
            return;
        }

        // if p is greater, put it in the left branch
        if (i > 0) {
            if (leftChild == null) {
                leftChild = new SortedTreeSet();
                leftChild.setParent(this);

                // DEBUG: ensure child was added in the correct spot
                System.out.println("Adding " + p.getName() + " to the left of " + this.getPerson());
            }
            leftChild.add(p);
        }

        // if p is lesser, put it in the right branch
        else {
            if (rightChild == null) {
                rightChild = new SortedTreeSet();
                rightChild.setParent(this);

                // DEBUG: ensure child was added in the correct spot
                System.out.println("Adding " + p.getName() + " to the right of " + this.getPerson());
            }
            rightChild.add(p);
        }
    }

    /**
     * Empties this node by setting attached nodes to null and hasValue to false
     */
    public void clearSelf() {
        this.setParent(null);
        this.setLeft(null);
        this.setRight(null);
        this.person = null;
        this.hasValue = false;
    }

    /**
     * Traverses the entire binary tree and adds each value to a string builder
     * 
     * @return The string created by traversing the entire binary tree
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        traverseTree(this, output);

        return output.toString();
    }

    /**
     * Traverses the entire binary tree and adds each value to the string builder
     * for toString output. Stops when the tree reaches its end
     * 
     * @param tree    The current node
     * @param builder The string builder to add the node's value to
     */
    private void traverseTree(SortedTreeSet tree, StringBuilder builder) {

        if (tree == null) {
            return;
        }

        traverseTree(tree.getLeft(), builder);
        builder.append(tree.getPerson().toString()).append(" \n");
        traverseTree(tree.getRight(), builder);
    }
}