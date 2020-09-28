#include <stdio.h>
#include <string.h>
// 5 Mickey 1 10 1991 Alice 30 12 1990 Tom 15 8 1993 Garfield 20 9 1990 Jerry 18
// 5 1990
int main() {
	int cases;
	while (scanf("%d", &cases) == 1) {
		char yname[20] = {0};
		char oname[20] = {0};
		char name[20] = {0};

		int old = 0, young = 31 + 1200 + 99990000;
		int day, month, year;

		while (cases--) {
			scanf("%s%d%d%d", name, &day, &month, &year);
			int age = day + month * 100l + year * 100l * 100l;
			if (age > old) {
				old = age;
				memcpy(oname, name, 20);
			}
			if (age < young) {
				young = age;
				memcpy(yname, name, 20);
			}
		}
		printf("%s\n%s\n", oname, yname);

		return 0;
	}
}