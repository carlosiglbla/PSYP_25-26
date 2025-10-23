
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
int main()
{
  int fp;
  int p;
  char saludo[] = "Un saludo!!!\n";
  char buffer[100];
  int n_leidos = 0;

  p = mkfifo("FIFO1", S_IFIFO|0666);

  if(p == -1) {
    printf("ERROR AL CREAR EL FICHERO...");
    exit(1);
  }
  while(1){
      fp = open("FIFO1", 0);
      n_leidos = read(fp, buffer, strlen(buffer));
      printf("%d Obteniendo la información... %s\n",n_leidos, buffer);
      close(fp);
  }

  return 0;
}
