public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Kael");
        System.out.println(warrior.attack());
        System.out.println(warrior.attack("Iron Sword"));
        System.out.println(warrior.defend());
        System.out.println(warrior.getSpecialMove());
        System.out.println(warrior.getCharacterId());
        Trap trap = new Trap("Spike Pit");
        System.out.println(trap.defend());
        GameCharacter.resolveDefense(new Defendable[] {warrior, trap});
    }
}
