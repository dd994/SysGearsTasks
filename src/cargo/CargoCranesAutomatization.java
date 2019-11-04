package cargo;

public class CargoCranesAutomatization {

    public static void main(String[] args) {
        move(5);
    }

    public static void move(int n) {
        char a = 'a';
        char b = 'b';
        char c = 'c';
        if( n>=3 && n<=8) {
            moveRing(a, b, c, n);
        } else System.out.println("Wrong number");

    }

    public static void moveRing(char a, char b, char c, int count) {
        if (count == 1) {
            System.out.println(String.format("#" + count + " slot_" + "%s" + " -> " + "slot_" + "%s", a, b));
        } else {
            moveRing(a, c, b, count - 1);
            System.out.println(String.format("#" + count + " slot_" + "%s" + " -> " + "slot_" + "%s", a, b));
            moveRing(c, b, a, count - 1);
        }
    }
}