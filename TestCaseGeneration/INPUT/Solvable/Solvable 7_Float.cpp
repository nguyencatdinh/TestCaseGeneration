float test01(float M,float N) {
	if (M > 0 && N > 0) {
		if (M > N) {
			return M;
		}
		else {
			return N;
		}
	}
	else {
		return -1;
	}
}