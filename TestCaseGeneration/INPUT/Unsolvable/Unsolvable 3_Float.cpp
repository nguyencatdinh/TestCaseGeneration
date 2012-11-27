int foo(float a, float b, float c) {
	if((a==0)&&(b==0)&&(c==0)){
		return -1;
	}
	else if((pow(b,2)-4*a*c)<0){
		return -1;
	}
	else if((b*b-4*a*c)==0){
		return 1;
	}
	else {
		return 2;
	}
}

