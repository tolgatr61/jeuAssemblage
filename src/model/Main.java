package src.model;

public class Main {

    public static void main(String[] args) {
        int action = 3; // nombre d'actions.
        // On appelle le jeu.
        Game game = new Game();
        game.Play(action);
    }
}
