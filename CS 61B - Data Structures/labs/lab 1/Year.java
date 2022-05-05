public class Year {
    /** Check if a year is a leap year */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    /** Print whether YEAR is a a leap year on System.out. */
    private static void checkLeapYear(int year) {
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.%n", year);
        } else {
            System.out.printf("%d is not a leap year.%n", year);
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter command line arguments.");
            System.out.println("e.g. java Year 2000");
            System.exit(1);
        }

        for (int i = 0; i < args.length; i++) {
            try {
                int year = Integer.parseInt(args[i]);
                checkLeapYear(year);
            } catch (NumberFormatException e) {
                System.out.printf("%s is not a valid number", args[i]);
            }
        }

    }
}