public class drawTraingle {
    public static void main(String[] args) {
        int col = 0;
        int row = 0;
        int SIZE = 5;

        while (row < SIZE) {
            while (col < row + 1) {
                System.out.print("*");
                col += 1;
            }
            col = 0;
            row += 1;
            System.out.println();
        }
    }
}
