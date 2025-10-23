#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main(void)
{
 int var = 10;

 printf("\nValor inicial de la variable: %d\n", var);

 switch(fork()){
   case -1:
        printf("Error al crear procesos");
        exit(-1);
        break;
  case 0: //hijo
        var-=5;
        printf("Variable en el proceso hijo: %d\n",var);
        break;
  default: //padre
        var+=5;
        wait(NULL); // para forzar que acabe antes el hijo
        printf("Variable en el proceso padre: %d\n",var);
      break;
 }
 return 0;
}
