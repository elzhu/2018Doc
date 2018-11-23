package old;/*
https://blog.csdn.net/CSDN_Terence/article/details/77711687

HashMap内部维护了一个Entry[] table 数组，当我们使用 new HashMap()创建一个HashMap时，
Entry[] table 的默认长度为16。Entry[] table的长度又被称为这个HashMap的容量（capacity）；

The table, resized as necessary. Length MUST Always be a power of two.
transient Entry[] table;
 */


public class MyHashMap {
    final Bucket[] buckets = new Bucket[10000];
    public void put(int key, int value) {
        int i = idx(key);
        if (buckets[i] == null)
            buckets[i] = new Bucket();
        ListNode prev = find(buckets[i], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }
    public int get(int key) {
        int i = idx(key);
        if (buckets[i] == null)
            return -1;
        ListNode node = find(buckets[i], key);
        return node.next == null ? -1 : node.next.val;
    }
    public void remove(int key) {
        int i = idx(key);
        if (buckets[i] == null) return;
        ListNode prev = find(buckets[i], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
    }

    int idx(int key) { return Integer.hashCode(key) % buckets.length;}

    ListNode find(Bucket bucket, int key) {
        ListNode node = bucket.head, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}

class Bucket {
    final ListNode head = new ListNode(-1, -1);
}

class ListNode {
    int key, val;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

