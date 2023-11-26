import java.util.Random;

public class LPHashTable extends OAHashTable {
	private long p;
	public LPHashTable(int m, long p) {
		super(m);
		this.p=p;
	}
	
	@Override
	public int Hash(long x, int i) {
		ModHash h=ModHash.GetFunc(this.m, this.p);
		return (int) ((h.Hash(x)+i)%this.m);
		
	}
	
}
