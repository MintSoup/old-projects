#include <stdio.h>
#include <string.h>
#include <omp.h>

void main() {
	FILE *dictionary = fopen("dictionary.txt", "r");
	FILE *output = fopen("words.txt","w");
	const char *allowedLetters = "abcdefxympgro";

	#pragma omp parallel
	#pragma omp for

	for (int i = 0; i < 37000000; i++) {
		char word[35];
		fgets(word, 34, dictionary);
		*(word + strlen(word) - 1) = 0;
		
		if(strlen(word) < 6) continue;

		char *wpnt = word;
		// check if letter is allowed
		unsigned int wordAllowed = 1;
		do {
			unsigned int letterAllowed = 0;
			for (int i = 0; i < strlen(allowedLetters); i++) {
				if (*wpnt == allowedLetters[i]) {
					letterAllowed = 1;
					break;
				}
			}
			if (!letterAllowed) {
				wordAllowed = 0;
				break;
			}
			wpnt++;
		} while (*wpnt != 0);
		if (wordAllowed)
			fprintf(output,"%s\n", word);

		if(i % 1000 < 2){
			printf("words processed: %d\n",i);
		}
	}
	fclose(dictionary);
	fclose(output);
}