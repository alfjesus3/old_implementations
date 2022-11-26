#include <stdio.h>
#include <stdlib.h>

#include "LListQueue.h"


struct queue *createQueue()
{
    struct queue *ptr;
    ptr = (void *)malloc(sizeof(struct queue));
    return ptr;
}

void insertInQueue(struct queue **qe, int val)
{
    if((**qe).front == NULL){
        (**qe).front = createNode();
        (**qe).front->data = val;
        (**qe).rear = (**qe).front;
    }else{
        struct node *ptr;
        ptr = (**qe).rear;
        insertNodeEnd(&ptr, val);
        (**qe).rear = ptr->next;
    }
}

void deleteInQueue(struct queue **qe)
{
    if((**qe).front == NULL){
        printf("UNDERFLOW\n");
    }else{
        struct node *ptr;
        ptr = (**qe).front;
        deleteNodeBeginning(&ptr);
        if(ptr != NULL)
            (**qe).front = ptr;
        else
            (**qe).front = (**qe).front = NULL;
    }
}
