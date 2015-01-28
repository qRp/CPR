public class Descripteur{
    private String name;
    private String type;
    private float value;

    public Descripteur(String nname, String ntype, float nvalue){
	name=nname;
	type=ntype;
	value=nvalue;
    }   
    public Descripteur(String nname, String ntype){
	name=nname;
	type=ntype;
	value=0;
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
}