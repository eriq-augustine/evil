/**
 *  @author Eric Augustine 
 */

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <math.h>

typedef struct node_t
{
   int data;
   struct node_t *next;
} node;

typedef struct t_node_t
{
   int data;
   struct t_node_t *left;
   struct t_node_t *right;
} t_node;

node *add(node *list, int toAdd);
node *pop(node *list);
void printList(node *list);
node *quickSortMain(node *list);
node *myQuickSort(node *list);
int get(node *list, int index);
node *concatList(node *first, node *second);
void freeList(node *list);
int size(node *list);

t_node *tree_add(t_node *root, int toAdd);
void treeMain(node *list);
void freeTree(t_node *root);
t_node *buildTree(node *list);
node *inOrder(t_node *root);
node *postOrder(t_node *root);
void tree_print(t_node *root);
int tree_search(t_node *root, int target);
int bin_tree_search(t_node *root, int target);

node *myCopy(node *src);

int
main(int argc, char *argv[])
{
   int i, element;
   node *myList, *copyList1, *copyList2, *sortedList;
   i = 0;
   while(i < 10)
   {
      scanf("%d", &element);
      myList = add(myList, element);
      copyList1 = myCopy(myList);
      copyList2 = myCopy(myList);
      sortedList = quickSortMain(copyList1);
      freeList(sortedList);
      treeMain(copyList2);
      freeList(sortedList);
      i = i + 1;
   }
   freeList(myList);
   freeList(copyList1);
   freeList(copyList2);
   return 0;

   /*node *list = add(add(add(add(add(NULL, 3), 6), 9), 2), 0);
   list = quickSortMain(list);
   freeList(list);
   
   list = add(add(add(add(add(NULL, 3), 6), 9), 2), 0);
   treeMain(list);
   freeList(list);
   return EXIT_SUCCESS;*/
}

void treeMain(node *list)
{
   t_node *root;
   node *inList;
   node *postList;

   root = buildTree(list);
  
   tree_print(root);
   printf("-999\n");

   inList = inOrder(root);
   printList(inList);
   printf("-999\n");
   freeList(inList);

   postList = postOrder(root);
   printList(postList);
   printf("-999\n");
   freeList(postList);

   printf("%d\n", tree_search(root, 0));
   printf("-999\n");
   printf("%d\n", tree_search(root, 10));
   printf("-999\n");
   printf("%d\n", tree_search(root, -2));
   printf("-999\n");
   printf("%d\n", tree_search(root, 2));
   printf("-999\n");
   printf("%d\n", tree_search(root, 3));
   printf("-999\n");
   printf("%d\n", tree_search(root, 9));
   printf("-999\n");
   printf("%d\n", tree_search(root, 1));
   printf("-999\n");
  
   printf("%d\n", bin_tree_search(root, 0));
   printf("-999\n");
   printf("%d\n", bin_tree_search(root, 10));
   printf("-999\n");
   printf("%d\n", bin_tree_search(root, -2));
   printf("-999\n");
   printf("%d\n", bin_tree_search(root, 2));
   printf("-999\n");
   printf("%d\n", bin_tree_search(root, 3));
   printf("-999\n");
   printf("%d\n", bin_tree_search(root, 9));
   printf("-999\n");
   printf("%d\n", bin_tree_search(root, 1));
   printf("-999\n");

   freeTree(root);
}

node *add(node *list, int toAdd)
{
   node *newNode = (node *)(malloc(sizeof(node)));

   newNode->data = toAdd;
   newNode->next = list;

   return newNode;
}

node *pop(node *list)
{
   list = list->next;
   
   return list;
}

void freeList(node *list)
{
   if (list)
   {
      freeList(list->next);
      free(list);
   }
}

void printList(node *list)
{
   if (list)
   {
      printf("%d\n", list->data);
      printList(list->next);
   }
}

int size(node *list)
{
   if (!list)
   {
      return 0;
   }

   return 1 + (size(list->next));
}

