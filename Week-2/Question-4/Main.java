public class Main {
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }
        StringBuilder display = new StringBuilder();
        display.append('[');
        display.append(code.substring(0, 3));
        display.append("] YEAR: ");
        display.append(code.substring(3, 7));
        display.append(" | CATALOG: ");
        display.append(code.substring(7));
        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode("  pen2026004251  ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
