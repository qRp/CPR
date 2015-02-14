import java.util.*;
import java.io.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Vector;
//import java.io.File;
//import org.nlogo.app.App;

public class SaveNetlogo{
    private String name;
    private ArrayList<Process> lprocess = new ArrayList<Process>();
    private Experience exp;
    private ArrayList<String> fonctionButton = new ArrayList<String>();
    private ArrayList<String> shapeL = new ArrayList<String>();
    private ArrayList<String> colorL = new ArrayList<String>();
    private ArrayList<String> parameterNL = new ArrayList<String>();
    private ArrayList<String> parameterTurtle = new ArrayList<String>();
    private int Xlen = 140;
    private int Ylen = 40;
    private Environnement env;

    public SaveNetlogo(Experience expe){
	    exp = expe;
    }    
    
     private void initFunctionButton(ArrayList<String> functionButton){
        functionButton.add("init");
        functionButton.add("go");
    }
    
    // different shapes of turtles
    private void shapeList(ArrayList<String> shapeL){
        shapeL.add("default");
        shapeL.add("airplane");
        shapeL.add("box");
        shapeL.add("bug");
        shapeL.add("butterfly");
        shapeL.add("car");
        shapeL.add("circle");
        shapeL.add("cow");
        shapeL.add("fish");
        shapeL.add("leaf");
        shapeL.add("line");
        shapeL.add("pentagon");
        shapeL.add("plant");
        shapeL.add("star");
        shapeL.add("target");
        shapeL.add("triangle");
        shapeL.add("truck");
        shapeL.add("turtle");
        shapeL.add("x");
    }
    
    // different turtle colors
    private void colorList(ArrayList<String> colorL){
        colorL.add("red");
        colorL.add("blue");
        colorL.add("white");
        colorL.add("green");
        colorL.add("yellow");
        colorL.add("orange");
        colorL.add("brown");
        colorL.add("cyan");
        colorL.add("pink");
        colorL.add("lime"); 
        colorL.add("turquoise");
        colorL.add("sky");  
        colorL.add("violet");
        colorL.add("magenta");       
    }
    
    // global parameters: name and value
    private void createParameterNL(ArrayList<String> parameterNL){
        parameterNL.add("base-speed");
        parameterNL.add("1");
        parameterNL.add("waver");
        parameterNL.add("30");
        parameterNL.add("near-radius");
        parameterNL.add("1");
        parameterNL.add("far-radius");
        parameterNL.add("4");
        parameterNL.add("vision-distance");
        parameterNL.add("1");
        parameterNL.add("vision-cone");
        parameterNL.add("360");
        parameterNL.add("updraft-distance");
        parameterNL.add("3");
        parameterNL.add("too-close");
        parameterNL.add("1");
        parameterNL.add("max-turn");
        parameterNL.add("40");
        parameterNL.add("speed-change-factor");
        parameterNL.add("0.9");
    }
    
    // turtle parameters: name and value
    private void createParameterTurtle(ArrayList<String> parameterTurtle){
        parameterTurtle.add("speed");
        parameterTurtle.add("1");
        parameterTurtle.add("leader");
        parameterTurtle.add("nobody");
        parameterTurtle.add("follower");
        parameterTurtle.add("nobody");
        parameterTurtle.add("visible-neighbors");
        parameterTurtle.add("nobody");
        parameterTurtle.add("closest-neighbor");
        parameterTurtle.add("nobody");
        parameterTurtle.add("happy?");
        parameterTurtle.add("false");
    }
    
