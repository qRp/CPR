import java.util.*;

public class Descripteur{
    private String name;
    private String type;
    private float value;
    private float minV;
    private float maxV;
    private float pasV; //sous le pasV, la plage
    private ArrayList<Float> lValue = new ArrayList<Float>();

    public Descripteur(String nname, String ntype, float nvalue){
	    name = nname;
	    type = ntype;
	    value = nvalue;
	    minV = nvalue;
    	maxV = nvalue;
        pasV = 0;
    }   
    
    public Descripteur(String nname, String ntype, float nvalue, float minValue, float maxValue, float pasValue){
	    name = nname;
	    type = ntype;
	    value = nvalue;
	    minV = minValue;
    	maxV = maxValue;
        pasV = pasValue;
    }
    
    public Descripteur(String nname, String ntype){
	    name = nname;
	    type = ntype;
	    value = 0;
    }
    public String getname(){
	    return name;
    }
    public String gettype(){
	    return type;
    }
    public float getvalue(){
        return value;
    }
    public ArrayList<Float> getvalues(){
        lValue.add(value);
        lValue.add(minV);
        lValue.add(maxV);
        lValue.add(pasV);
	    return lValue;
    }
}
