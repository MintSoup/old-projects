#include <stdio.h>
#include <string.h>

int main()
{
    int stonks = 0;
    int op;
    scanf("%d", &op);
    for(; op > 0; op--){
        char action[7];
        scanf("%s", action);

        if (strcmp(action, "donate") == 0){
            int a;
            scanf("%d", &a);
            stonks += a;
        }
        else if (strcmp(action, "report") == 0){
            printf("%d\n",stonks);
        }
    }
    return 0;
}
