import java.lang.Comparable;

public class BST implements BSTInterface
{
    private TreeNode root;

    public BST(){
        root = null;
    }

    public void add(Comparable val){
        if (root == null){
            root = new TreeNode(val);
        }
        else{
            if (val.compareTo(root.getValue()) <= 0){
                if (root.getLeft() == null){
                    root.setLeft(new TreeNode(val));
                }
                else{
                    addHelper(val,root.getLeft());
                }
            }
            else{
                if (root.getRight() == null){
                    root.setRight(new TreeNode(val));
                }
                else{
                    addHelper(val,root.getRight());
                }
            }
        }
    }

    private void addHelper(Comparable value, TreeNode subroot){
        if (value.compareTo(subroot.getValue()) <= 0){
            if (subroot.getLeft() == null){
                subroot.setLeft(new TreeNode(value));
            }
            else{
                addHelper(value, subroot.getLeft());
            }
        }
        else{
            if (subroot.getRight() == null){
                subroot.setRight(new TreeNode(value));
            }
            else{
                addHelper(value, subroot.getRight());
            }
        }
    }

	public boolean find(Comparable value){
        if (root == null){
            return false;
        }
        else{
            if (value.compareTo(root.getValue()) == 0){
                return true;
            }
            else{
                if (value.compareTo(root.getValue()) <= 0){
                    return findHelper(value, root.getLeft());
                }
                else{
                    return findHelper(value, root.getRight());
                }
            }
        }
    }

    private boolean findHelper(Comparable value, TreeNode subroot){
        if (subroot == null){
            return false;
        }
        else{
            if (value.compareTo(subroot.getValue()) == 0){
                return true;
            }
            else{
                if (value.compareTo(subroot.getValue()) <= 0){
                    return findHelper(value, subroot.getLeft());
                }
                else{
                    return findHelper(value, subroot.getRight());
                }
            }
        }
    }

	public boolean delete(Comparable value){
        if (root == null){
            return false;
        }
        else{
            if (value.compareTo(root.getValue()) == 0){
                deleteRoot(root);
                return true;
            }
            else{
                if (value.compareTo(root.getValue()) <= 0){
                    if (root.getLeft() == null){
                        return false;
                    }
                    else{
                        if (value.compareTo(root.getLeft().getValue()) == 0){
                            handleDelete(root, root.getLeft(), true);
                            return true;
                        }
                        else{
                            return deleteHelper(value, root.getLeft());
                        }
                    }
                }
                else{
                    if (root.getLeft() == null){
                        return false;
                    }
                    else{
                        if (value.compareTo(root.getLeft().getValue()) == 0){
                            handleDelete(root, root.getLeft(), true);
                            return true;
                        }
                        else{
                            return deleteHelper(value, root.getLeft());
                        }
                    }
                }
            }
        }
    }

    public void printInOrder(){
        if (root != null){
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderHelper(root.getRight());
            System.out.println();
        }
    }

    public void inOrderHelper(TreeNode subroot){
        if (subroot != null){
            inOrderHelper(subroot.getLeft());
            System.out.print(subroot.getValue() + " ");
            inOrderHelper(subroot.getRight());
        }
    }

	public void printPreOrder(){
        if (root != null){
            System.out.print(root.getValue() + " ");
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
            System.out.println();
        }
    }

    public void preOrderHelper(TreeNode subroot){
        if (subroot != null){
            System.out.print(subroot.getValue() + " ");
            preOrderHelper(subroot.getLeft());
            preOrderHelper(subroot.getRight());
        }
    }

	public void printPostOrder(){
        if (root != null){
            postOrderHelper(root.getLeft());
            postOrderHelper(root.getRight());
            System.out.print(root.getValue() + " ");
            System.out.println();
        }
    }

    public void postOrderHelper(TreeNode subroot){
        if (subroot != null){
            postOrderHelper(subroot.getLeft());
            postOrderHelper(subroot.getRight());
            System.out.print(subroot.getValue() + " ");
        }
    }
}