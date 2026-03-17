package baek;

class BTreeNode {
    int[] keys; // Array to store keys
    int minDegree; // Minimum degree (defines the range for number of keys)
    BTreeNode[] children; // Array to store child pointers
    int currentNumber; // Current number of keys
    boolean leaf; // True when node is leaf, else False

    public BTreeNode(int minDegree, boolean leaf) {
        this.minDegree = minDegree;
        this.leaf = leaf;

        keys = new int[2 * minDegree - 1];
        children = new BTreeNode[2 * minDegree];
        currentNumber = 0;
    }

    // Function to search given key in subtree
    // rooted with this node
    public BTreeNode search(int key) {
        int i = 0;

        while (i < currentNumber && key > keys[i])
            i++;

        if (keys[i] == key)
            return this;

        if (leaf)
            return null;

        return children[i].search(key);
    }

    // Function to insert a new key
    // in subtree rooted with this node
    public void insertNonFull(int key) {
        int i = currentNumber - 1;

        if (leaf) {
            while (i >= 0 && key < keys[i]) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            currentNumber++;
        } else {
            while (i >= 0 && key < keys[i])
                i--;
            i++;

            if (children[i].currentNumber == 2 * minDegree - 1) {
                splitChild(i, children[i]);
                if (key > keys[i])
                    i++;
            }
            children[i].insertNonFull(key);
        }
    }

    // Function to split the child node
    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.minDegree, y.leaf);
        z.currentNumber = minDegree - 1;

        for (int j = 0; j < minDegree - 1; j++)
            z.keys[j] = y.keys[j + minDegree];

        if (!y.leaf) {
            for (int j = 0; j < minDegree; j++)
                z.children[j] = y.children[j + minDegree];
        }

        y.currentNumber = minDegree - 1;

        for (int j = currentNumber; j >= i + 1; j--)
            children[j + 1] = children[j];

        children[i + 1] = z;

        for (int j = currentNumber - 1; j >= i; j--)
            keys[j + 1] = keys[j];

        keys[i] = y.keys[minDegree - 1];
        currentNumber++;
    }

    // Function to print all keys in the
    // subtree rooted with this node
    public void printInOrder() {
        int i;

        for (i = 0; i < currentNumber; i++) {
            if (!leaf)
                children[i].printInOrder();
            System.out.print(keys[i] + " ");
        }

        if (!leaf)
            children[i].printInOrder();
    }
}

public class BTree {
    // Pointer to root node
    private BTreeNode root;

    // Minimum degree
    private int t;

    public BTree(int t) {
        this.t = t;
        root = null;
    }

    // Function to search a key in this tree
    public BTreeNode search(int key) {
        return (root == null) ? null : root.search(key);
    }

    // Function to insert a key into the B-tree
    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.currentNumber = 1;
        } else {
            if (root.currentNumber == 2 * t - 1) {
                BTreeNode newRoot = new BTreeNode(t, false);
                newRoot.children[0] = root;
                newRoot.splitChild(0, root);

                int i = 0;

                if (newRoot.keys[0] < key)
                    i++;

                newRoot.children[i].insertNonFull(key);
                root = newRoot;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    // Function to print the entire B-tree
    public void printBTree() {
        if (root != null)
            root.printInOrder();

        System.out.println();
    }

    public static void main(String[] args) {
        // Create a B-tree with minimum degree 3
        BTree bTree = new BTree(3);
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);

        System.out.print("B-tree : ");
        bTree.printBTree();

        int searchKey = 6;
        BTreeNode foundNode = bTree.search(searchKey);

        if (foundNode != null)
            System.out.println("Key " + searchKey + " found in the B-tree.");
        else
            System.out.println("Key " + searchKey + " not found in the B-tree.");
    }
}

