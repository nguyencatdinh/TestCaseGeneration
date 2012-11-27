void Tomorrow(float day, float date, float month, float year)
{
	float next_day;
	float next_date;
	float next_month;
	float next_year;
	next_day = day;
	next_date = date;
	next_month = month;
	next_year = year;
	if (((((((day >= 2) && (day <= 8)) && (date >= 1)) && (date <= 31)) && (month >= 1)) && (month <= 12)))
	{
		if ((day == 8))
			next_day = 2;
		else
			next_day = day + 1;
		if (((month == 12) && (date == 31)))
		{
			next_date = 1;
			next_month = 1;
			next_year = year + 1;
		}
		else
			if (((date == 28) && (month == 2)))
			{
				if ((((year % 4) == 0) || ((year % 400) == 0)))
					next_date = 29;
				else
				{
					next_date = 1;
					next_month = month + 1;
				}
			}
			else
				if (((date == 31) && ((((((month == 1) || (month == 3)) || (month == 5)) || (month == 7)) || (month == 8)) || (month == 10))))
				{
					next_date = 1;
					next_month = month + 1;
				}
				else
					if (((date == 29) && (month == 2)))
					{
						next_date = 1;
						next_month = month + 1;
					}
					else
						if (((date == 30) && ((((month == 4) || (month == 6)) || (month == 9)) || (month == 11))))
						{
							next_date = 1;
							next_month = month + 1;
						}
						else
							next_date + 1;
	}
	else
	{
		printf("Invalid input");
	}
}
