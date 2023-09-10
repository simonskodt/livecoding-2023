import java.util.Random;

public class Opgave4 {
    public static String shortestName(String name, String otherName) {
        Random r = new Random();
        int rand = r.nextInt(2); // generate random number of 0 or 1

        if (name.length() < otherName.length()) {
            return name;
        } else if (name.length() == otherName.length()) {
            // Return random name
            if (rand == 0) {
                return name;
            }
            return otherName;
        }
        return otherName;
    }

    public static void shortestMiddleAndLastName(
        String middleName, String otherMiddleName,
        String lastName, String otherLastName
    ) {
        String finalName;

        String shortestMiddleName = shortestName(middleName, otherMiddleName);
        String shortestLastName = shortestName(lastName, otherLastName);

        if (shortestMiddleName.length() < shortestLastName.length()) {
            if (shortestMiddleName.equals(middleName)) {
                printName(middleName, otherLastName);
            } else {
                printName(otherMiddleName, lastName);
            }
        } else if (shortestMiddleName.length() > shortestLastName.length()) {
            if (shortestLastName.equals(lastName)) {
                printName(otherMiddleName, lastName);
            } else {
                printName(middleName, otherLastName);
            }
        } else { // same length
            if (shortestMiddleName.equals(middleName)) {
                printName(middleName, otherLastName);
            } else {
                printName(otherMiddleName, lastName);
            }
        }
    }
    
    public static void printName(String middleName, String lastName) {
        String fullName = String.format("%s %s", middleName, lastName);
        System.out.println(fullName);
    }
}