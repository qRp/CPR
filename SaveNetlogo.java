import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.io.File;

public class SaveNetlogo{
    private String name;
    /*
    private ArrayList<Process> lprocess = new ArrayList<Process>();
    private ArrayList<BioAgent> lagent = new ArrayList<BioAgent>();
    */
    private Process lprocess;
    private Experience exp;
    private ArrayList<String> fonctionButton = new ArrayList<String>();
    private int Xlen = 140;
    private int Ylen = 40;
    private Environnement env;

/*
    public SaveNetlogo(String nameFile, ArrayList<Process> processes, ArrayList<BioAgent> bioagent, Environnement envSimu){
	name = nameFile;
	lprocess = processes;
	lagent = bioagent;
    }
*/
    public SaveNetlogo(String nameFile, Process processes, Experience expe, Environnement env2D){
	    name = nameFile;
	    lprocess = processes;
	    exp = expe;
	    env = env2D;
    }    
    
    public void writeFile(){
        int Xpos = 0;
        int Ypos = 0; 
        ArrayList<String> functionL = new ArrayList<String>();
		try{
		    
			BufferedWriter buff=new BufferedWriter(new FileWriter(name+".nlogo"));

			buff.write("@#$#@#$#@");
			buff.newLine();
			buff.write("GRAPHICS-WINDOW");
			buff.newLine();
			// create graphic window
			System.out.println("fenetre b ");
			createGraphicWindow(buff, env);
			System.out.println("fenetre e ");
			
			// create buttons
			System.out.println("button b ");
			initFunctionButton(functionL);
			for (int i=0; i<functionL.size();i++){
			    buff.newLine();
			    String functionName = functionL.get(i);
			    //calculer le bonne valeur des cordonnees des points
			    Ypos = 0;
			    Xpos += i*Xlen;
			    createButton(buff, functionName, Xpos, Ypos);
			}
			System.out.println("button e ");
						
			//create sliders
			ArrayList<Agent> lagent = exp.getlagent();
			Xpos = 0;
			for (int i=0 ; i<lagent.size() ; i++){
			    System.out.println("agent " + i);
                ArrayList<Descripteur> lDescripteur = new ArrayList<Descripteur>();
                ArrayList<Float> lValue = new ArrayList<Float>();
                ArrayList<Float> lTmp = new ArrayList<Float>();
                
                Agent agentCara = lagent.get(i);
                String agentName = agentCara.getname();
                Caracteristique cara = agentCara.getCaracteristique();
                lDescripteur = cara.getDescripteur();
			    String namePop = agentName + "_Pop";
			    // TODO: pop a mettre dans le descripteur
                for (int j=0 ; j<lDescripteur.size() ; j++){
                    System.out.println("des " + j);
                    Descripteur des = lDescripteur.get(j);
                    String desName = des.getname();
                    String varName = agentName + "_" + desName;
                    lValue = des.getvalues();
                    float f = des.getvalue();
                    System.out.println("float val " + f);
                    if (des.gettype()=="float"){
                        //float f = des.getvalue();
                        //System.out.println("des Value " + f);
                        Ypos += Ylen;
                        createSlider(buff, varName, Xpos, Ypos, lValue);
                    } 
                    if (des.gettype()=="boolean"){
                        createSwitch(buff, varName, Xpos, Ypos, lValue);
                    }
                }
			}
			
			/*
			//reccup tous les descripteurs des agents et du type d'agent
			//if values: slider (default values if no information)
			//if boolean: switch
            */
            // create plot
            buff.newLine();
            endFile(buff);
			buff.flush(); 
			buff.close();
			
		}
		catch(Exception e){System.out.println("Emergeance 1");} // toutes les exceptions
	}

    private void initFunctionButton(ArrayList<String> functionButton){
        functionButton.add("init");
        functionButton.add("go");
    }
    
    //create button 
    public void createButton(BufferedWriter buff, String nameButton, int Xpos, int Ypos){
        String x = Integer.toString(Xpos);
        String y = Integer.toString(Ypos);
        String xl = Integer.toString(Xlen);
        String yl = Integer.toString(Ylen);
        try{        
            buff.write("BUTTON");
			buff.newLine();
			buff.write(x);
			buff.newLine();
        	buff.write(y);
			buff.newLine();
        	buff.write(xl);
			buff.newLine();
        	buff.write(yl);
			buff.newLine();
        	buff.write(nameButton);
			buff.newLine();
        	buff.write(nameButton);
			buff.newLine();
        	if (nameButton=="go"){buff.write("T");
			buff.newLine();}
        	else {buff.write("NIL");
			buff.newLine();}
        	buff.write("1");
			buff.newLine();
        	buff.write("T");
			buff.newLine();
        	buff.write("OBSERVER");
			buff.newLine();
        	buff.write("NIL");
			buff.newLine();
        	buff.write("NIL");
			buff.newLine();
        	buff.write("NIL");
			buff.newLine();
        	buff.write("NIL");
			buff.newLine();
        	buff.write("1");
			buff.newLine();
        }
        catch(Exception e){System.out.println("Emergeance 2");} // toutes les exceptions
    }
    
