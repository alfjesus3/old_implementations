#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include "singlyLList.h"

/*
struct node **initializePtrOfPtr()
{
    struct node **ptr;
    struct node *tmp = NULL;
    ptr = &tmp;
    return ptr;
}
*/

struct node *createNode()
{
    struct node *ptr;
    ptr = (void *)malloc(sizeof(struct node));
    return ptr;
}

void insertNodeBeginning(struct node **start, int val)
{
    struct node *old;
    old = *start;
    
    *start = createNode();
    
    (**start).data = val; 
    (**start).next = old;
}

void insertNodeEnd(struct node **start, int val)
{
    if(*start == NULL){
        insertNodeBeginning(start, val);
    }else{
        struct node *ptr, *nPtr;
        ptr = *start;
        
        while((nPtr = (*ptr).next) != NULL)
            ptr = nPtr;
        
        struct node *newN = createNode();
        (* newN).data = val;
        assert((* newN).next == NULL);
        (* ptr).next = newN; 
    }
}

struct node *searchForNode(struct node **start, int val)
{
    struct node *ptr, *nPtr, *res = NULL;
    ptr = *start;
    
    while((nPtr = (*ptr).next) != NULL)
        if ((*ptr).data == val){
            res = ptr;
            break;
        }else
            ptr = nPtr;
    
    return res;
}

void deleteNodeBeginning(struct node **start)
{
    struct node *ptr; // do I need this node ??
    ptr = *start;
    
    *start = (*ptr).next;
    free(ptr); 
}

void deleteNodeEnd(struct node **start)
{
    struct node *ptr, *nPtr;
    ptr = *start;
    
    if((*ptr).next == NULL){
        printf("Single node");
        deleteNodeEnd(start); // When there is a single node
    }else{
        nPtr = (*ptr).next; // it is always one node ahead
        while((nPtr = (*nPtr).next) != NULL)
            ptr = (*ptr).next;
        
        struct node * old;
        old = (*ptr).next;
        free(old);
        (*ptr).next = NULL;
    }        
}   
