#include <unistd.h>
#include <stdio.h>
int main(void)
{
  printf("Prueba de la llamada a exec\n");
  execl("/bin/echo","echo","Buenos","Dias",NULL);
  return 0;
}
