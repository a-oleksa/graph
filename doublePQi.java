// Credits:Robert Sedgewick, Algorithms in C++, Parts 5:
//Fundamentals, Data Structure, Sorting, Searching 3rd Edition 

public class doublePQi
{
	private int N, d = 3; 
	private int[] a; private int[] pq, qp; 

  	private boolean less(int i, int j)
    		{ return a[pq[i]] < a[pq[j]]; }

	private void exch(int i, int j)
    	{
		int t = pq[i]; pq[i] = pq[j]; pq[j] = t;
      		qp[pq[i]] = i; qp[pq[j]] = j; 
	}
	private void swim(int k)
	{ 
		while (k > 1 && less(k, (k+d-2)/d))
		{ exch(k, (k+d-2)/d); k = (k+d-2)/d; } 
	}

	private void sink(int k, int N)
    	{
		int j;
     		 while ((j = d*(k-1)+2) <= N)
       		 { 
         		 for (int i = j+1; i < j+d && i <= N; i++)
           			 if (less(i, j)) j = i;
         		 if (!(less(j, k))) break;
         		 exch(k, j); k = j;
       		 }
    	}

	public doublePQi(int maxN, int[] a)
    	{ 
		this.a = a; this.N = 0;
      		pq = new int[maxN+1]; qp = new int[maxN+1];
      		for (int i = 0; i <= maxN; i++) 
        	  { pq[i] = 0; qp[i] = 0; }
    	}
 
	public boolean empty() { return N == 0; }

  	public void insert(int v) 
        	{ pq[++N] = v; qp[v] = N; swim(N); }

	int getmin()
    		{ exch(1, N); sink(1, N-1); return pq[N--]; }
  	void lower(int k)
    		{ swim(qp[k]); }
}
