public class AccessRuleEngine {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) {
            return "ALLOWED";
        }
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }
        if ("default".equals(fieldModifier)) {
            if ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        if ("protected".equals(fieldModifier)) {
            if ("SAME_CLASS".equals(accessorContext)
                    || "SAME_PACKAGE".equals(accessorContext)
                    || "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        return "DENIED";
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;
        for (int i = 0; i < attempts.length; i++) {
            if ("ALLOWED".equals(classifyAccess(attempts[i][0], attempts[i][1]))) {
                allowed++;
            } else {
                denied++;
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static String describeContext(String accessorContext) {
        String[] parts = accessorContext.split("_");
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            if (i > 0) {
                sentence.append(' ');
            }
            String word = parts[i].toLowerCase();
            sentence.append(Character.toUpperCase(word.charAt(0)));
            if (word.length() > 1) {
                sentence.append(word.substring(1));
            }
        }
        return sentence.toString();
    }
}
