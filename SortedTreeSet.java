
public class SortedTreeSet implements SortedTreeSetInterface {

    private SortedTreeSet parent;
    private SortedTreeSet leftChild;
    private SortedTreeSet rightChild;
    private Person person;
    private boolean hasValue;

    public SortedTreeSet() {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.person = null;
        this.hasValue = false;
    }

    public Person getPerson() {
        return this.person;
    }

    public boolean hasLeft() {
        return this.leftChild != null;
    }

    public void setLeft(SortedTreeSet left) {
        this.leftChild = left;
    }

    public SortedTreeSet getLeft() {
        return this.leftChild;
    }

    public boolean hasRight() {
        return this.rightChild != null;
    }

    public void setRight(SortedTreeSet right) {
        this.rightChild = right;
    }

    public SortedTreeSet getRight() {
        return this.rightChild;
    }

    public SortedTreeSet getParent() {
        return this.parent;
    }

    public void setParent(SortedTreeSet parent) {
        this.parent = parent;
    }

    public boolean getHasValue() {
        return this.hasValue;
    }

    public void add(Person p) {

        // if this node is null, add the person to it and set its hasValue flag to true
        if (!hasValue) {
            this.person = p;
            this.hasValue = true;
            return;
        }

        // otherwise, check where to put the person
        int i = this.getPerson().compareTo(p);

        // TODO: test to make sure this is sorting correctly

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
                System.out.println("Adding " + p.getName() + " to the left of " + this.getPerson());
            }
            leftChild.add(p);
        }

        // if p is lesser, put it in the right branch
        else {
            if (rightChild == null) {
                rightChild = new SortedTreeSet();
                rightChild.setParent(this);
                System.out.println("Adding " + p.getName() + " to the right of " + this.getPerson());
            }
            rightChild.add(p);
        }
    }

    public void clearSelf() {
        this.setParent(null);
        this.setLeft(null);
        this.setRight(null);
        this.person = null;
        this.hasValue = false;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        traverseTree(this, output);

        return output.toString();
    }

    private void traverseTree(SortedTreeSet tree, StringBuilder builder) {

        // TODO: ensure this doesn't stop traversal prematurely
        if (tree == null) {
            return;
        }

        traverseTree(tree.getLeft(), builder);
        builder.append(tree.getPerson().toString()).append(" \n");
        traverseTree(tree.getRight(), builder);
    }
}