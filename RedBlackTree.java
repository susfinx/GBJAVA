public class RedBlackTree<Key extends Comparable<Key>> {
    private Node root;
    private Node NULL;

    private class Node {
        Key key;
        Node left, right, parent;
        boolean color;

        Node(Key key) {
            this.key = key;
            left = right = parent = null;
            color = true;
        }
    }

    public RedBlackTree() {
        NULL = new Node(null);
        NULL.color = false; 
        root = NULL;
    }

    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color;
    }

    private Node rotateLeft(Node node) {
        Node child = node.right;
        node.right = child.left;
        if (child.left != NULL)
            child.left.parent = node;
        child.parent = node.parent;
        if (node.parent == null)
            root = child;
        else if (node == node.parent.left)
            node.parent.left = child;
        else
            node.parent.right = child;
        child.left = node;
        node.parent = child;
        return child;
    }

    private Node rotateRight(Node node) {
        Node child = node.left;
        node.left = child.right;
        if (child.right != NULL)
            child.right.parent = node;
        child.parent = node.parent;
        if (node.parent == null)
            root = child;
        else if (node == node.parent.left)
            node.parent.left = child;
        else
            node.parent.right = child;
        child.right = node;
        node.parent = child;
        return child;
    }
    private void fixInsert(Node node) {
        while (isRed(node.parent)) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (isRed(uncle)) { 
                    node.parent.color = false;
                    uncle.color = false;
                    node.parent.parent.color = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        root = rotateLeft(node);
                    }
                    node.parent.color = false;
                    node.parent.parent.color = true;
                    root = rotateRight(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (isRed(uncle)) {
                    node.parent.color = false;
                    uncle.color = false;
                    node.parent.parent.color = true;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        root = rotateRight(node);
                    }
                    node.parent.color = false;
                    node.parent.parent.color = true;
                    root = rotateLeft(node.parent.parent);
                }
            }
        }
        root.color = false;
    }

    public void insert(Key key) {
        Node node = new Node(key);
        Node parent = null;
        Node current = root;
        while (current != NULL) {
            parent = current;
            if (key.compareTo(current.key) < 0)
                current = current.left;
            else
                current = current.right;
        }
        node.parent = parent;
        if (parent == null)
            root = node;
        else if (key.compareTo(parent.key) < 0)
            parent.left = node;
        else
            parent.right = node;
        node.left = NULL;
        node.right = NULL;
        node.color = true;
        fixInsert(node);
    }
}
