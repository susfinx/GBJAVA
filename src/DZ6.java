import java.util.*;
public class DZ6 {
     public static void main(String[] args) {
         List<Notebook> notebooks = new ArrayList<>();
         notebooks.add(new Notebook(4, 500, 22200, "Windows", "Lenova 3350"));
         notebooks.add(new Notebook(8, 1000, 32800, "Linux","Xpeng 2046"));
         notebooks.add(new Notebook(16, 2000, 45800, "Mac","Mac"));
         notebooks.add(new Notebook(16, 1000, 38000, "Mac","Mac"));
         notebooks.add(new Notebook(4, 500, 22200, "Windows","MSI 1298"));

         filtr (notebooks);
     }

     static void filtr (List<Notebook> notebooks){
         Map<String, Integer> filterCriteria = new HashMap<>();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter filter criteria (1 - RAM, 2 - Storage, 3 - Operating System, 4 - Price, 5 - Model): ");
         int criteria = scanner.nextInt();
         int sistem=0;
         int mod=0;

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
                 System.out.println("Enter operating system:\n 1 - Windows\n 2- Linux\n 3- Mac\n ");
                 sistem=scanner.nextInt();
                 filterCriteria.put("Operating System", sistem);
                 break;
             case 4:
                 System.out.println("Enter maximum Price: ");
                 filterCriteria.put("Price", scanner.nextInt());
                 break;
             case 5:
                 System.out.println("Modeli v nalichie, enter Model;\n 1-Lenova 3350\n 2-Xpeng 2046\n 3- MSI 1298\n 4- Mac");
                 mod=scanner.nextInt();
                 filterCriteria.put("Model", 0);
                 break;
             default:
                 System.out.println("Invalid filter criteria.");
                 break;
         }
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
                 String os = "";
                 if(sistem==1){os="Windows";}
                 if(sistem==2){os="Linux";}
                 if(sistem==3){os="Mac";}

                 if (notebook.operatingSystem.equals(os)) {
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
             if (filterCriteria.containsKey("Model")) {
                 String model="";
                 if(mod==1){model="Lenova 3350";}
                 if(mod==2){model="Xpeng 204";}
                 if(mod==3){model="MSI 1298";}
                 if(mod==4){model="Mac";}

                 if (notebook.model.equals(model)) {
                     System.out.println(notebook.model+" Storage:"+notebook.storage+" RAM:"+
                             notebook.RAM+ " Price:"+notebook.price);
                     flaf=true;
                 }
             }
         }
         if (flaf==false) {
             System.out.println("No found.");
         }
     }
}