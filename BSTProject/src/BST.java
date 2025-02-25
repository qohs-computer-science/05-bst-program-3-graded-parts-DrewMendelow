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
                deleteRoot();
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
                    if (root.getRight() == null){
                        return false;
                    }
                    else{
                        if (value.compareTo(root.getRight().getValue()) == 0){
                            handleDelete(root, root.getRight(), false);
                            return true;
                        }
                        else{
                            return deleteHelper(value, root.getRight());
                        }
                    }
                }
            }
        }
    }

    private boolean deleteHelper(Comparable value, TreeNode subroot){
        if (value.compareTo(subroot.getValue()) <= 0){
            if (subroot.getLeft() == null){
                return false;
            }
            else{
                if (value.compareTo(subroot.getLeft().getValue()) == 0){
                    handleDelete(subroot, subroot.getLeft(), true);
                    return true;
                }
                else{
                    return deleteHelper(value, subroot.getLeft());
                }
            }
        }
        else{
            if (subroot.getRight() == null){
                return false;
            }
            else{
                if (value.compareTo(subroot.getRight().getValue()) == 0){
                    handleDelete(subroot, subroot.getRight(), false);
                    return true;
                }
                else{
                    return deleteHelper(value, subroot.getRight());
                }
            }
        }
    }

    private void handleDelete(TreeNode parent, TreeNode child, boolean isLeft){
        if (child.getLeft() == null){
            if (child.getRight() == null){
                if (isLeft){
                    parent.setLeft(null);
                }
                else{
                    parent.setRight(null);
                }
            }
            else{
                if (isLeft){
                    parent.setLeft(child.getRight());
                    child.setRight(null);
                }
                else{
                    parent.setRight(child.getRight());
                    child.setRight(null);
                }
            }
        }
        else{
            if (child.getRight() == null){
                if (isLeft){
                    parent.setLeft(child.getLeft());
                    child.setLeft(null);
                }
                else{
                    parent.setRight(child.getLeft());
                    child.setLeft(null);
                }
            }
            else{
                TreeNode temp = child.getLeft();
                while (temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(child.getRight());
                if (isLeft){
                    parent.setLeft(child.getLeft());
                }
                else{
                    parent.setRight(child.getLeft());
                }
                child.setLeft(null);
                child.setRight(null);
            }
        }
    }

    private void deleteRoot(){
        if (root.getLeft() == null){
            if (root.getRight() == null){
                root = null;
            }
            else{
                root = root.getRight();
            }
        }
        else{
            if (root.getRight() == null){
                root = root.getLeft();
            }
            else{
                TreeNode temp = root.getLeft();
                while (temp.getRight() != null){
                    temp = temp.getRight();
                }
                temp.setRight(root.getRight());

                root = root.getLeft();
            }
        }
    }

    public void printInOrder(){
        System.out.println("In order:");
        if (root != null){
            inOrderHelper(root.getLeft());
            System.out.print(root.getValue() + " ");
            inOrderHelper(root.getRight());
            System.out.println();
        }
    }

    private void inOrderHelper(TreeNode subroot){
        if (subroot != null){
            inOrderHelper(subroot.getLeft());
            System.out.print(subroot.getValue() + " ");
            inOrderHelper(subroot.getRight());
        }
    }

	public void printPreOrder(){
        System.out.println("Pre order:");
        if (root != null){
            System.out.print(root.getValue() + " ");
            preOrderHelper(root.getLeft());
            preOrderHelper(root.getRight());
            System.out.println();
        }
    }

    private void preOrderHelper(TreeNode subroot){
        if (subroot != null){
            System.out.print(subroot.getValue() + " ");
            preOrderHelper(subroot.getLeft());
            preOrderHelper(subroot.getRight());
        }
    }

	public void printPostOrder(){
        System.out.println("Post order:");
        if (root != null){
            postOrderHelper(root.getLeft());
            postOrderHelper(root.getRight());
            System.out.print(root.getValue() + " ");
            System.out.println();
        }
    }

    private void postOrderHelper(TreeNode subroot){
        if (subroot != null){
            postOrderHelper(subroot.getLeft());
            postOrderHelper(subroot.getRight());
            System.out.print(subroot.getValue() + " ");
        }
    }

    public int size(){
        int count = 0;
        if (root != null){
            count++;
            count += sizeHelper(root.getLeft());
            count += sizeHelper(root.getRight());
        }
        return count;
    }

    private int sizeHelper(TreeNode subroot){
        int count = 0;
        if (subroot != null){
            count++;
            count += sizeHelper(subroot.getLeft());
            count += sizeHelper(subroot.getRight());
        }
        return count;
    }

	public boolean isEmpty(){
        return root == null;
    }

    public boolean replace(Comparable old, Comparable toAdd){
        
    }
}