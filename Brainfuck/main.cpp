#include <fstream>
#include <iostream>
#include <stack>
using namespace std;


int main(int argc, char *argv[]) {
	uint8_t mem[256] = {0};
	uint8_t *pntr = mem;
	stack<streampos> loops;
	ifstream in(argv[1], ios::binary);
	while (in.peek() != EOF) {
		char p;
		in.read(&p, 1);

		switch (p) {
		case '+': {
			(*pntr)++;
			break;
		}
		case '-': {
			(*pntr)--;
			break;
		}
		case '>': {
			if (pntr - mem < sizeof(mem))
				pntr++;
			else
				pntr = mem;
			break;
		}
		case '<': {
			if (pntr - mem > 0)
				pntr--;
			else
				pntr = mem + sizeof(mem);
			break;
		}
		case '.': {
			cout << *pntr;
			break;
		}
		case ',': {
			cin >> *pntr;
			break;
		}
		case '[': {
			loops.push(in.tellg());
			break;
		}
		case ']': {
			if (loops.empty()) {
				cout << "ERROR: UNEXPECTED ]" << endl;
				exit(1);
			}
			if (*pntr != 0) {
				in.seekg(loops.top() + streamoff(-1));
			}
			loops.pop();
		}
		}
	}
	if (!loops.empty()) {
		cout << "ERROR: UNEXPECTED EOF" << endl;
		exit(1);
	}
	in.close();
	return 0;
}
