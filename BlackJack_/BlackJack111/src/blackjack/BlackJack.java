package blackjack;
import java.util.Scanner;

public class BlackJack {
    public static Game black=new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        Scanner input = new Scanner(System.in);
        black.insertCards();
        black.insertPlayers();
        gui.runGUI(black.cards, black.players[0].arrofcards, black.players[1].arrofcards, black.players[2].arrofcards, black.players[3].arrofcards);
         //black.playersTurns(gui);

        for (int i = 0; i < 3; i++) {
            boolean flag = true;

            while (flag) {
                System.out.println("Do You Want to   1-Hit   Or   2-Stand ");
                int x = input.nextInt();
                if (x == 1) {
                    Card card = new Card(black.pullingCard());
                    black.addCard(i, card);
                    gui.updatePlayerHand(card, i);

                    System.out.println("player score = "+black.players[i].score);
                } else if (x == 2) {
                    black.updateScore(i);
                    flag = false;
                }
            }

        }
        while (true) {
            if(black.players[3].score<21||black.players[3].score<Game.highScore){
                Card card = new Card(black.pullingCard());
                black.delaradd(card);
                black.players[3].score+=card.getValue();
                gui.updateDealerHand(card, black.cards);

            }
            else{
                System.out.println(black.players[3].score);
                black.updateScore(3);
                break;

            }
           /* if (black.players[3].score == 21 || black.players[3].score >= Game.highScore||black.players[3].score>21) {
                black.updateScore(3);
                break;

            } else {
                Card carddelar = new Card(black.pullingCard());
                black.delaradd(carddelar);
                black.players[3].score+=carddelar.getValue();

               /*  card = new Card(black.pullingCard());
               // black.addCard(3, card);

            }*/
        }
        //System.out.println(Game.highScore);
       for (int i = 0; i < 4; i++) {
            System.out.println(black.players[i].score);
        }
        int countHigherScore = 0;
        int higherScore = -1;
        for (int j = 0; j < 4; j++) {
            if (black.players[j].score == Game.highScore) {
                higherScore = j;
                countHigherScore++;
            }
        }
        int countBlackJack = 0;
        int blackerJack = -1;
        for (int j = 0; j < 4; j++) {
            if (black.players[j].blackJack||black.players[j].score==21) {
                blackerJack = j;
                countBlackJack++;
            }
        }
        for (int i = 0; i < 4; i++) {
        System.out.println("player score "+black.players[i].score);

        }
        if (countBlackJack == 1) {
            System.out.println(black.players[blackerJack].Name+ " is aBlackJack");
        }
        else if (countBlackJack == 0 && countHigherScore == 1) {
            System.out.println(black.players[higherScore].Name + " is The Winner");
        }
        else {
            System.out.println("it’s a tie situation");
        }
    }
}
