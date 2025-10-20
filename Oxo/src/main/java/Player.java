

public class Player {
    private String name;
    private Character choix;

    public Player(String name, Character choix) {
        this.name = name;
        this.choix = choix;
    }

    public String getName() {
        return name;
    }

    public Character getChoix() {
        return choix;
    }
}
