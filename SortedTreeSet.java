
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

    public void setHasValue(boolean value) {
        this.hasValue = value;
    }

    public void add(Person p) {

    }

    public void clearSelf() {
        this.parent = null;
        this.setLeft(null);
        this.setRight(null);
        this.person = null;
        this.hasValue = false;
    }

    @Override
    public String toString() {
        return ""; // TODO: placeholder
    }
}