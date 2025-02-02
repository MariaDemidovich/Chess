public class Main {

    public static void main(String[] args) {
        String[] color = {"\033[30;47m", "\033[37;40m"};
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int i = 8; i > 0; i--) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(color[(i + j) % 2] + "   ");
            }
            System.out.println("\033[0m");
        }
    }
}