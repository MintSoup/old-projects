#include <stdio.h>
#include <stdlib.h>

int main()
{
    int f;
    scanf("%d",&f);
    for(int c =1; c < f + 1; c++){
        int low = 0;
        int high = 0;
        int lh;
        int walls;

        scanf("%d %d",&walls ,&lh);

        walls--;
        while(walls > 0){
            int h;
            scanf("%d", &h);
            if(h > lh){ high++;}
            else if(h < lh) {low++;}
            lh = h;
            walls--;

        }
        printf("Case %d: %d %d\n", c, high, low);
    }
    return 0;
}
