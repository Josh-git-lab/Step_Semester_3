public abstract class GameCharacter {
    private static int nextNumber = 1000;
    private final String characterId;

    public GameCharacter() {
        nextNumber++;
        characterId = "CHR-" + nextNumber;
    }

    public abstract String getSpecialMove();

    public String getCharacterId() {
        return characterId;
    }

    public static void resolveDefense(Defendable[] combatants) {
        for (int i = 0; i < combatants.length; i++) {
            System.out.println(combatants[i].defend());
        }
    }
}
