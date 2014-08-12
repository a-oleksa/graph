// Credits:Robert Sedgewick, Algorithms in C++, Parts 5:
//Fundamentals, Data Structure, Sorting, Searching 3rd Edition 

class Graph
{
	private int Vcnt, Ecnt;
	private boolean digraph;

	private class Node
	{
		Edge e; Node next;
		Node( Edge x, Node t ) { e = x; next = t; }
		public Edge getEdge() { return e; }
	}

	private Node adj[];

	public Graph( int V, boolean flag )
	{
		Vcnt = V; Ecnt = 0; digraph = flag;
		adj = new Node[V];
	}

	int V()	{ return Vcnt; }
	int E() { return Ecnt; }
	boolean directed()	{ return digraph; }

	public void insert( Edge e )
	{
		int v = e.getV1(), w = e.getV2();
		adj[v] = new Node( e, adj[v] );
		if( !digraph ) adj[w] = new Node( e, adj[w] );
		Ecnt++;
	}

	AdjList getAdjList( int v )
	{
		return new AdjLinkedList(v);
	}

	private class AdjLinkedList implements AdjList
	{
		private int v;
		private Node t;
		
	
		AdjLinkedList( int v )
		{
			this.v = v;
			t = null;
		}
		public Edge beg()
		{
			t = adj[v];
			return t == null ? null : t.getEdge();
		}

		public Edge nxt()
		{
			if( t != null ) t = t.next;
			return t == null ? null : t.getEdge();
		}

		public boolean end()
		{
			return t == null;
		}
	}
	
}
