import org.nlogo.app.App;
import java.awt.EventQueue;


public class RunNetlogo {
    
    public static void main(String[] argv) {
        final String nameFile = argv[0];
        String[] arg = new String[0];
        System.out.println(nameFile);
        App.main(arg);
        try {
            EventQueue.invokeAndWait
                ( new Runnable()
                    { public void run() {
                        try {
                          //App.app().open(nameFile);
                          App.app().open("./../nlogo/"
                          +nameFile);
                        }
                        catch( java.io.IOException ex ) {
                          ex.printStackTrace();
                          System.out.println("e1");
                        }
                    } } );
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("e2");
        }
    }
}
