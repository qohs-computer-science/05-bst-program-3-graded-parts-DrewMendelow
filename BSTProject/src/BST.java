/*
    Drew Mendelow
    2/20/25
    pd 7
    BST class creating and managing a Binary Search Tree
*/

public class BST implements BSTInterface
{
    private TreeNode root;

    public BST(){
        root = null;
    }//end BST

    public void add(Comparable val){
        if (root == null){
            root = new TreeNode(val);
        }//end if
        else{
            if (val.compareTo(root.getValue()) <= 0){
                if (root.getLeft() == null){
                    root.setLeft(new TreeNode(val));
                }//end if
                else{
                    addHelper(val,root.getLeft());
                }//end else
            }//end if
            else{
                if (root.getRight() == null){
                    root.setRight(new TreeNode(val));
                }//end if
                else{
                    addHelper(val,root.getRight());
                }//end else
            }//end else
        }//end else
    }//end add

    private void addHelper(Comparable value, TreeNode subroot){
        if (value.compareTo(subroot.getValue()) <= 0){
            if (subroot.getLeft() == null){
                subroot.setLeft(new TreeNode(value));
            }//end if
            else{
                addHelper(value, subroot.getLeft());
            }//end else
        }//end if
        else{
            if (subroot.getRight() == null){
                subroot.setRight(new TreeNode(value));
            }//end if
            else{
                addHelper(value, subroot.getRight());
            }//end else
        }//end else
    }//end addHelper

	public boolean find(Comparable value){
        if (root == null){
            return false;
        }//end if
        else{
            if (value.compareTo(root.getValue()) == 0){
                return true;
            }//end if
            else{
                if (value.compareTo(root.getValue()) <= 0){
                    return findHelper(value, root.getLeft());
                }//end if
                else{
                    return findHelper(value, root.getRight());
                }//end else
            }//end else
        }//end else
    }//end find

    private boolean findHelper(Comparable value, TreeNode subroot){
        if (subroot == null){
            return false;
        }//end if
        else{
            if (value.compareTo(subroot.getValue()) == 0){
                return true;
            }//end if
            else{
                if (value.compareTo(subroot.getValue()) <= 0){
                    return findHelper(value, subroot.getLeft());
                }//end if
                else{
                    return findHelper(value, subroot.getRight());
                }//end else
            }//end else
        }//end else
    }//end findHelper

	public boolean delete(Comparable value){
        if (root == null){
            return false;
        }//end if
        else{
            if (value.compareTo(root.getValue()) == 0){
                deleteRoot();
                return true;
            }//end if
            else{
                if (value.compareTo(root.getValue()) <= 0){
                    if (root.getLeft() == null){
                        return false;
                    }//end if
                    else{
                        if (value.compareTo(root.getLeft().getValue()) == 0){
                            handleDelete(root, root.getLeft(), true);
                            return true;
                        }//end if
                        else{
                            return deleteHelper(value, root.getLeft());
                        }//end else
                    }//end else
                }//end if
                else{
                    if (root.getRight() == null){
                        return false;
                    }//end if
                    else{
                        if (value.compareTo(root.getRight().getValue()) == 0){
                            handleDelete(root, root.getRight(), false);
                            return true;
                        }//end if
                        else{
                            return deleteHelper(value, root.getRight());
                        }//end else
                    }//end else
                }//end else
            }//end else
        }//end else
    }//end delete

    private boolean deleteHelper(Comparable value, TreeNode subroot){
        if (value.compareTo(subroot.getValue()) <= 0){
            if (subroot.getLeft() == null){
                return false;
            }//end if
            else{
                if (value.compareTo(subroot.getLeft().getValue()) == 0){
                    handleDelete(subroot, subroot.getLeft(), true);
                    return true;
                }//end if
                else{
                    return deleteHelper(value, subroot.getLeft());
                }//end else
            }//end else
        }//end if
        else{
            if (subroot.getRight() == null){
                return false;
            }//end if
            else{
                if (value.compareTo(subroot.getRight().getValue()) == 0){
                    handleDelete(subroot, subroot.getRight(), false);
                    return true;
                }//end if
                else{
                    return deleteHelper(value, subroot.getRight());
                }//end else
            }//end else
        }//end else
    }//end deleteHelper

