int program(int N) {
	int i;
	int sum = 0;
	int product = 1;
	for (i = 1; i <= N; i++) {
		sum = sum + i;
		product = product * i;
	}
	cout << "sum = " << sum;
	cout << "product = " << product;
	return 0;
}

