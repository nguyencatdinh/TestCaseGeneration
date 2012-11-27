int ptb3(float a, float b, float c, float d)
{
	float delta = pow(b, 2) - 3*a*c;
	
	if(delta!=0)
	{
		float k = (9*a*b*c-2*pow(b,3)-27*pow(a,2)*d)/2;
		float temp = pow(delta,3);
		temp = abs(temp);
		k = k/sqrt(temp);
		if(delta>0)
		{
			if(abs(k)<=1)
			{
				return 3;
			}
			else return 1;
		}
		else
		{
			return 1;
		}
	}
	else 
		return 1;
}