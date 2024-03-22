/* Problem Statement :-
Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
Note that each function must run in O(1) average time complexity.
*/

// Answer :-

class AllOne {
    class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            keys = new HashSet<>();
        }
    }

    Map<String, Node> keyMap;
    Map<Integer, Node> countMap;
    Node head, tail;

    public AllOne() {
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        Node node = keyMap.get(key);
        if (node == null) {
            addToCountMap(1, key);
        } else {
            addToCountMap(node.count + 1, key);
            removeFromCountMap(node);
        }
    }

    public void dec(String key) {
        Node node = keyMap.get(key);
        if (node != null) {
            removeFromCountMap(node);
            if (node.count > 1) {
                addToCountMap(node.count - 1, key);
            }
        }
    }

    private void addToCountMap(int count, String key) {
        Node node = countMap.get(count);
        if (node == null) {
            node = new Node(count);
            countMap.put(count, node);
            addNodeAfter(node, countMap.getOrDefault(count + 1, tail.prev));
        }
        node.keys.add(key);
        keyMap.put(key, node);
    }

    private void removeFromCountMap(Node node) {
        node.keys.removeIf(key -> {
            keyMap.remove(key);
            return true;
        });
        if (node.keys.isEmpty()) {
            removeNode(node);
            countMap.remove(node.count);
        }
    }

    private void addNodeAfter(Node newNode, Node prevNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public String getMaxKey() {
        return head.next == tail ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}
