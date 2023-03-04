package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private final OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        // TODO -- add your code here
        printHorizontalFrame(size);
        mOut.println();
        for (int i = 0; i < 2 * size - 1; i++) {
            // Using a string object of type `StringBuilder` allows for appending text using `append()` method which is better than concatenating normal `String` objects.
            StringBuilder line = new StringBuilder();
            line.append("|");
            if (i < size - 1) {
                line = printSpaces(size, i, line);
                line.append("/");
                line = printFiller(size, i, line);
                line.append("\\");
                line = printSpaces(size, i, line);
            } else if (i == size - 1) {
                line.append("<");
                line = printFiller(size, i, line);
                line.append(">");
            } else {
                line = printSpaces(size, i, line);
                line.append("\\");
                line = printFiller(size, i, line);
                line.append("/");
                line = printSpaces(size, i, line);
            }
            line.append("|");
            mOut.println(line);
        }
        printHorizontalFrame(size);
    }

    // TODO -- add any helper methods here

    /**
     * This method is used to print the upper and bottom frame of the diamond
     */
    public void printHorizontalFrame(int size) {
        mOut.print("+");
        for (int i = 0; i < 2 * size; i++) {
            mOut.print("-");
        }
        mOut.print("+");
    }

    /**
     * This method appends white spaces to a string parameter of type StringBuilder and returns the modified string.
     */
    public StringBuilder printSpaces(int size, int i, StringBuilder line) {
        int count;  // Stores the number of white spaces that need to be added for a specific line in the diamond
        if (i < size - 1)
            count = size - (i + 1);     // If the line is in the upper half of the diamond.
        else
            count = i - (size - 1);     // If the line in in the lower half of the diamond.

        for (int j = 0; j < count; j++) {
            line.append(" ");
        }
        return line;
    }

    /**
     * This method fills a string parameter with `-` for odd lines and `=` for even lines depending on (i) value. And returns the modified string.
     */
    public StringBuilder printFiller(int size, int i, StringBuilder line) {
        int count;  // Stores the number of filling characters that need to be added for a specific line in the diamond
        if (i <= size - 1)
            count = i * 2;      // If the line is in the upper half of the diamond.
        else
            count = 4 * size - 2 * (i + 2);     // If the line is in the lower half of the diamond.

        if (i % 2 == 0)
            for (int j = 0; j < count; j++) {       // If the line is even
                line.append("=");
            }
        else
            for (int j = 0; j < count; j++) {       // If rhe line is odd
                line.append("-");
            }

        return line;
    }

}
