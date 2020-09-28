#include <ctype.h>
#include <stdio.h>
#include <string.h>
int main() {
	while (1) {
		char sentence[151] = {};
		fgets(sentence, 149, stdin);

		if (!strcmp(sentence, "DONE\n"))
			break;

		char forward[151] = {};
		char backward[151] = {};

		int outputTracker = 0;

		for (int i = 0; i < strlen(sentence); i++) {
			if ((sentence[i] >= 'A' && sentence[i] <= 'Z') ||
				(sentence[i] >= 'a' && sentence[i] <= 'z')) {
				forward[outputTracker] = tolower(sentence[i]);
				outputTracker++;
			}
		}
		outputTracker = 0;
		for (int i = strlen(forward) - 1; i >= 0; i--) {
			backward[outputTracker] = tolower(forward[i]);
			outputTracker++;
		}

		if (!strcmp(forward, backward)) {
			puts("You won't be eaten!");
		} else
			puts("Uh oh..");
	}
	return 0;
}