    // write netlogo file
    public String writeFile(){
        int Xpos = 0;
        int Ypos = 0; 
        ArrayList<String> functionL = new ArrayList<String>();
		try{
			env = exp.getenvironnement();
            System.out.println("test emi "+env);
			name = exp.getname();
			name = "./../nlogo/"+name+".nlogo";
			BufferedWriter buff=new BufferedWriter(new FileWriter(name));
            
            //create main code
            createParameterNL(parameterNL);
            createParameterTurtle(parameterTurtle);
            ArrayList<Agent> lagent = exp.getlagent();
            initCode(buff, lagent, parameterNL, parameterTurtle);
            createCode(buff, exp);            
            
			// create graphic window
			buff.write("@#$#@#$#@");
			buff.newLine();
			buff.write("GRAPHICS-WINDOW");
			buff.newLine();
			System.out.println("fenetre b ");
			createGraphicWindow(buff, env);
			System.out.println("fenetre e ");
			
			// create buttons
			System.out.println("button b ");
			initFunctionButton(functionL);
			shapeList(shapeL);
			colorList(colorL);
			for (int i=0; i<functionL.size();i++){
			    buff.newLine();
			    String functionName = functionL.get(i);
			    Ypos = 0;
			    Xpos += i*Xlen;
			    createButton(buff, functionName, Xpos, Ypos);
			}
			System.out.println("button e ");
						
			//create sliders or switch
			Xpos = 0;
			for (int i=0 ; i<lagent.size() ; i++){
			    System.out.println("agent " + i);
                ArrayList<Descripteur> lDescripteur = new ArrayList<Descripteur>();
                ArrayList<Float> lValue = new ArrayList<Float>();
                
                Agent agentCara = lagent.get(i);
                String agentName = agentCara.getname();
                Caracteristique cara = agentCara.getCaracteristique();
                lDescripteur = cara.getDescripteur();
			    String namePop = agentName + "_Pop";
			    
			    //create Chooser
			    System.out.println("create chooser");
			    String nameShape = agentName + "_Shape";
			    createChooserString(buff, nameShape, Xpos+Xlen, Ypos+Ylen, shapeL);
			    String nameColor = agentName + "_Color";
			    createChooserInt(buff, nameColor, Xpos+Xlen, Ypos+2*Ylen, colorL);
		
                for (int j=0 ; j<lDescripteur.size() ; j++){
                    System.out.println("des " + j);
                    Descripteur des = lDescripteur.get(j);
                    String desName = des.getname();
                    String varName = agentName + "_" + desName;
                    lValue = des.getvalues();
                    float f = des.getvalue();
                    System.out.println("float val " + f);
                    if (des.gettype()=="float"){
                        Ypos += Ylen;
                        createSlider(buff, varName, Xpos, Ypos, lValue);
                    } 
                    if (des.gettype()=="boolean"){
                        createSwitch(buff, varName, Xpos, Ypos, lValue);
                    }
                }
			}
			
            // TODO: create plot
            buff.newLine();
            writeFileNL(buff, "./nlogo-file/endFileNetlogo.nlogo");
			buff.flush(); 
			buff.close();
			return name;
		}
		catch(Exception e){
		    System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/writeFile()");
		    return null;
		}
	}

