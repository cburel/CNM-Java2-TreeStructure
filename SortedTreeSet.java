
public class SortedTreeSet implements SortedTreeSetInterface {

    private SortedTreeSet parent;
    private SortedTreeSet leftChild;
    private SortedTreeSet rightChild;
    private boolean hasValue;
    private Person person;

    public SortedTreeSet() {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
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

        // TODO: implement code to ensure no duplicates
        // if this node is null, add the person to it and set its hasValue flag to true
        if (!hasValue) {
            this.person = p;
            this.hasValue = true;
            return;
        }

        // otherwise, check where to put the person
        int i = this.person.compareTo(p);

        // TODO: test to make sure this is sorting correctly
        // TODO: implement code to ensure no duplicates
        // if this.person < p
        if (i == -1) {
            if (leftChild == null) {
                leftChild = new SortedTreeSet();
                leftChild.parent = this;
            }
            leftChild.add(p);
        }

        // if this.person == p or this.person > p
        else {
            if (rightChild == null) {
                rightChild = new SortedTreeSet();
                rightChild.parent = this;
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
        traverseTree(this.parent, output);

        return output.toString();
    }

    private void traverseTree(SortedTreeSet tree, StringBuilder builder) {
        if (tree == null) {
            return;
        }

        traverseTree(tree.getLeft(), builder);
        builder.append(tree.getPerson().toString()).append(" ");
        traverseTree(tree.getRight(), builder);
    }
}