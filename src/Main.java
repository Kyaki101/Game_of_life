import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserte la dimensión que desea para el universo: ");
        int f = sc.nextInt();
        Universo face = new Universo(f, f);
        face.llenar();
        face.show();
        System.out.println();
        face.jugar();
    }
}