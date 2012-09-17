int test(int a, int b, int c)
{
	if ((a != 0))
	{
		int delta = (pow(b, 2) - ((4 * a) * c));
		if ((delta >= 0))
		{
			if ((delta > 0))
			{
				return 2;
			}
			else
			{
				return 1;
			}
		}
		else
			return 0;
	}
	else
		return 1;
}
