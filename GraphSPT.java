// Credits:Robert Sedgewick, Algorithms in C++, Parts 5:
//Fundamentals, Data Structure, Sorting, Searching 3rd Edition 

public class GraphSPT
{
	private int[] wt;
	Edge[] spt;
	final int maxWT = 10000;
	
	public GraphSPT( Graph G, int s )
	{
		int V = G.V();
		wt = new int[V]; spt = new Edge[V];
		for( int v = 0; v < V; v++ ) wt[v] = maxWT;
		
		doublePQi pQ = new doublePQi(V, wt );
		for( int v = 0; v < V; v++ ) pQ.insert(v);
		wt[s] = 0; pQ.lower(s);
	
		while( !pQ.empty())
		{
			int v = pQ.getmin();
			if( v != s && spt[v] == null ) return;
			AdjList A = G.getAdjList(v);
			for( Edge e = A.beg(); !A.end(); e = A.nxt())
			{
				int w = e.other(v);
				//int w = e.getV1();
			
				int P = wt[v] + e.getWt();
				if( P < wt[w] )
				{
					wt[w] = P; pQ.lower(w); spt[w] = e;
				}
			}
		}
	}

		
	int dist( int v ) { return wt[v] == maxWT ? -1 : wt[v]; }
	Edge pathR( int v ) { return spt[v]; }

}


