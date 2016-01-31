package Trees;

/**
 * Created by Le on 2016/1/20.
 */
public class BinaryTree<K extends Comparable<K>, V> {
    public BinaryNode<K, V> node = null;

    public void add(K key, V value) {
        node = add(key, value, node);
    }

    public BinaryNode<K, V> add(K key, V value, BinaryNode<K, V> tree) {
        if (tree == null) {
            tree = new BinaryNode<>(key, value, null, null);
        }
        if (key.compareTo(tree.key) < 0) {
            tree.left = add(key, value, tree.left);
        }
        if (key.compareTo(tree.key) > 0) {
            tree.right = add(key, value, tree.right);
        }

        if (key.compareTo(tree.key) == 0) {
            tree.attach.add(value);  // or count++
        }
        return tree;
    }

    public boolean contains(K key) {
        return contains(key, node);
    }

    public boolean contains(K key, BinaryNode<K, V> tree) {
        if (tree == null) {
            return false;
        }
        if (key.compareTo(tree.key) < 0) {
            return contains(key, tree.left);
        }
        if (key.compareTo(tree.key) > 0) {
            return contains(key, tree.right);
        }
        return true;
    }
}
