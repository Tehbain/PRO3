import java.util.ArrayList;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;


    /**
     * Create a default BST with a natural order comparator
     */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /**
     * Create a BST with a specified comparator
     */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /**
     * Create a binary tree from an array of objects
     */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    /** Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                current = current.right;
            } else // element matches current.element
                found = true; // Element is found
        }

        return found;
    }

    @Override
    /** Insert element e into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e) {
        boolean inserted = true;
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null && inserted)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    inserted = false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return inserted; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    /** Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }
    private void inorder(TreeNode<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.element + ", ");
        inorder(node.right);
    }

    @Override
    /** Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }
    private void postorder(TreeNode<E> node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        System.out.print(node.element + ", ");
    }
    @Override
    /** Preorder traversal and prints from the root */
    public void preorder() {
        preorder(root);
    }
    private void preorder(TreeNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.element + ", ");
        preorder(node.left);
        preorder(node.right);
    }


    /**
     * This inner class is static, because it does not access
     * any instance members defined in its outer class
     */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    @Override
    /** Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /**
     * Returns the root of the tree
     */
    public TreeNode<E> getRoot() {
        return root;
    }


    @Override
    /** Delete an element from the binary tree.
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean found = false;
        while (current != null && !found) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                found = true; // Element is in the tree pointed at by current
        }

        if (found) {
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (c.compare(e, parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }
            size--; // Reduce the size of the tree
        }
        return found; // Element deleted successfully
    }

//
    //-------------------------------------------------------------------

    public boolean isLeaf(TreeNode<E> node) {
        if (node.left == null && node.right == null) return true;
        else return false;
    }
    public boolean isInternal(TreeNode<E> node) {
        if (node.left != null || node.right != null) return true;
        else return false;
    }

    public int height() {
        int height = 0;
        if (root == null){
            return height = -1;
        } else if (isLeaf(root)) {
            return height = 0;
        }

        else {
            return height(root, height) + 1;
        }
    }
    private int height(TreeNode<E> node, int height) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight++;
            height(node.left, leftHeight);
        }
        if (node.right != null) {
            rightHeight++;
            height(node.right, rightHeight);
        }
        if (leftHeight > rightHeight) height += leftHeight;
        else height += rightHeight;
        return height + 1;
    }

    public int sum() {
        return sum(root);
    }

    private int sum(TreeNode<E> node) {
        if (node == null) {
            return 0; // Base case
        }
        return (Integer) node.element + sum(node.left) + sum(node.right);
    }
//    public int sum(){
////        if (!(root.element instanceof Number)) {
////            System.out.println("NEVER SHOULD HAVE COME HERE");
////            throw new ArithmeticException();
////        }
//        int rootSum = (int) root.element;
//        int sum = 0;
//
//        if (root.left != null && root.right != null){
//            return rootSum + sum(root.left, sum) + sum(root.right, sum);
//        } else if (root.left != null) {
//            return rootSum + sum(root.left, sum);
//        } else if (root.right != null) {
//            return  rootSum + sum(root.right, sum);
//        }
//        else return 0; //root is leaf.
//    }
//
//    private int sum(TreeNode<E> node, int sum) {
//        if (node.left != null && node.right != null){
//            sum += (Integer) node.element;
//            return sum(node.left, sum) + sum(node.right, sum);
//        } else if (node.left != null) {
//            sum += (Integer) node.element;
//            return sum(node.left, sum);
//        } else if (node.right != null) {
//            sum += (Integer) node.element;
//            return sum(node.right, sum);
//        } else return sum;
//    }

    public int findMax(){
        TreeNode<E> current = root; // Start from the root

        Integer biggus = (Integer) root.element;
        Integer lInt = 0;
        Integer rInt = 0;
        if (isLeaf(root)){
            return biggus;
        }
        boolean leftEnd = false;
        boolean rightEnd = false;
        while (current != null && !leftEnd && !rightEnd){
            if (current.left != null)
                lInt = (Integer) current.left.element;
            if (current.right != null)
                rInt = (Integer) current.right.element;
            if (lInt > biggus && current.left != null) {
                biggus = lInt;
                current = current.left;
                if (current.left == null) leftEnd = true;
            } else if (rInt > biggus && current.left != null) {
                biggus = rInt;
                current = current.right;
                if (current.right == null) rightEnd = true;
            }
        }
        return biggus;
    }


    public int findMin() {
        TreeNode<E> current = root; // Start from the root

        Integer minimus = (Integer) root.element;
        Integer lInt = 0;
        Integer rInt = 0;
        if (isLeaf(root)){
            return minimus;
        }
        boolean leftEnd = false;
        boolean rightEnd = false;
        while (current != null && !leftEnd && !rightEnd){
            if (current.left != null)
                lInt = (Integer) current.left.element;
            if (current.right != null)
                rInt = (Integer) current.right.element;
            if (lInt < minimus && current.left != null) {
                minimus = lInt;
                current = current.left;
                if (current.left == null) leftEnd = true;
            } else if (rInt < minimus && current.left != null) {
                minimus = rInt;
                current = current.right;
                if (current.right == null) rightEnd = true;
            }
        }
        return minimus;
    }

    /**
     Metoden skal fjerne og returnere det mindste element i søgetræet.
     Metoden må ikke gå igennem træet flere gange, og må derfor ikke kalde den
     eksisterende delete metode.
     */
    public E removeMin(){
        E toReturn = null;

        //Special case: root har ingen venstre børn
        if (root.left == null && root != null) {
            toReturn = root.element;
            if (root.right != null) {
                root = root.right;
            }
            return toReturn;
        }

        else /*(root.left != null)*/ {
            return removeMin(root, null);
        }
    }

    private E removeMin(TreeNode<E> node, TreeNode parent) {

        //node har venstre børn - vi leder videre langs venstresiden.
        if (node.left != null) {
            return removeMin(node.left, node);
        }

        //node er blad - vi sletter node og returnerer E
        if (node.left == null && node.right == null) {
            E toReturn = node.element;
            parent.left = null;
            node = null;
            return toReturn;
        }

        //node har ikke venstre børn, men har højre børn - vi sletter node, lapper mellem parent.right og node.right, og returnerer E.
        else /*(node.left == null && node.right != null)*/ {
            E toReturn = node.element;
            parent.left = node.right;
            node = null;
            return toReturn;
        }
    }

    public E removeMax() {
        E toReturn = null;
        if (root.right == null && root != null) {
            toReturn = root.element;
            if (root.left != null) {
                root = root.left;
            }
            return toReturn;
        } else{
            return removeMax(root, null);
        }
    }

    private E removeMax(TreeNode<E> node, TreeNode parent) {
        if (node.right != null) {
            return removeMax(node.right, node);
        }
        if (node.right == null && node.left == null) {
            E toReturn = node.element;
            parent.right = null;
            node = null;
            return toReturn;
        }
        else {
            E toReturn = node.element;
            parent.right = node.left;
            node = null;
            return toReturn;
        }
    }

    /**
    greaterThan(E element): ArrayList<E> – metoden skal returnere alle de
    elementer i træet der er større end element.
     */
    public ArrayList<E> greaterThan(E e) {
        ArrayList<E> biggus = new ArrayList<>();

        //Special case: root har ingen højre børn og root.element er ikke større end e - vi returnerer en tom liste.
        if (root != null && root.right == null) {
            if(c.compare(root.element, e) <= 0) {
                return biggus;
            }
            biggus.add(root.element);
            return biggus;
        }
        // venstre barn er større end e
        if (root.left != null && c.compare(root.left.element,e) > 0){
            biggus.add(root.element);
            greaterThan(root.left, e, biggus);
        }
        // højre barn er større end e
        if (root.right != null && c.compare(root.right.element,e) > 0){
            greaterThan(root.right,e,biggus);
        }
        biggus.sort(c);
        return biggus;

    }

    private void greaterThan(TreeNode<E> node, E e, ArrayList<E> biggus) {
        //nodes venstre barn er større end e
        if (node.left != null && c.compare(node.left.element, e) > 0) {
            greaterThan(node.left,e,biggus);
        //nodes højre barn er større end e
        }
        if (node.right != null && c.compare(node.right.element, e) > 0) {
            greaterThan(node.right,e,biggus);
        }
        //node element er større end e
        if (c.compare(node.element, e) > 0) biggus.add(node.element);
        //else gør du ik' en skid.
    }

    public ArrayList<E> greaterThanGPT(E e) {
        ArrayList<E> biggus = new ArrayList<>();

        if (root != null) {
            greaterThan(root, e, biggus);
        }

        biggus.sort(c);
        return biggus;
    }

    private void greaterThanGPT(TreeNode<E> node, E e, ArrayList<E> biggus) {
        if (node != null) {
            greaterThan(node.left, e, biggus);

            // Check if the current node's element is greater than or equal to e
            if (c.compare(node.element, e) >= 0) {
                biggus.add(node.element);
            }

            greaterThan(node.right, e, biggus);
        }
    }

}
