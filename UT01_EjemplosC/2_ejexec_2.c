#include <stdio.h>
#include <unistd.h>
int main()
{
  printf("Prueba de la llamada a exec\n");
  execl("/bin/ls","ls","-l",NULL);
  printf("Lanzado el proceso ls. Este mensaje no lo vamos a ver\n");
  return 0;
}
