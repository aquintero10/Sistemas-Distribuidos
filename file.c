#include < stdio.h >
#include < stdlib.h >

int main() {
    
    for(int i=0;i<i+1;i++)
    {
        int i;
        FILE *fp;

        fp=fopen("file.txt","w");

        for(i=0;i<(1024*1024);i++) {
            fseek(fp,(1024*1024), SEEK_CUR);
            fprintf(fp,"C");
        }

        fclose(fp);
        return 0;   
    }
}
