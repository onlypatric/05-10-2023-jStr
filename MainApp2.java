/**
 * MainApp2
 */
public class MainApp2 {

    public static void main(String[] args) {
        String str = "ciao'mondo ciao";

        for (String string : str.split("[\\s|\\']")) {
            System.out.print(string.substring(0, 1).toUpperCase()+string.substring(1)+" ");
        }
        System.out.println();
    }
}