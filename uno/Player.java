package uno;

import java.util.List;
import java.util.Scanner;
import uno.constants.Color;

public class Player {

    private String name;
    private List<Card> hand;
    private Color choiceColor;

    public Color getChoiceColor() {
        return this.choiceColor;
    }

    public void ChooseColor() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choisissez une couleur : ");
        System.out.println("1 - Rouge");
        System.out.println("2 - Vert");
        System.out.println("3 - Bleu");
        System.out.println("4 - Jaune");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                this.choiceColor = Color.RED;
            case 2:
                this.choiceColor = Color.GREEN;
            case 3:
                this.choiceColor = Color.BLUE;
            case 4:
                this.choiceColor = Color.YELLOW;
            default:
                System.out.println("Choix invalide, couleur par défaut = Rouge");
                this.choiceColor = Color.RED;// si j ai le temps la mettre en random et non red par defaut : en
                                             // choissisant un nombre random de 1 a 4 et de repasser le choix sans le
                                             // relire !
        }
        sc.close();
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', hand=" + hand.size() + " cards}";
    }

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    public void Draw(Game game) {
        Card card = game.drawCard();
        if (card != null)
            hand.add(card);

    }
}
