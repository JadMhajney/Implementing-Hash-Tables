import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	private long p;
	public DoubleHashTable(int m, long p) {
		super(m);
		this.p=p;
	}
	
	@Override
	public int Hash(long x, int i) {
		ModHash h1=ModHash.GetFunc(this.m, this.p);
		ModHash h2=ModHash.GetFunc(this.m, this.p);
		h2.change_bool();
		return (int) (h1.Hash(x)+i*(h2.Hash(x)))%this.m;
	}
	
}
