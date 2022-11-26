#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
    
#include "singlyLList.h"

#define MAX_C 10


// In this file, several tests are performed to guarantee the 
// correctness of the linked list implementation

struct node *start = NULL;// global variable

void transverseListAndPrint(struct node **start)
{
    //Transversing the list 
    struct node *ptr, *nPtr;
    ptr = *start;
    
    while((nPtr = (*ptr).next) != NULL){
        printf("%d\n", (*nPtr).data);
        ptr = nPtr;
    }
}

int main (void)
{
    int i; 
    for(i =0; i< MAX_C; i++){
        insertNodeEnd(&start, i);
    }
   
    printf("-------%s-------\n", "Iterating"); 
    transverseListAndPrint(&start);
   
    printf("-------%s-------\n", "Search"); 

    // Testing search for a node with a specific value
    struct node *found;
    found = searchForNode(&start, 4);
    assert(found != NULL);
    printf("%d\n", (*found).data);
    found = searchForNode(&start, -4);
    assert(found == NULL);

    printf("-------%s-------\n", "Deletion"); 

    // Deleting Nodes
    deleteNodeEnd(&start);
    deleteNodeBeginning(&start);
    transverseListAndPrint(&start);
    printf("--------------\n"); 

    return 0;
}
