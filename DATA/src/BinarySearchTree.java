public class BinarySearchTree<T extends Comparable> {
    private TNode<T> root;

    public void insert(T val)
    {
        TNode<T> newNode = new TNode<>(val);
        if (root == null)
        {
            root = newNode;
        }
        else
        {
            TNode<T> iterator = root;
            while (iterator != null)
            {
                if (iterator.value.compareTo(val) == 1)
                {
                    if (iterator.left != null)
                    {
                        iterator = iterator.left;
                    }
                    else
                    {
                        iterator.left = newNode;
                        return;
                    }
                }
                else if (iterator.value.compareTo(val) == -1)
                {
                    if (iterator.right != null) {
                        iterator = iterator.right;
                    }
                    else {
                        iterator.right = newNode;
                        return;
                    }
                } else {
                    System.out.println("duplicate value");
                    return;
                }

            }
        }
    }

    public void inOrder()
    {
        inOrder(root);
    }


    public void inOrder(TNode<T> root)
    {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root);
            inOrder(root.right);
        }
    }


    public boolean search(T val)
    {
        return search(root, val);
    }


    public boolean search(TNode<T> tempRoot, T val)
    {
        if(tempRoot == null)
        {
            return false;
        }
        else if (val.compareTo(tempRoot.value)==-1)
            return search(tempRoot.left, val);
        else if (val.compareTo(tempRoot.value)==1)
            return search(tempRoot.right, val);
        else
            return true;
    }
    public TNode<T> findNode(T val)
    {
        return findNode(root, val);
    }
    public TNode<T> findNode(TNode<T> tempRoot, T val)
    {
        if(tempRoot== null)
            return null;
        else if (val.compareTo(tempRoot.value)==-1)
            return findNode(tempRoot.left, val);
        else if (val.compareTo(tempRoot.value)==1)
            return findNode(tempRoot.right, val);
        else
            return tempRoot;
    }
    public TNode<T> findParent(T val)
    {
        if (search(val) == false || root.value.compareTo(val) == 0)
        {
            return null;
        }
        else
        {
            TNode<T> parent = root, iterator = root;
            while (iterator.value.compareTo(val) != 0)
            {
                parent = iterator;
                if (val.compareTo(iterator.value) == -1)
                    iterator = iterator.left;
                else
                    iterator = iterator.right;
            }
            return parent;
        }
    }
    public TNode<T> inorderSuccessor(T val)
    {
        TNode<T> current=findNode(val);
        if(current==null)
            return null;
        else if(current.right!=null)
        {
            TNode<T> iterator=current.right;
            while(iterator.left!=null)
                iterator=iterator.left;
            return iterator;
        }
        else if(current==root && root.right==null)
            return null;
        else if(current.right==null)
        {
            TNode<T> parent=findParent(val);
            if(parent.left==current)
                return parent;
            else{
                TNode<T> grandParent=findParent(parent.value);
                while(grandParent!=null &&grandParent.left!=parent)
                {
                    parent=grandParent;
                    grandParent=findParent(parent.value);
                }
                if(grandParent==null)
                    return null;
                return grandParent;
            }
        }
        return null;
    }
    public boolean isLeaf(T val){
        TNode<T> current=findNode(val);
        return (current.left==null && current.right==null);

    }
    public void delete( T val){
        if (isLeaf(val)){
            TNode<T> parent =findParent(val);
            if(parent.left.value.compareTo(val)==0)
                parent.left=null;
            else parent.right=null;

        }
        else
        {
            TNode<T> current=findNode(val);
            TNode<T> parent=findParent(val);
            if(current.left==null && current.right!=null)
            {
                if(parent.left==current)
                    parent.left=current.right;
                else
                    parent.right=current.right;
            }else if (current.right==null && current.left!=null)
            {
                if(parent.left==current)
                    parent.left=current.left;
                else
                    parent.right=current.left;
            }else{//means it has two children
                TNode<T> inorder=inorderSuccessor(val);
                delete(inorder.value);
                current.value=inorder.value;

            }
        }
    }
}
