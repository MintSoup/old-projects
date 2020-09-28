#include <math.h>
#include <stdio.h>
int isPrime(int n) {
	for (int x = 2; x < sqrt(n); x++) {
		if (n % x == 0)
			return 0;
	}
	return 1;
}

int main() {

	int primes[100];
	int *primeTracker = primes;
	for (int i = 1; i < 550; i++) {
		if (isPrime(i)) {
			*(primeTracker++) = i;
		}
	}

	int cases;
	scanf("%d", &cases);

	while(cases--){
		int nprime, score;
		scanf("%d %d", &nprime, &score);
		int minShots = score / primes[nprime-1];
		// if (score % primes[nprime-1] > 0) minShots++;
		printf("%d\n", minShots);
	}

	return 0;
}