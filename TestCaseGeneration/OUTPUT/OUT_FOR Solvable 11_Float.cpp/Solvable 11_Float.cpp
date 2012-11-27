int triangle(float a, float b, float c)
{
	int triangle;
	if (((((a + b) > c) && ((b + c) > a)) && ((c + a) > b)))
	{
		if ((((a != b) && (b != c)) && (c != a)))
		{
			triangle = 1;
		}
		else
		{
			if (((((a == b) && (b != c)) || ((b == c) && (c != a))) || ((c == a) && (a != b))))
			{
				triangle = 2;
			}
			else
			{
				triangle = 3;
			}
		}
	}
	else
		triangle = 0;
	return triangle;
}
