package blackjack;

import java.util.Random;
import java.util.Scanner;
public class Game {
    Card cards[]=new Card[52];//has 52card
    Player players[]=new Player[4];//4 players
    Random rand=new Random();
    static int highScore=0;
    //int highScore=0;
    Scanner input=new Scanner(System.in);



    int idx=0;
    public void insertCards(){
        for(int i=0;i<4;++i){
            for(int j=0;j<13;++j){
                if(j>=10){
                    cards[idx]=new Card(i,j,10);
                }
                else{
                    cards[idx]=new Card(i,j,j+1);
                }
                idx++;
            }

        }
    }

    public Card pullingCard(){
        while(true){
            int randChoice=rand.nextInt(52);
            if(cards[randChoice]!=null){
                Card validCard;
                validCard=cards[randChoice];
                cards[randChoice]=null;
                return validCard;
            }
        }

    }

    public void updateHighScore(int index){
        if(players[index].score>highScore&&players[index].score<=21){
            highScore=players[index].score;
        }
    }

    public void updateScore(int index){
        updateHighScore(index);

        if(players[index].score==21){
            players[index].blackJack=true;
        }
        else if(players[index].score>21){
            players[index].busted=true;
        }
//        else if(players[index].score>=highScore&&players[index].score<=21){
//            players[index].busted=false;
//
//        }
    }

    public void insertPlayers(){
        for(int i=0;i<3;++i){
            System.out.println("please enter the name of "+(i+1)+" player");
            players[i]=new Player();
            players[i].Name=input.next();
            players[i].arrofcards[0]=pullingCard();
            players[i].arrofcards[1]=pullingCard();


            players[i].score+=players[i].arrofcards[0].getValue();
            players[i].score+=players[i].arrofcards[1].getValue();
        }
        //dellar
        players[3]=new Player();
        players[3].Name="Dellar";
        players[3].arrofcards[0]=pullingCard();
        players[3].arrofcards[1]=pullingCard();
        players[3].score+=players[3].arrofcards[0].getValue();
        players[3].score+=players[3].arrofcards[1].getValue();

        System.out.println("player 1"+players[0].score);
        System.out.println("player 2"+players[1].score);
        System.out.println("player 3"+players[2].score);
        System.out.println("player 4"+players[3].score);

    }
    int index=2;
    public  void addCard(int numofplayer,Card c){
        if(index<11){
            players[numofplayer].arrofcards[index]=c;
            players[numofplayer].score+=players[numofplayer].arrofcards[index].getValue();
           // System.out.println("player new score "+players[numofplayer].score);
          //  updateHighScore(numofplayer);

            index++;

        }
      /*  else
            index=2;*/


    }
    int indx=2;
    public void delaradd(Card c){
        players[3].arrofcards[indx]=c;
    }


}
