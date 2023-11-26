import java.util.Random;

public class ModHash {
	long a;
	long b;
	long p;
	int m;
	boolean is_double=false;
	public ModHash(long ga,long gb,long gp,int gm) {
		this.a=ga;
		this.b=gb;
		this.p=gp;
		this.m=gm;
		
	}
	public static ModHash GetFunc(int m, long p){
		Random rnd=new Random();
		long a=rnd.nextLong(1, p);
		long b=rnd.nextLong(0, p);
		ModHash ob=new ModHash(a,b,p,m);
		return ob;
	}
	
	public int Hash(long key) {
		int res;
		if (this.is_double==false) {
			res=(int) (((this.a*key+this.b)%this.p)%this.m);
		}
		else {
			res=(int) (((this.a*key+this.b)%this.p)%(this.m-1))+1;
		}
		return res;
	}
	public void change_bool() {
		this.is_double=true;
	}
}
