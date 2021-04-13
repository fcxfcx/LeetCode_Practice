package DetailPractice;

import java.util.HashMap;

/**
 * @author Chuxing, Fang
 * @version 1.0
 * Problem 146. LRU缓存机制
 * 标签：哈希表，双向链表
 */
public class Problem_146 {
    class LRUCache {
        // 使用一个双向链表来满足储存最久未使用的功能
        // 双向链表的头结点是最近使用的数，尾结点是最久未使用的数
        public class DLinkedNode {
            int value;
            int key;
            DLinkedNode next;
            DLinkedNode prev;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;
        private int size;
        private HashMap<Integer, DLinkedNode> map = new HashMap<>();
        // head 和 tail 是伪头结点/尾结点，起到标记头尾的作用
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = map.get(key);
            // 如果不存在该值则返回-1
            if (node == null) {
                return -1;
            }
            // 存在该值则返回对应的value并将结点维护至头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            if(node == null){
                // 如果不存在键值对则添加
                DLinkedNode addNode = new DLinkedNode(key , value);
                map.put(key, addNode);
                addToHead(addNode);
                size++;
                if(size > capacity){
                    // 如果超出容量则删除最久未使用的结点（尾结点）
                    DLinkedNode remove = removeTail();
                    map.remove(remove.key);
                    size--;
                }
            }else{
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        /**
         * 将新结点添加到头结点
         *
         * @param node 新结点
         */
        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        /**
         * 移除链表中某结点
         *
         * @param node 待移除结点
         */
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        /**
         * 将已在链表中的某节点移至头结点
         *
         * @param node 待移动结点
         */
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        /**
         * 移除并返回尾结点
         *
         * @return 尾结点
         */
        private DLinkedNode removeTail() {
            DLinkedNode remove = tail.prev;
            removeNode(remove);
            return remove;
        }
    }

}
