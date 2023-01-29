import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class DZ1 {
    public static void main(String[] args) {
        Zadacha4();
    }
    //ZADACHA 1 Вычислить n-ое треугольного число(сумма чисел от 1 до n)
    static void Zadacha1(){
        System.out.println("Vvedite Chislo N ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i <=num; i++) {
            sum+=i;
        }
        System.out.println("Summa chisel ot 1 do N ravna " + sum);
    }
    //Вычислить n! (произведение чисел от 1 до n)
    static void Zadacha2(){
        System.out.println("Vvedite Chislo N ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 1;
        for (int i = 1; i <=num; i++) {
            sum=sum*i;
        }
        System.out.println("Proizvedenie chisel ot 1 do N ravna " + sum);
    }
    /* Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только
    на себя и на единицу без остатка. Чтобы найти остаток от деления используйте оператор % ,
    например 10%3 будет равно единице)
     */
    static void Zadacha3(){
        int num=1000;
        List<Integer> listnum = new ArrayList<>();
        for (int i=3; i <=num;i++){
            for(int j=2;j<=i;j++){
                if (i%j==0&&j<i){
                    break;
                }
                else if (j==i){
                    listnum.add(j);
                }
            }
        }
        System.out.println(listnum);
    }
    /*Реализовать простой калькулятор ("введите первое число"... "Введите второе число"... "
    укажите операцию, которую надо выполнить с этими числами"... "ответ: ...")
     */
    static void Zadacha4(){
        float otvet = 0;
        System.out.println("введите первое число");
        Scanner scanner = new Scanner(System.in);
        float num1 = scanner.nextFloat();
        System.out.println("введите vtoroe число");
        Scanner scanner2 = new Scanner(System.in);
        float num2 = scanner2.nextFloat();
        boolean proverka = false;
        while (proverka==false){
            System.out.println("Vvedite operaciyu dlya chisel +,-,*,/ .");
            Scanner scanner1 = new Scanner(System.in);
            String name = scanner1.nextLine();
            if (name.contains("+") ==true) {
                proverka=true;
                otvet = num1 + num2;
                System.out.println(otvet);
            }
            else if (name.contains("-") ==true){
                proverka=true;
                otvet = num1-num2;
                System.out.println(otvet);
            }
            else if (name.contains("*") ==true){
                proverka=true;
                otvet = num1*num2;
                System.out.println(otvet);
            }
            else if (name.contains("/") ==true){
                proverka=true;
                otvet = num1/num2;
                System.out.println(otvet);
            }
            else {
                System.out.println("Nekorekny Znak");
            }
        }


    }


}
