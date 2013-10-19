/**
 *  @author Eric Augustine 
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <math.h>

struct myStruct
{
   int i;
};

int
main()
{
   struct myStruct *fun;

   fun = (struct myStruct *)(malloc(sizeof(struct myStruct)));

   fun->i = 9;

   printf("%d\n", fun->i);

   return 0;
}
