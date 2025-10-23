#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(void)
{
 int i=0;
 switch(fork())
 {
   case -1:
        printf("Error al crear procesos");
        return -1;
        break;

  case 0:
        while(i<10)
	         printf("Soy el proceso hijo:%d\n",i++);
	      break;
  default:
  	    while(i<10){
          printf("Soy el proceso padre:%d\n",i++);
        }
 }
 return 0;
}
