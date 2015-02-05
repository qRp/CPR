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
    private Agent lagent;
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
    public SaveNetlogo(String nameFile, Process processes, Agent bioagent, Environnement env2D){
	    name = nameFile;
	    lprocess = processes;
	    lagent = bioagent;
	    env = env2D;
    }    
    
    public void writeFile(){ 
        ArrayList<String> functionL = new ArrayList<String>();
		try{
		    
			BufferedWriter buff=new BufferedWriter(new FileWriter(name+".nlogo"));
			/*
			File tmp = File.createTempFile("test",".tmp");
			String absolutePath = tmp.getAbsolutePath();
			System.out.println("File " + absolutePath);
			*/
			//buff.write("code:RADE");
			//buff.newLine();
			
			// create pseudo-code
			/*
		    for(Process process : lprocess){
		        output.write("process:"+process.getname()+"\n");
		    }
			*/
			buff.write("@#$#@#$#@");
			buff.newLine();
			buff.write("GRAPHICS-WINDOW");
			buff.newLine();
			// create graphic window
			createGraphicWindow(buff, env);
			
			// create buttons
			initFunctionButton(functionL);
			for (int i=0; i<functionL.size();i++){
			    buff.newLine();
			    String functionName = functionL.get(i);
			    //calculer le bonne valeur des cordonnees des points
			    int Ypos = i*i+i*10;
			    int Xpos = 0;
			    createButton(buff, functionName, Xpos, Ypos);
			}
			/*
			//reccup tous les descripteurs des agents et du type d'agent
			// create slider, comment or switch
			//if values: slider (default values if no information)
			//if value: comment
			//if boolean: switch
			for(BioAgent agent : lagent){
				output.write("agent:"+agent.getname()+"\n");
				agent.save(buff);
				
		    }
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
    

}
