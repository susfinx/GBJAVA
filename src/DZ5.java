import java.util.*;

public class DZ5 {
    public static void main(String[] args) {
        sorttreemap ();
    }
    static void telKnig(){
        Map<String, String>map = new HashMap<>();
        map.put("Иванов", "995959595 98888788877");
        map.put("Васильев", "95058574674 9484578443");
        map.put("Ивановa", "9485757585");
        map.put("Петрова", "8383838888 948484894984 9585858484");
        Boolean flag=false;
        String otvet="";
        while (flag==false){
            System.out.println("Dobavit Nomer Najmite 1\n Nayti Nomer Najmite 2" );
            Scanner scanner = new Scanner(System.in);
            otvet = scanner.nextLine();
            if (otvet.equals("1")|otvet.equals("2")){
                flag=true;
            }
            else {
                System.out.println("Vveli nevernoe Znachenie");
            }
        }
        if (otvet.equals("1")){
            dobavit(map);
        }
        else if (otvet.equals("2")){
            poisk(map);
        }
    }
    static void poisk ( Map<String,String> map){
        System.out.println("Vvedite famyliyu Poiska" );
        Scanner scanner = new Scanner(System.in);
        String ImyaPoisk= scanner.nextLine();
        for (Map.Entry<String,String> entry: map.entrySet()){
            if( entry.getKey().equals(ImyaPoisk)){
                System.out.println(entry);
            }
        }
        if(map.containsKey(ImyaPoisk)==false){
            System.out.println("Imya Ne Naydeno");
        }
    }
    static void dobavit (Map<String,String> map){
        String fameli="";
        String number="";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite Familiyu");
        fameli=scanner.nextLine();
        System.out.println("Vvedite Nomer");
        number=scanner.nextLine();
        if ( map.containsKey(fameli)){
            map.put(fameli, map.get(fameli)+" "+number);
            System.out.println(map);
        }
        else{
            map.put(fameli, number);
            System.out.println(map);
        }
    }


    static void sorttreemap () {
        String[] names = {
                "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков",
                "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов"
        };
        Map<String, Integer> nameCount = new HashMap<>();

        for (String name : names) {
            String firstName = name.split(" ")[0];
            if (nameCount.containsKey(firstName)) {
                nameCount.put(firstName, nameCount.get(firstName) + 1);
            } else {
                nameCount.put(firstName, 1);
            }
        }
        Map<String, Integer> sortedNameCount = new TreeMap<>(
                (o1, o2) -> nameCount.get(o2) - nameCount.get(o1));
        sortedNameCount.putAll(nameCount);

        for (Map.Entry<String, Integer> entry : sortedNameCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}