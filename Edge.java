public class Edge
{
	private int v1, v2; // pair of vertexes
	private int w; //weight

	public Edge( int vertex, int vertex2, int weight )
	{
		v1 = vertex;
		v2 = vertex2;
		w = weight;
	}

	public int getV1( )	{ return v1; }
	public int getV2( )	{ return v2; }
	public int getWt( )	{ return w;  }
	public boolean from( int v )
	{
		
		if( (v == v1) && (this.other(v) == v2 ) )
			return true;
		else
			return false;
	}

	public int other( int v )
	{
		return v == v1 ? v2 : v1;
	}
}
