package ab.Sep;

import java.util.ArrayList;
import java.util.List;

public class QueueWithArray {
    private int fixSize;
    private int count;
    private int head;
    private int tail;
    private List<Object> headList;
    private List<Object> tailList;

    public QueueWithArray() {
        this.fixSize = fixSize;
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        this.headList = new ArrayList<>();
        this.tailList = this.headList;
    }

    public void push(Object value) {
       if (tail == fixSize - 1) {
           List<Object> newList = new ArrayList<>();
           newList.add(value);
           tailList.add(newList);
           tailList = (List<Object>) tailList.get(tail);
           tail = 0;
       } else {
           tailList.add(value);
       }
       count++;
       tail++;
    }

    public Object pop() {
       if (count == 0) {
           return null;
       }
       Object value = headList.get(head);
       head++;
       count--;
       if (head == fixSize - 1) {
           List<Object> newList = (List<Object>) headList.get(head);
           headList.clear();
           headList = newList;
           head = 0;
       }
       return value;
    }

    public int size() {
       return count;
    }

}
