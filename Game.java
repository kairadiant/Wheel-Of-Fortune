public class Game {
    public static void main(String []args){
        Player player1 =new Player("Player 1",0,0);
        Player player2=new Player("Player 2",0,0);
        Player player3=new Player("Player 3",0,0);

        for(int i=0;i<3;i++){
            Puzzle game1= new Puzzle();
            game1.make_US();
            while(!(game1.game)){
                player1.take_turn(game1);
                player2.take_turn(game1);
                player3.take_turn(game1);
            }
            player1.currentamount=0;
            player2.currentamount=0;
            player3.currentamount=0;
            if(player1.win){
                player1.bankamount+=1000;
                player2.bankamount=0;
                player3.bankamount=0;
            }
            else if(player2.win){
                player2.bankamount+=1000;
                player1.bankamount=0;
                player3.bankamount=0;
            }
            else if(player3.win){
                player3.bankamount+=1000;
                player2.bankamount=0;
                player1.bankamount=0;
            }
        }
        System.out.println(player1.name+" $"+player1.bankamount);
        System.out.println(player2.name+" $"+player2.bankamount);
        System.out.println(player3.name+" $"+player3.bankamount);
        if(player1.bankamount>player2.bankamount&&player1.bankamount>player3.bankamount){
            System.out.println(player1.name+" wins");
        }
        else if(player2.bankamount>player1.bankamount&&player2.bankamount>player3.bankamount){
            System.out.println(player2.name+" wins");
        }
        else if(player3.bankamount>player2.bankamount&&player3.bankamount>player1.bankamount){
            System.out.println(player3.name+" wins");
        }
        else{
            System.out.println("You all win!");
        }

    }
}