    private void handleDelete(TreeNode parent, TreeNode child, boolean isLeft){
        if (child.getLeft() == null){
            if (child.getRight() == null){
                if (isLeft){
                    parent.setLeft(null);
                }//end if
                else{
                    parent.setRight(null);
                }//end else
            }//end if
            else{
                if (isLeft){
                    parent.setLeft(child.getRight());
                    child.setRight(null);
                }//end if
                else{
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }//end else
            }//end else
        }//end if
        else{
            if (child.getRight() == null){
                if (isLeft){
                    parent.setLeft(child.getLeft());
                    child.setLeft(null);
                }//end if
                else{
                    parent.setRight(child.getLeft());
                    child.setLeft(null);
                }//end else
            }//end if
            else{
                TreeNode temp = child.getLeft();
                while (temp.getRight() != null){
                    temp = temp.getRight();
                }//end while
                temp.setRight(child.getRight());
                if (isLeft){
                    parent.setLeft(child.getLeft());
                }//end if
                else{
                    parent.setRight(child.getLeft());
                }//end else
                child.setLeft(null);
                child.setRight(null);
            }//end else
        }//end else
    }//end handleDelete

    private void deleteRoot(){
        if (root.getLeft() == null){
            if (root.getRight() == null){
                root = null;
            }//end if
            else{
                root = root.getRight();
            }//end else
        }//end if
        else{
            if (root.getRight() == null){
                root = root.getLeft();
            }//end if
            else{
                TreeNode temp = root.getLeft();
                while (temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(root.getRight());

                root = root.getLeft();
            }//end else
        }//end else
    }//end deleteRoot

    public void printInOrder(){
        System.out.println("In order:");
        if (root != null){
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderHelper(root.getRight());
            System.out.println();
        }//end if
    }//end printInOrder

    private void inOrderHelper(TreeNode subroot){
        if (subroot != null){
            inOrderHelper(subroot.getLeft());
            System.out.print(subroot.getValue() + " ");
            inOrderHelper(subroot.getRight());
        }//end if
    }//end inOrderHelper

	public void printPreOrder(){
        System.out.println("Pre order:");
        if (root != null){
            System.out.print(root.getValue() + " ");
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
            System.out.println();
        }//end if
    }//end printPreOrder

    private void preOrderHelper(TreeNode subroot){
        if (subroot != null){
            System.out.print(subroot.getValue() + " ");
            preOrderHelper(subroot.getLeft());
            preOrderHelper(subroot.getRight());
        }//end if
    }//end preOrderHelper

	public void printPostOrder(){
        System.out.println("Post order:");
        if (root != null){
            postOrderHelper(root.getLeft());
            postOrderHelper(root.getRight());
            System.out.print(root.getValue() + " ");
            System.out.println();
        }//end if
    }//end printPostOrder

    private void postOrderHelper(TreeNode subroot){
        if (subroot != null){
            postOrderHelper(subroot.getLeft());
            postOrderHelper(subroot.getRight());
            System.out.print(subroot.getValue() + " ");
        }//end if
    }//end postOrderHelper

    public int size(){
        int count = 0;
        if (root != null){
            count++;
            count += sizeHelper(root.getLeft());
            count += sizeHelper(root.getRight());
        }//end if
        return count;
    }//end size

    private int sizeHelper(TreeNode subroot){
        int count = 0;
        if (subroot != null){
            count++;
            count += sizeHelper(subroot.getLeft());
            count += sizeHelper(subroot.getRight());
        }//end if
        return count;
    }//end sizeHelper

	public boolean isEmpty(){
        return root == null;
    }//end isEmpty

    // this method takes an “old” object – determines if it is currently in the tree and if it is, removes that object and adds the “toAdd” object.  If the element was successfully replaced then true is returned, if the old object did not exist then false is returned and the toAdd object is added to the BST.  Remember that you cannot just replace an element by changing its value because it may not belong at that spot in the tree after being replaced.  
    public boolean replace(Comparable old, Comparable toAdd){
        boolean result = false;
        if (find(old)){
            delete(old);
            result = true;
        }//end if
        add(toAdd);
        return result;
    }//end replace
}//end BST