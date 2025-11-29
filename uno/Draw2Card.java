package uno;


import uno.constants.Color;

public class Draw2Card extends Card implements Actionable {

    public Draw2Card(Color color) {
        super(color);
    }
@Override
public String toString() {
    return "Draw2Card{color=" + getColor() + "}";
}

    @Override
    public boolean canBePlayedOn(Card currentCard) {
        if (currentCard==null) return true;//makach aucune carte sur table mais y en a toujours une normalement?

        if (this.getColor() == currentCard.getColor() ) {// same color (sapplique aussi avec le wild car on va changer currentclor of current card)
            return true;
        }
        return false;
    }

    public void applyEffect(Game game) {
        Player nextPlayer = game.getNextPlayer( player);//jsp emcore comment choisir mon joueur
        for (int i = 0; i < 2; i++) {
            nextPlayer.Draw(game);
        }
        game.skipNextPlayer();

    }
}
