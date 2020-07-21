import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.io.IOException;

public class Jhava {

    private int hitPoints = 765434567;
    private String greeting = "BLARGH!";

    public static void main(String[] args){
        System.out.println(Hero.makeProclamation());
        System.out.println("Spells:");

        SpellBooks spellBook = new SpellBooks();

        for (String spell : spellBook.spells){
            System.out.println(spell);
        }

        System.out.println("Max spell count: " + SpellBooks.MAX_SPELL_COUNT ); // or
        // "+ SpellBooks.Companion.getMAX_SPELL_COUNT());" if don't have @annotation

        SpellBooks.getSpellBooksGreeting();

        //apologize();

        Function1<String, Unit> translator = Hero.getTranslator();

        translator.invoke("TRUCE");
    }
    @NotNull
    public String utterGreeting(){
        return greeting;
    }
    @Nullable
    public String determineFriendShip(){
        return null;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String getGreeting(){
        return greeting;
    }
    public void setGreeting(String greeting){
        this.greeting = greeting;
    }
    public void offerFood(){
        Hero.handOverFood("pizza");
    }
    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }
    public static void apologize() { //static if will used
        try {
            Hero.acceptApology();
        } catch (IOException e){
            System.out.println("Caught!");
        }
    }
}
