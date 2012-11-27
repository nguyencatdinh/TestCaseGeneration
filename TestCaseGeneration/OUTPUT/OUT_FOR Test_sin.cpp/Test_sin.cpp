int classify(float x)
{
	if (((x < 0) || (x > 4.28)))
		return -1;
	else
	{
		if ((sin(x) > 0))
			if ((cos(x) > 0))
				return 1;
			else
				return 2;
		else
			if ((cos(x) < 0))
				return 3;
			else
				return 4;
	}
}