    // create initialization code
	private void initCode(BufferedWriter buff, ArrayList<Agent> lAgent, ArrayList<String> parameterNL, ArrayList<String> parameterTurtle){
	    try{
	        // turtles-own
	        if (parameterTurtle.size()!=0){
	            buff.write("turtles-own [\n");
	            for (int i=0 ; i<parameterTurtle.size() ; i+=2){
	                String nameParam = parameterTurtle.get(i);
	                buff.write("\t"+nameParam+"\n");
                }
                buff.write("]\n");
	        }
	        
	        // create global parameters
	        if (parameterNL.size()!=0){
	            buff.write("globals[\n");
	            for (int i=0 ; i<parameterNL.size() ; i+=2){
	                String nameParam = parameterNL.get(i);
	                buff.write("\t"+nameParam+"\n");
                }
                buff.write("]\n");
	        }
	        
	        // breed new agents
	        for (int i=0 ; i<lAgent.size() ; i++){
                Agent ag = lAgent.get(i);
                buff.write("breed ["+ag.getname()+" i"+ag.getname()+"]\n"); 
            }
            
            // write init
            buff.write("\nto init \n");
            buff.write("\tclear-all \n");
            if (parameterNL.size()!=0){
	            for (int i=0 ; i<parameterNL.size() ; i+=2){
	                String nameParam = parameterNL.get(i);
	                String valueParam = parameterNL.get(i+1);
	                buff.write("\tset "+nameParam+" "+valueParam+"\n");
                }
	        }
	        for (int i=0 ; i<lAgent.size() ; i++){
                Agent ag = lAgent.get(i);
                Caracteristique cara = ag.getCaracteristique();
                ArrayList<Descripteur> lDescripteur = cara.getDescripteur();     
                String population = "20";
                for (int j=0 ; j<lDescripteur.size() ; j++){
                    Descripteur des = lDescripteur.get(j);
                    if (des.getname()=="population"){
                        float pop = des.getvalue();
                        population = floatToString(pop);
                    }
                }
                buff.newLine();
                buff.write("\t create-"+ag.getname()+" "+population+"[\n");
                buff.write("\tset color "+ag.getname()+"_Color\n");
                buff.write("\tset shape "+ag.getname()+"_Shape\n");
                buff.write("\tsetxy random-xcor random-ycor\n");
    	        if (parameterTurtle.size()!=0){
	                for (int j=0 ; j<parameterTurtle.size() ; j+=2){
	                    String nameParam = parameterTurtle.get(j);
	                    String valueParam = parameterTurtle.get(j+1);
	                    buff.write("\tset "+nameParam+" "+valueParam+"\n");
                    }
	            } 
                //buff.write("\tset speed 1\n");
                buff.write("\t]\n");
            }
            buff.write("\t reset-ticks\n");
            buff.write("end\n");
        }
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/initCode()");}
	}
	
