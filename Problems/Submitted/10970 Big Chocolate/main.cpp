#include <math.h>
#include <stdio.h>
#include <stdlib.h>
int main() {
    int m;
    int n;
    while(1){
        if(scanf("%d %d", &m, &n) != EOF){
            int longside = fmax(m, n);
            int shortside = fmin(m, n);
            int cuts = 0;
            cuts += (shortside - 1);
            cuts += shortside * (longside - 1);
            printf("%d\n", cuts);
        }
        else{
            return 0;
        }
    }
    return 0;
}
