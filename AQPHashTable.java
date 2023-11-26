import java.util.Random;
import java.lang.Math;

public class AQPHashTable extends OAHashTable {
	private long p;
	public AQPHashTable(int m, long p) {
		super(m);
		this.p=p;
	}
	
	@Override
	public int Hash(long x, int i) {
		ModHash h=ModHash.GetFunc(this.m, this.p);
		if (i%2==0) {
			return (int) (h.Hash(x)+i*i)%this.m;
		}
		return (int) (h.Hash(x)-Math.pow(i, 2))%this.m;
	}
}
