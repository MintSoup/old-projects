#include <stdbool.h>
#include <stdio.h>
int main() {
	char rows[4][14] = {"QWERTYUIOP[]\\", "ASDFGHJKL;'", "ZXCVBNM,./",
						"`1234567890-="};
	while (!feof(stdin)) {
		char text[401] = {0};
		fgets(text, 400, stdin);
		for (int t = 0; t < 401 && text[t] != 0; t++) {
			for (int a = 0; a < 4; a++) {
				bool found = 0;
				for (int b = 0; b < 13; b++) {
					if (text[t] == rows[a][b]) {
						text[t] = rows[a][b - 1];
						found = 1;
						break;
					}
				}
				if (found)
					break;
			}
		}
		printf(text);
	}

	return 0;
}