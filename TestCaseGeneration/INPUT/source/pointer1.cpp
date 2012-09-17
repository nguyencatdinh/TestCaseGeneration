int f() {
	int a=10;
	// a+=1;
	int *ptr;
	ptr=&a;
	*ptr=7;
	int b=1;
	// ptr=&b;
	*ptr=*ptr+15;
	// int *p=7;
	// *p+=9;
	// a+=*p;
	return a;
	// return *ptr;
	// int a=10;
	// a=a+4;
	// int b=0;
	// int *p;
	// p=&b;
	// if (*p==0) {
		// int a=5;
		// int b=6;
		// a=b-1;
	// }
	// return a;
}
