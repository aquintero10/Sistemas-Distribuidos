#include <stdlib.h>
#include <stdio.h>

int main()
{
int n,m;
int i;

m=0;
n=2;
while(m<m+1)
{
for(i=2;i<n;i++)
if(n%i==0)break;

        if(i==n)
{
printf(“%d t”,n);
m++;
}
n++;
}

system(“PAUSE”);
return 0;
}
