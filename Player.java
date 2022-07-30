import java.util.Scanner;
public class Player {
    public String name;
    public int bankamount;
    public int currentamount;
    public int choice;
    public Wheel w;
    Scanner cin=new Scanner(System.in);
    public char letterguess;
    public char[] letterbank=new char[26];
    public int num=0;
    public boolean win;
    public Player(){
        name="Player";
        bankamount=0;
        currentamount=0;
    };
    public Player(String n, int ba, int ca){
        name=n;
        bankamount=ba;
        currentamount=ca;
    }

    public void take_turn(Puzzle p){
        System.out.println("Clue: "+p.hint);
        p.display();
        System.out.println(name+"'s turn:");
        System.out.print("1. Spin the Wheel \n2. Solve the puzzle \n3. Buy a vowel for $250\nMake a selection: ");
        choice=cin.nextInt();
        do{
            if(choice==1){
               spin(p);
            }
            else if(choice==3){
                buyVow(p);
            }
            else if(choice==2) {
                solve(p);
            }
        }while(!((choice==1)||(choice==2)||(choice==3)));

        p.replace(letterguess);
        System.out.println("Amount in your bank: $"+bankamount);
        System.out.println("___________________________________________________________________________________");



    }
    public char guess(Puzzle p) {
        System.out.print("Select a consonant: ");
        letterguess =cin.next().charAt(0);
        letterguess=Character.toLowerCase(letterguess);
        if(!p.is_conso(letterguess)){
            while(!p.is_conso(letterguess)){
                System.out.print("Please enter a consonant: ");
                letterguess=cin.next().charAt(0);
            }
        }
        checkletter(p);
        return letterguess;

    }

    public int spin(Puzzle p){
        letterguess=Character.toLowerCase(letterguess);
        int money=w.spin();
        if(money==-1){
            System.out.println("You went bankrupt :o!");
            currentamount=0;
        }
        else{
            System.out.println("You spun: "+money);
            guess(p);
            currentamount=money*(p.letterfound(letterguess));
            if(p.letterfound(letterguess)==0){
                System.out.println("Sorry that is incorrect");
            }
        }
        bankamount+=currentamount;
        return currentamount;
    }

    public boolean solve(Puzzle p){
        String guess;
        System.out.print("Solve the puzzle: ");
        guess=cin.next();
        if(guess==p.answer) {
            currentamount += 1000;
            bankamount += currentamount;
            p.game=true;
            win=true;
            System.out.println("Yes! You win!");
            return true;
        }
        else {
            p.game=true;
            System.out.println("Sorry that's the wrong answer. You lost!");
            return false;
        }

    }

    public void buyVow(Puzzle p){
        bankamount-=250;
        System.out.print("Select a vowel: ");
        letterguess=cin.next().charAt(0);
        letterguess=Character.toLowerCase(letterguess);
        if(!p.is_vowel(letterguess)){
            while(!p.is_vowel(letterguess)){
                System.out.print("Please enter a vowel: ");
                letterguess=cin.next().charAt(0);
            }
        }
        if(p.has_vowels()){
            p.letterfound(letterguess);
        }
        else{
            System.out.println("Wrong letter!");
        }


    }


    public void checkletter(Puzzle p){
        String hold=p.strOF(letterbank,letterbank.length);
        for(int i=0;i<hold.length();i++){
            while(letterguess==hold.charAt(i)){
                System.out.print("Please enter a different letter: ");
                letterguess=cin.next().charAt(0);
            }
        }
        letterbank[num]=letterguess;
        num++;

    }

}

