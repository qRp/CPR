public class Environnement{
    private int x;
    private int y;
    private int z;
    private String description;


    public Environnement(){
	x=0;
	y=0;
	z=0;
	description="empty";
    }
    public Environnement(int xx, int yy, int zz, String ddescription){
	x=xx;
	y=yy;
	z=zz;
	description=ddescription;
    }
    public Environnement(int xx, int yy, int zz){
	x=xx;
	y=yy;
	z=zz;
	description="unknown";
    }
    public int getx(){
	return x;
    }
    public int gety(){
	return y;
    }
    public int getz(){
	return z;
    }
    public String getdescription(){
	return description;
    }
    public void afficher(){
	System.out.println("x : "+x);
	System.out.println("y : "+y);
	System.out.println("z : "+z);
	System.out.println("Description : "+description);
    }

    
}
