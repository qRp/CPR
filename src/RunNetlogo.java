import org.nlogo.app.App;
import java.awt.EventQueue;


public class RunNetlogo {
    private String nameFile;
    
    public RunNetlogo(String nname){
        nameFile=nname;
    } 
    
    public void run() {
        //App.main(argv);
        System.out.println(nameFile);
        try {
            EventQueue.invokeAndWait
                ( new Runnable()
                    { public void run() {
                        try {
                          App.app().open(nameFile);
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
