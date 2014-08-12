import java.util.HashMap;

public class city
{
	static HashMap<String, Integer> hm;
	static int numbers;
	static String cityN[];

	public city(int N )
	{
		numbers = 0;
		hm = new HashMap<String, Integer>();
		cityN = new String[N];
	}

	public int cityToInt( String city )
	{
		if( !hm.containsKey( city ) )

		{
			hm.put( city, numbers );
			cityN[numbers] = city;
			return numbers++;
		} else {
			return hm.get( city );
		}
	}

	public String intToCity( int city )
	{
		return cityN[city];
	}
}
