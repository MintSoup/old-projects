#include <stdbool.h>
#include <stdio.h>
#include <string.h>
#define length 11

int getlettern(char b);
void main() {

	const char *words[] = {"nigger",  "alice",  "licea",   "note",
						   "kids",	"ginger", "cheater", "nagger",
						   "teacher", "no",		"tachere"};

	for (int word1 = 0; word1 < length - 1; word1++) {
		int letters_a[26] = {0};

		for (int l1 = 0; l1 < strlen(words[word1]); l1++) {
			letters_a[getlettern(words[word1][l1])]++;
		}

		for (int word2 = word1 + 1; word2 < length; word2++) {

			int letters_b[26] = {0};

			for (int l2 = 0; l2 < strlen(words[word2]); l2++) {
				letters_b[getlettern(words[word2][l2])]++;
			}

			bool flag = 1;
			for (int check = 0; check < 26; check++) {
				if (letters_a[check] != letters_b[check]) {
					flag = 0;
				}
			}
			if (flag)
				printf("%s - %s\n", words[word1], words[word2]);
		}
	}
}

int getlettern(char b) {
	if (b >= 'a' && b <= 'z') {
		return b - 'a' + 1;
	}
	return 69;
}