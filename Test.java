public class Test{
	public static void main(String[] args) {
		int m=5;
		long p =7;
		OAHashTable t1=new LPHashTable(m,p);
		OAHashTable t2=new QPHashTable(m,p);
		OAHashTable t3=new AQPHashTable(m,p);
		OAHashTable t4=new DoubleHashTable(m,p);
		for (int i=0;i<m;i++) {
			HashTableElement x=new HashTableElement(i,i+1);
			try {
			t1.Insert(x);
			t2.Insert(x);
			t3.Insert(x);
			t4.Insert(x);
			}
			catch(Exception e) {
				System.out.println("error");
			}

		}



		
	}
}