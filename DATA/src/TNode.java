public class TNode<T extends Comparable>
{
    public T value;
    public TNode<T> left, right;

    public TNode(T val)
    {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}
