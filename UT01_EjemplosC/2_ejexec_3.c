#include <stdio.h>
#include <unistd.h>
int main(void)
{
  printf("Prueba de la llamada a exec\n");
   if(execl("/bin/ps","ps","-a",(char *)NULL)==-1){
	   printf("Error en la ejecucion de exec\n");
   } else {
     printf("Fin de la lista de procesos");
   }
   return 0;
}
