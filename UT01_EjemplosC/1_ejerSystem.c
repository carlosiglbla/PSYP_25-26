#include <stdio.h>
#include <stdlib.h>
int main(void)
{
  printf("Prueba de la llamada system\n");
  printf("Listado de directorio actual y envio a un fichero\n");
  printf("%d", system("ls > fichsalida"));
  printf("\nAbrimos con gedit/vim el fichero...");
  printf("%d", system("vim fichsalida"));
  printf("\nEste comando es erroneo: %d",system("ged"));
  printf("\nFin del programa...");
  return 0;
  }
