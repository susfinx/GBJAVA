import java.util.*;
public class DZ6 {
     public static void main(String[] args) {
         List<Notebook> notebooks = new ArrayList<>();
         notebooks.add(new Notebook(4, 500, 22200, "Windows", "Lenova 3350"));
         notebooks.add(new Notebook(8, 1000, 32800, "Linux","Xpeng 2046"));
         notebooks.add(new Notebook(16, 2000, 45800, "Mac","Mac"));
         notebooks.add(new Notebook(16, 1000, 38000, "Mac","mac"));
         notebooks.add(new Notebook(4, 500, 22200, "Windows","MSI 1298"));

         Map<String, Integer> filterCriteria = new HashMap<>();

         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter filter criteria (1 - RAM, 2 - Storage, 3 - Operating System, 4 - Price): ");
         int criteria = scanner.nextInt();

         switch (criteria) {
             case 1:
                 System.out.println("Enter minimum RAM: ");
                 filterCriteria.put("RAM", scanner.nextInt());
                 break;
             case 2:
                 System.out.println("Enter minimum storage: ");
                 filterCriteria.put("Storage", scanner.nextInt());
                 break;
             case 3:
                 System.out.println("Enter operating system: ");
                 filterCriteria.put("Operating System", 0);
                 break;
             case 4:
                 System.out.println("Enter maximum Price: ");
                 filterCriteria.put("Price", scanner.nextInt());
                 break;
             case 5:
                 System.out.println("Enter model: ");
                 filterCriteria.put("model", 0);
                 break;
             default:
                 System.out.println("Invalid filter criteria.");
                 break;
         }

         List<Notebook> filteredNotebooks = new ArrayList<>();
         System.out.println("Filtered notebooks: ");
         boolean flaf = false;
         for (Notebook notebook : notebooks) {
             if (filterCriteria.containsKey("RAM") && notebook.RAM == filterCriteria.get("RAM")) {
                 System.out.println(notebook.model+" Storage:"+notebook.storage+" Operation system:"+
                         notebook.operatingSystem+ " Price:"+notebook.price);
                 flaf=true;
             }
             if (filterCriteria.containsKey("Storage") && notebook.storage == filterCriteria.get("Storage")) {
                 System.out.println(notebook.model+" RAM:"+notebook.RAM+" Operation system:"+
                         notebook.operatingSystem+ " Price:"+notebook.price);
                 flaf=true;
             }
             if (filterCriteria.containsKey("Operating System")) {
                 scanner.nextLine();
                 String os = scanner.nextLine();
                 if (!notebook.operatingSystem.equalsIgnoreCase(os)) {
                     System.out.println(notebook.model+" Storage:"+notebook.storage+" RAM:"+
                             notebook.RAM+ " Price:"+notebook.price);
                     flaf=true;
                 }
             }
             if (filterCriteria.containsKey("Price") && notebook.price <=filterCriteria.get("Price")){
                 System.out.println(notebook.model+" Storage:"+notebook.storage+" RAM:"+
                         notebook.RAM+" Operation System:"+notebook.operatingSystem+ " Price:"+notebook.price);
                 flaf=true;
             }
         }
         if (flaf==false) {
             System.out.println("No found.");
         }
     }
}