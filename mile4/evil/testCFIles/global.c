struct a
{
   int i;
};

struct a *stA;

int main()
{
   stA = (struct a*)malloc(sizeof(struct a));
   stA->i = 5;
   return stA->i;
}