node *quickSortMain(node *list)
{
   /*unsorted*/
   printList(list);
   printf("-999\n");

   /*sort plz*/
   list = myQuickSort(list);

   /*sorted*/
   printList(list);
   printf("-999\n");
   
   /*sort plz*/
   list = myQuickSort(list);

   /*sorted*/
   printList(list);
   printf("-999\n");

   return list;
}

node* myQuickSort(node *list)
{
   int pivot, i;
   node *less = NULL, *greater = NULL, *temp;

   if (size(list) <= 1)
   {
      return list;
   }

   pivot = (get(list, 0) + get(list, (size(list) - 1))) / 2; 

   temp = list;
   i = 0;

   while (temp)
   {
      if (get(list, i) > pivot)
      {
         greater = add(greater, get(list, i));
      }
      else
      {
         less = add(less, get(list, i));
      }

      temp = temp->next;
      i++;
   }

   /*printf("pivot: %d\n", pivot);
   //printf("less:\n");
   //printList(less);
   //printf("greater:\n");
   //printList(greater);
   //printf("end\n");
   */

   freeList(list);
   return concatList( (myQuickSort(less)), (myQuickSort(greater)) );
}

int get(node *list, int index)
{
   if (index == 0)
   {
      return list->data;
   }

   return get(list->next, (index - 1));
}

node *concatList(node *first, node *second)
{
   node *temp = first;

   if (!first)
   {
      return second;
   }

   while (temp->next)
   {
      temp = temp->next;
   }

   temp->next = second;

   return first;
}

t_node *tree_add(t_node *root, int toAdd)
{
   t_node *temp;

   if (!root)
   {
      temp = (t_node *)(malloc(sizeof(t_node)));
      temp->data = toAdd;
      temp->left = temp->right = NULL;
      return temp;
   }

   if (toAdd < root->data)
   {
      root->left =  tree_add(root->left, toAdd);
   }
   else
   {
      root->right = tree_add(root->right, toAdd);
   }

   return root;
}

void freeTree(t_node *root)
{
   if (root)
   {
      freeTree(root->left);
      freeTree(root->right);
      free(root);
   }
}

t_node *buildTree(node *list)
{
   int i = 0;
   t_node *root = NULL;

   while(i < size(list))
   {
      root = tree_add(root, get(list, i));

      i++;
   }

   return root;
}

node *inOrder(t_node *root)
{
   node *temp;

   if (root)
   {
      temp = (node *)(malloc(sizeof(node)));
      temp->data = root->data;
      temp->next = NULL;
      return concatList( inOrder(root->left), (concatList(temp, inOrder(root->right))));
   }

   return NULL;
}

node *postOrder(t_node *root)
{
   node *temp;

   if (root)
   {
      temp = (node *)(malloc(sizeof(node)));
      temp->data = root->data;
      temp->next = NULL;
      return concatList( concatList(postOrder(root->left), postOrder(root->right)), temp);
   }

   return NULL;
}

/*in order print*/
void tree_print(t_node *root)
{
   if (root)
   {
      tree_print(root->left);
      printf("%d\n", root->data);
      tree_print(root->right);
   }
}

/*exhaustive search tree*/
int tree_search(t_node *root, int target)
{
   int ret = 0;

   printf("-1");

   if (root)
   {
      if (root->data == target)
      {
         return 1;
      }

      /*Must make it exhaustive*/
      ret = tree_search(root->left, target);
      ret = tree_search(root->right, target) || ret;
      return ret;
   }

   return 0;
}

/*binary search the tree*/
int bin_tree_search(t_node *root, int target)
{
   printf("-1");
   
   if (root)
   {
      if (root->data == target)
      {
         return 1;
      }

      if (target < root->data)
      {
         return bin_tree_search(root->left, target);
      }
      else
      {
         return bin_tree_search(root->right, target);
      }
   }

   return 0;
}

node* myCopy(node* src)
{
   if(src == NULL)
   {
      return NULL;
   }
   return concatList(add(NULL, src->data), myCopy(src->next));
}
