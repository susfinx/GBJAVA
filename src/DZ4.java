import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DZ4 {
    public static void main(String[] args) {
        int n = 10;
//        revers(random(n));
        dzMstak(random(n),n
        );
    }


    static LinkedList<Integer> random(int n) {
        Random random = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(random.nextInt(100));
        }
        return linkedList;
    }

    static void revers(LinkedList<Integer> linkedList) {
        System.out.println(linkedList);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = linkedList.size()-1; i >= 0; i--) {
            list.add(linkedList.get(i));
        }
        System.out.println(list);
    }
    static void dzMstak (LinkedList listist, int n){
        MstakDZ4 myStack = new MstakDZ4(listist, n);
        System.out.println(listist);
        System.out.println(myStack.enqueve(listist,n));
        System.out.println(myStack.dequeue(listist));
        System.out.println(listist);
        System.out.println(myStack.first(listist));
        System.out.println(myStack.summ(listist));
        System.out.println(listist);
    }
}
