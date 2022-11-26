
/*
    Variations: Based on Array, Based on Linked List
    Variables:  FRONT, REAR
    Operations: insert, delete, peek
    
    More specifically, using the linked list implementation:
        - The insert operation is a insertNodeEnd of singlyLList.h
        - The delete operation is the deleteNodeBeginning of singlyLList.h
*/

#include "singlyLList.h"

struct queue
{
    struct node *front;
    struct node *rear;
};

struct queue *createQueue(); // allocates dynamically the memory for the Queue pointer

void insertInQueue(struct queue **, int); // adds a new node in the queue rear using insertNodeEnd from singlyLList

void deleteInQueue(struct queue **); // removes the node in front of the queue using deleteNodeBeginning from singlyLList
