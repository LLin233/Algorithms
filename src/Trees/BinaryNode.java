package Trees;

import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by Le on 2016/1/20.
 */
public class BinaryNode<K extends Comparable<K>, V> implements Comparable<BinaryNode<K, V>> {

    /// <summary>
    /// 节点元素
    /// </summary>
    public K key;

    /// <summary>
    /// duplicate value counts
    /// </summary>
    public HashSet<V> attach = new HashSet<V>();

    /// <summary>
    /// 左节点
    /// </summary>
    public BinaryNode<K, V> left;

    /// <summary>
    /// 右节点
    /// </summary>
    public BinaryNode<K, V> right;

    public BinaryNode() {
    }

    public BinaryNode(K key, V value, BinaryNode<K, V> left, BinaryNode<K, V> right) {
        //KV键值对
        this.key = key;
        this.attach.add(value);

        this.left = left;
        this.right = right;
    }


    @Override
    public int compareTo(BinaryNode<K, V> other) {
        return this.key.compareTo(other.key);
    }
}
