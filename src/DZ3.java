import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DZ3 {
    public static void main(String[] args) {
        int n=14;
//        delchet (random(n));
//        maxMin(random(n));
    }

    static List<Integer> random(int n) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }
    static void delchet (List list){
        for (int i=0; i<list.size();i++){
            if ((int) list.get(i)%2 == 0){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
    static void maxMin (List list){
        System.out.println(list);
        int max= (int) Collections.max(list);
        int min= (int) Collections.min(list);
        int sum= 0;
        int count=0;
        for(int i=0;i<list.size();i++){
            sum+=(int) list.get(i);
            count++;
        }
        int srednee=sum/count;
        System.out.println("Minimum= "+ min + ", Max= " + max+", srednee= "+ srednee);
    }

}

