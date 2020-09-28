#include <stdio.h>
#include <string.h>

int matches(char *a, char *b) {
	int n = 0;
	while (n < strlen(a)) {
		if (*(a + n) == '-' || *(b + n) == '-') {
			n++;
			continue;
		}
		if (*(a + n) == *(b + n)) {
			n++;
			continue;
		}
		return 0;
	}

	return 1;
}

int main() {

	int cases;
	scanf("%d", &cases);
	char fdna[101];
	scanf("%s", fdna);

	int dnalen = strlen(fdna) + 1;
	// absolutley disgusting, evil code
	// pls dont remove me from fablab
	char dnas[cases][dnalen];
	// evil code over
	memset(dnas, 0, cases * dnalen);

	memcpy(dnas[0], fdna, dnalen);

	for (int i = 1; i < cases; i++) {
		scanf("%s", dnas[i]);
		int firstMatch = 1;

		char ms[100] = {0};
		char *mspointer = ms;
		for (int matchi = 0; matchi < i; matchi++) {
			if (matches(dnas[i], dnas[matchi])) {
				if (firstMatch) {
					printf("%d:", i + 1);
					firstMatch = 0;
				}
				printf(" %d", matchi + 1);
			}
		}
		if (!firstMatch)
			puts("");
	}
	return 0;
}