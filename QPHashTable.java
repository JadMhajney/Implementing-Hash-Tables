import java.util.Random;

public class QPHashTable extends OAHashTable {
	private long p;
	public QPHashTable(int m, long p) {
		super(m);
		this.p=p;
	}
	
	@Override
	public int Hash(long x, int i) {
		ModHash h=ModHash.GetFunc(this.m, this.p);
		return (int) (h.Hash(x)+i*i)%this.m;
	}
}
