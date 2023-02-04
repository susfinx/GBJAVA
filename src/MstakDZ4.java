import java.util.LinkedList;
import java.util.ListIterator;

//Реализуйте очередь с помощью LinkedList со следующими методами; enqueue() -
// помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class MstakDZ4 {
    private LinkedList  linkedList;
    private int n;

    MstakDZ4(LinkedList linkedList, int n) {

    }

    LinkedList enqueve(LinkedList linkedList, int n){
        linkedList.addLast(n);
        return linkedList;
    }
    int dequeue(LinkedList linkedList){
        return (int) linkedList.pollFirst();
    }
    int first(LinkedList linkedList){
        return (int) linkedList.getFirst();
    }
    int summ (LinkedList linkedList) {
        int summ = 0;
        ListIterator<Integer> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            summ += integer;
        }
        return summ;
    }
}