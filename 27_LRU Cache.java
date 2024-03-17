/* Problem Statement :-
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

// Answer :-

class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }
    public HashMap<Integer,Node>hp=new HashMap<>();
    public int size;
    public int capacity;
    public Node head;
    public Node tail;
    public LRUCache(int capacity) {
       this.capacity=capacity;
       head=new Node();
       tail=new Node();
       head.next=tail;
       tail.prev=head;
    }
    
    public int get(int key) {
        Node node=hp.get(key);
        if(node==null){
         return -1;
        }
       move(node);
       return node.value;
    }
    public  void  move(Node node){
        remove(node);
        insert(node);
    }
    public void put(int key, int value) {
        Node node=hp.get(key);
        if(node!=null){
              node.value=value;
             move(node);
        }
        else{
            Node newnode=new Node();
            newnode.key=key;
            newnode.value=value;
            insert(newnode);
            hp.put(key,newnode);
            size++;
            if(size>capacity){
               int n=tail.prev.key;
               remove(tail.prev);
                hp.remove(n);
                size--;

            }
        }
    }
    public void insert(Node node){
      node.prev=head;
      node.next=head.next;
      head.next.prev=node;
      head.next=node;

    }
    public void remove(Node node){
       Node prev=node.prev;
       Node next=node.next;
       prev.next=next;
       next.prev=prev;
    }
}
