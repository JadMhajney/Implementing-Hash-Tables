
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	public int m;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m=m;
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		
		for (int i=0;i<m;i++) {
			int j=this.Hash(key, i);
			if (this.table[j]==null) {
				return null;
			}
			else if(this.table[j].GetKey()==key) {
				return this.table[j];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if (this.Find(hte.GetKey())!=null) {
			throw new KeyAlreadyExistsException(hte);
		}
		for (int i=0; i<m ;i++) {
			int j=this.Hash(hte.GetKey(), i);
			if (this.table[j]==null || this.table[j].GetKey()==-1) {
				this.table[j]=hte;
			}
		}
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i=0; i<m ;i++) {
			int j=this.Hash(key, i);
			if (this.table[j].GetKey()==key) {
				HashTableElement deleted=new HashTableElement(-1,this.table[j].GetValue());
				this.table[j]=deleted;
			}
		}
		throw new KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
	
}