    //create button 
    public void createSwitch(BufferedWriter buff, String nameButton, int Xpos, int Ypos, ArrayList<Float> value){
        String x = Integer.toString(Xpos);
        String y = Integer.toString(Ypos);
        String xl = Integer.toString(Xlen);
        String yl = Integer.toString(Ylen);
        float fValue = value.get(0);
        int iValue = (int)(Math.round(fValue));
        String sValue = Integer.toString(iValue);
        try{ 
            buff.newLine();       
            buff.write("SWITCH");
			buff.newLine();
			buff.write(x);
			buff.newLine();
        	buff.write(y);
			buff.newLine();
        	buff.write(xl);
			buff.newLine();
        	buff.write(yl);
			buff.newLine();
        	buff.write(nameButton);
			buff.newLine();
        	buff.write(nameButton);
			buff.newLine();
        	buff.write("1");
			buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("-1000");
        	buff.newLine();
        }
        catch(Exception e){System.out.println("Emergeance 6");} // toutes les exceptions
    }
    
    //create button 
    public void createSlider(BufferedWriter buff, String nameButton, int Xpos, int Ypos, ArrayList<Float> values){
        String x = Integer.toString(Xpos);
        String y = Integer.toString(Ypos);
        String xl = Integer.toString(Xlen);
        String yl = Integer.toString(Ylen);
        String value1 = floatToString(values.get(0));
        String min1 = floatToString(values.get(1));
        String max1 = floatToString(values.get(2));
        String pas1 = floatToString(values.get(3));
        /*
        String min1 = "1";
        String max1 = "10";
        String value1 = "5";
        String pas1 = "1";
        */
        try{   
            buff.newLine();     
            buff.write("SLIDER");
			buff.newLine();
			buff.write(x);
			buff.newLine();
        	buff.write(y);
			buff.newLine();
        	buff.write(xl);
			buff.newLine();
        	buff.write(yl);
			buff.newLine();
        	buff.write(nameButton);
			buff.newLine();
        	buff.write(nameButton);
			buff.newLine();
        	buff.write(min1);
			buff.newLine();
        	buff.write(max1);
        	buff.newLine();
        	buff.write(value1);
        	buff.newLine();
        	buff.write(pas1);
        	buff.newLine();
        	buff.write("1");
			buff.newLine();
        	buff.write("NIL");
        	buff.newLine();
        	buff.write("HORIZONTAL");
        	buff.newLine();
        }
        catch(Exception e){System.out.println("Emergeance 5");} // toutes les exceptions
    }
    
    public void createGraphicWindow(BufferedWriter buff, Environnement env){
        try{   
        	int xlen = env.getx();
        	int ylen = env.gety();
        	String Xlen = Integer.toString(xlen);
        	String Ylen = Integer.toString(ylen);
        	buff.write("300");
        	buff.newLine();
        	buff.write("0");
        	buff.newLine();
        	buff.write("649");
        	buff.newLine();
        	buff.write("470");
        	buff.newLine();
        	buff.write(Xlen);
        	buff.newLine();
        	buff.write(Ylen);
        	buff.newLine();
        	buff.write("13.0");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("10");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("0");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("-".concat(Xlen));
        	buff.newLine();
        	buff.write(Xlen);
        	buff.newLine();
        	buff.write("-".concat(Ylen));
        	buff.newLine();
        	buff.write(Ylen);
        	buff.newLine();
        	buff.write("0");
        	buff.newLine();
        	buff.write("0");
        	buff.newLine();
        	buff.write("1");
        	buff.newLine();
        	buff.write("ticks");
        	buff.newLine();
        	buff.write("30.0");
        	buff.newLine();
    	}
    	catch(Exception e){System.out.println("Emergeance 3");} // toutes les exceptions
    }
    
    public void endFile(BufferedWriter buff){
        try (FileReader fileIn = new FileReader("endFileNetlogo.nlogo")){
            BufferedReader buffR = new BufferedReader(fileIn);
            String info;
            while ((info = buffR.readLine()) != null){
                buff.write(info);
                buff.newLine();
            }
            fileIn.close();
        }
        catch(Exception e){System.out.println("Emergeance 4");} // toutes les exceptions
        
    }
    private String floatToString(float fVal){
        int iValue = (int)(Math.round(fVal));
        String sValue = Integer.toString(iValue);
        return sValue;
    }

}
