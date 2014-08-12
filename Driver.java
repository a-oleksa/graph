import java.util.Scanner;

public class Driver 
{
	public static void main( String[] args )
	{
		Graph graph = new Graph( 50, false );
		String src, dest;
		intStack cit = new intStack();

		city db = new city( 50 );
		Scanner sc = new Scanner( System.in );
		src = sc.next();
		dest = sc.next();

		while(sc.hasNext())
		{
			String v1, v2; 
			int dist;
			v1 = sc.next();
			v2 = sc.next();
			dist = sc.nextInt();
			

			graph.insert( new Edge( db.cityToInt(v1), db.cityToInt(v2), dist ) );
		}

		GraphSPT sp = new GraphSPT(graph, db.cityToInt(src));
		
		// push destination onto stack manually
		cit.push( db.cityToInt(dest) );
		// use recursion to get the rest of the path
		path( db.cityToInt(dest), sp, db, cit );

		while( !cit.empty() )
			System.out.print( db.intToCity(cit.pop()) + " " );
		System.out.println();
		
		int dist = sp.dist(db.cityToInt(dest));

		if( dist == -1 )
			System.out.println( "There is no route" );
		else
			System.out.println( "Distance: " + dist );
		

	}

	public static int path( int v, GraphSPT sp, city db, intStack c )
	{
		if( sp.pathR( v ) != null )
		{
			// prevent an infinite loop
			if( sp.pathR(v).getV2() == v )
			{
				c.push( sp.pathR(v).getV1() );
				return path( sp.pathR(v).getV1(), sp, db, c );
			}
			else
				c.push( sp.pathR(v).getV2() );
				return path( sp.pathR(v).getV2(), sp, db, c );
		} else return 0;

			
	}
}
