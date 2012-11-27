int middle(int a, int b, int c)
{
	if ((((a < b) && (b < c)) || ((c < b) && (b < a))))
	{
		return b;
	}
	else
		if ((((a < c) && (c < b)) || ((b < c) && (c < a))))
		{
			return c;
		}
		else
			if ((((b < a) && (a < c)) || ((c < a) && (a < b))))
			{
				return a;
			}
}
