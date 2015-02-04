
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Parser { 
    private final Path filePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;  
  

  /**
   Constructor.
   @param aFileName full name of an existing, readable file.
  */
    public  Parser(String aFileName){
      filePath = Paths.get(aFileName);
    }
    public Experience getExp(String name_to_find) throws IOException{
	Experience exp = new Experience(name_to_find);
	Scanner scanner = new Scanner(filePath, ENCODING.name());
	String name_exp="";
	String name="";
	String value="";
	while(scanner.hasNextLine()){
	    name_exp=processLine(scanner.nextLine());
	    if (name_exp.equals(name_to_find)){
		System.out.println("here");
		while(scanner.hasNextLine()&&!name.equals("name")){
		    String line=scanner.nextLine();
		    name=getname(line);
		    value=getvalue(line);
		    if(name.equals("process")){
			Process process =new Process(value);
			exp.add_process(process);
		    }
		    if(name.equals("agent")){
			Agent agent =new Agent(value);
			exp.add_agent(agent);
		    }
		}
		return exp;
	    }
	}
	return exp;
    }

    public String getname(String line){
	Scanner scanner = new Scanner(line);
	scanner.useDelimiter(":");
	return scanner.next();
    }
    public String getvalue(String line){
	Scanner scanner = new Scanner(line);
	scanner.useDelimiter(":");
	String temp=scanner.next();
	return scanner.next();
    }


    public ArrayList<String> getListExp() throws IOException{
	ArrayList<String> Lname = new ArrayList<String>();
	Scanner scanner = new Scanner(filePath, ENCODING.name());
	String name_exp="";
	while(scanner.hasNextLine()){
	    name_exp=processLine(scanner.nextLine());
	    if(!name_exp.equals("")){
		    Lname.add(name_exp);
	    }
	}
	return Lname;
    }
    
    protected String processLine(String aLine){
	Scanner scanner = new Scanner(aLine);
	scanner.useDelimiter(":");
	if (scanner.hasNext()){
	    String name = scanner.next();
	    String value = scanner.next();
	    //log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
	    if(name.equals("name")){
		//	  System.out.println("i'm here");
		return value;
	    }
	}
	return "";
    }
  
  // PRIVATE 
  
  private static void log(Object aObject){
    System.out.println(String.valueOf(aObject));
  }
  
  private String quote(String aText){
    String QUOTE = "'";
    return QUOTE + aText + QUOTE;
  }
} 

