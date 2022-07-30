import java.util.Random;
public class Wheel {
    public static int [] amount =
            { 5000, 500, 900,700, 300, 800,550,400,
                    500,600,350,500,900,-1,650,1000,
                    700,0, 800, 500, 450, 500, 300, -1};

    public static int spin(){
        Random r = new Random();
        return amount[r.nextInt(amount.length)];
    }

}
