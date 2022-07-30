import java.lang.String;
public class Puzzle {
    public String answer;
    public String hint;
    public int size;
    public boolean has_vowels;
    public boolean solve;
    public String underscore;
    public char[] us_array;
    public boolean game=false;
    public String[] puzzle=new String[]{"After All Tomorrow Is Another Day","Beetlejuice Beetlejuice Beetlejuice",
        "Bond James Bond", "Bye Felicia","Feed Me Feed Me","Frankly My Dear I Dont Give A Damn",
    "Go Ahead Make My Day","Heres Looking At You Kid","How Do You Like Them Apples","I Am Serious And Dont Call Me Shirley",
    "I Drink Your Milkshake","I Feel The Need For Speed","I'll Be Back","Ill Get You My Pretty And Your Little Dog Too",
    "Im Gonna Make Him An Offer He Cant Refuse","Im The King Of The World","If You Build It He Will Come","It's Showtime",
    "Keep The Change Ya Filthy Animal","Lion And Tigers And Bears Oh My","Luca Brasi Sleeps With The Fishes","Release The Kraken",
    "Theres No Place Like Home","Use The Force Luke","Welcome To The Party Pal","You Had Me At Hello","You Shall Not Pass",
    "Youre Gonna Need A Bigger Boat","Youre Killin Me Smalls"};



    //Constructors
    public Puzzle(){
        hint="Movie Quote";
        int num=(int)(Math.random()*29);
        answer=puzzle[num];
        size=answer.length();
        us_array=answer.toCharArray();


    }
    public Puzzle(String s, String h) {
        answer = s;
        hint = h;
        size = answer.length();
        us_array=answer.toCharArray();
    }

    //Set us_array to all underscores
    public void make_US() {
        for(int i=0;i<us_array.length;i++){
            if(us_array[i]!=' '){
                us_array[i]='_';
            }
        }
    }
    //Displays underscore puzzle view
    public void display() {
        for(int i=0;i<us_array.length;i++) {
            System.out.print(us_array[i]+" ");
        }
        System.out.println();
    }

    //Prints out the answer
    public void reveal(){
        System.out.println(answer);
    }

    //Converts char array a to a string
    public static String strOF(char[] a, int size) {
        String word="";
        for(int i=0;i<size; i++){
            word =word+a[i];
        }
        return word;
    }

    //returns the amount of letter c found in
    public int letterfound(char c){
        int num=0;
        for(int i=0;i<us_array.length;i++){
            if(answer.charAt(i)==c){
                num++;
            }
        }
        return num;
    }
    public void replace(char c){
        int num=0;
        char hold;
        for(int i=0; i<us_array.length;i++){
            hold=Character.toLowerCase(answer.charAt(i));
            if(c==hold){
                us_array[i]=answer.charAt(i);
                num++;
            }
        }
        if(num==us_array.length){
            game=true;
        }
    }



    public static boolean is_conso(char c) {
        if(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u'){
            return true;
        }
        else
            return false;
    }

    public static boolean is_vowel(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'|c=='u'){
            return true;
        }
        else
            return false;
    }

    public boolean has_vowels(){
        int num=0;
        char c=answer.charAt(0);
        for(int i=0;i<size &&(c!='a'&&c!='e'&&c!='i'&&c!='o'&&c!='u');i++){
            c=answer.charAt(i);
            num++;
        }
        if(answer.length()==num+1)
            return false;
        else
            return true;


    }
}
