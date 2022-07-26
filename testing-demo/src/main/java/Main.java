import rpg_lab.Axe;

public class Main {

    public static void main(String[] args) {
        Axe axe = new Axe(13, 42);

        System.out.println(axe.getAttackPoints());
        System.out.println(axe.getDurabilityPoints());
    }

}
