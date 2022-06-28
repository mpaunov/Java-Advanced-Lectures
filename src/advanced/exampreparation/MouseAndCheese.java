package advanced.exampreparation;

import java.util.Scanner;

public class MouseAndCheese {

    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseIsInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {


            // Move mouse will be called with the correct mutators in each case the mutators are defining the
            // movement direction
            // UP { -1, 0}
            // DOWN { 1, 0}
            // LEFT { 0, -1}
            // RIGHT { 0, 1}
            if (command.equals("up")) {
                moveMouse(field, -1, 0);
            } else if (command.equals("down")) {
                moveMouse(field, 1, 0);
            } else if (command.equals("left")) {
                moveMouse(field, 0, -1);
            } else if (command.equals("right")) {
                moveMouse(field, 0, 1);
            }

            if (!mouseIsInField) {
                break;
            }

            command = scanner.nextLine();
        }

        if (!mouseIsInField) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese >= 5) {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        } else {
            System.out.println("The mouse couldn't eat the cheeses, she needed " +
                    (5 - eatenCheese) + " cheeses more.");
        }

        print2dArray(field);
    }

    /**
     *
     * @param field char[][] the mouse field
     * @param rowMutator int mutator that will be added to the current row of the mouse
     * @param colMutator int mutator that will be added to the current col of the mouse
     */
    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonusHit = false;

        if (!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            mouseIsInField = false;
            return;
        }

        if (field[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (field[nextRow][nextCol] == 'B') {
            isBonusHit = true;
        }

        field[row][col] = '-';
        field[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if (isBonusHit) {
            // Call this same method with the same mutators again if bonus is hit
            moveMouse(field, rowMutator, colMutator);
        }
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static void print2dArray(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