	// create the go function
	private void createCode(BufferedWriter buff, Experience exp){
	    try{
	        lprocess = exp.getlprocess();
	        buff.write("to go\n");
	        for (int j=0 ; j<lprocess.size() ; j++){
                Process p = lprocess.get(j);
	            String nameP = p.getname();
	            ArrayList<Agent> lAgent = p.getAgentsCibles();
	            if (lAgent.size()!=0){
	                for (int i=0 ; i<lAgent.size() ; i++){
	                    Agent agentCara = lAgent.get(i);
	                    System.out.println(agentCara);
	                }
	            }
	            Agent ag = p.getAgent();
	            String agName = ag.getname();
	            if (nameP=="Indifferencie"){
	                buff.write("\task "+agName+" [\n");
	                buff.write("\t\tif leader = nobody [ attach-turtle ] \n");
	                buff.write("\t]\n");
	                buff.write("\task "+agName+" [turn-turtle ]\n");
	                buff.write("\task "+agName+" [fd speed ]\n");
	                buff.write("\t]\n");
	            }
	            else{
	                buff.write("\task "+agName+" [\n");
	                buff.write("\tset visible-neighbors (other turtles in-cone vision-distance vision-cone)\n");
	                buff.write("\tifelse any? visible-neighbors\n");
	                buff.write("\t[ adjust\n");
	                buff.write("\tset happy? true ]\n");
	                buff.write("\t[ set happy? false ]\n");
	                buff.write("\tfd speed\n");
	                buff.write("\t]]");
	            }
	        }
	        buff.write("\ttick\n");
	        buff.write("end");
	        buff.newLine();
	        writeFileNL(buff, "./nlogo-file/fixation.nlogo");
        }
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createCode()");}
	}

    
    //create button for the 2 functions (init and go)
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
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createButton()");} // toutes les exceptions
    }
    
    //create Switch in case of Boolean 
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
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createSwitch()");} // toutes les exceptions
    }
    
    //create Slider in case of int or float
    public void createSlider(BufferedWriter buff, String nameButton, int Xpos, int Ypos, ArrayList<Float> values){
        String x = Integer.toString(Xpos);
        String y = Integer.toString(Ypos);
        String xl = Integer.toString(Xlen);
        String yl = Integer.toString(Ylen);
        String value1 = floatToString(values.get(0));
        String min1 = floatToString(values.get(1));
        String max1 = floatToString(values.get(2));
        String pas1 = floatToString(values.get(3));
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
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createSlider()");} // toutes les exceptions
    }
    
    //create Chooser in case of string (shape)
    public void createChooserString(BufferedWriter buff, String nameChooser, int Xpos, int Ypos, ArrayList<String> lvalues){
        String x = Integer.toString(Xpos);
        String y = Integer.toString(Ypos);
        String xl = Integer.toString(Xlen);
        String yl = Integer.toString(Ylen);
        try{ 
            buff.newLine();       
            buff.write("CHOOSER");
			buff.newLine();
			buff.write(x);
			buff.newLine();
        	buff.write(y);
			buff.newLine();
        	buff.write(xl);
			buff.newLine();
        	buff.write(yl);
			buff.newLine();
        	buff.write(nameChooser);
			buff.newLine();
        	buff.write(nameChooser);
			buff.newLine();
			String sL = "";
        	for (int j=0 ; j<lvalues.size() ; j++){
                String s = lvalues.get(j);
                sL = sL+" \""+s+"\"";
            } 
            buff.write(sL);
            buff.newLine(); 
        	buff.write("1");
        	buff.newLine();
        }
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createChooserString()");} // toutes les exceptions
    }
    
        //create Chooser in case of int (color)
    public void createChooserInt(BufferedWriter buff, String nameChooser, int Xpos, int Ypos, ArrayList<String> lvalues){
        String x = Integer.toString(Xpos);
        String y = Integer.toString(Ypos);
        String xl = Integer.toString(Xlen);
        String yl = Integer.toString(Ylen);
        try{ 
            buff.newLine();       
            buff.write("CHOOSER");
			buff.newLine();
			buff.write(x);
			buff.newLine();
        	buff.write(y);
			buff.newLine();
        	buff.write(xl);
			buff.newLine();
        	buff.write(yl);
			buff.newLine();
        	buff.write(nameChooser);
			buff.newLine();
        	buff.write(nameChooser);
			buff.newLine();
			String sL = "";
        	for (int j=0 ; j<lvalues.size() ; j++){
                String s = lvalues.get(j);
                sL = sL+" "+s;
            } 
            buff.write(sL);
            buff.newLine(); 
        	buff.write("1");
        	buff.newLine();
        }
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createChooserInt()");} // toutes les exceptions
    }
    
    // create graphic window (size, position...)
    public void createGraphicWindow(BufferedWriter buff, Environnement env){
        try{   
        	int xlen = env.getx();
        	int ylen = env.gety();
        	String Xlen = Integer.toString(xlen);
        	String Ylen = Integer.toString(ylen);
        	buff.write("300\n");
        	buff.write("0\n");
        	buff.write("649\n");
        	buff.write("470\n");
        	buff.write(Xlen+"\n");
        	buff.write(Ylen+"\n");
        	buff.write("13.0\n");
        	buff.write("1\n");
        	buff.write("10\n");
        	buff.write("1\n");
        	buff.write("1\n");
        	buff.write("1\n");
        	buff.write("0\n");
        	buff.write("1\n");
        	buff.write("1\n");
        	buff.write("1\n");
        	buff.write("-"+Xlen+"\n");
        	buff.write(Xlen+"\n");
        	buff.write("-"+Ylen+"\n");
        	buff.write(Ylen+"\n");
        	buff.write("0\n");
        	buff.write("0\n");
        	buff.write("1\n");
        	buff.write("ticks\n");
        	buff.write("30.0\n");
        	buff.newLine();
    	}
    	catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/createGraphicWindow()");} // toutes les exceptions
    }
    
    // write txt file
    public void writeFileNL(BufferedWriter buff, String fileNL){
        try (FileReader fileIn = new FileReader(fileNL)){
            BufferedReader buffR = new BufferedReader(fileIn);
            String info;
            while ((info = buffR.readLine()) != null){
                buff.write(info);
                buff.newLine();
            }
            fileIn.close();
        }
        catch(Exception e){System.out.println("FATAL ERROR SYSTEM - SaveNetlogo.java/writeFileNL");} // toutes les exceptions
        
    }
    private String floatToString(float fVal){
        String sValue = Float.toString(fVal);
        return sValue;
    }

}
