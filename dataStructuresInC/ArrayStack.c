#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include "ArrayStack.h"

int *createStack()
{
    int *emptyStack;
    emptyStack = (void *)malloc(sizeof(int) * MAX_ST);
    return emptyStack;
}

void push(int **stack, int *top, int val)
{
    if(*top == (MAX_ST-1)){
        //printf("%d\n", (*top - (MAX_ST-1)));
        printf("*** OVERFLOW\n");
    }else{
        if(*top == -1)
            *stack = createStack();
        else
            (*stack)++;
        **stack = val;
        (*top)++;
    }        
}

int peek(int **stack, int *top)
{
    assert((*top >=0) && (*top<MAX_ST));
    return **stack;
}

void pop(int **stack, int *top)
{
    if((*top == -1)){
        printf("*** UNDERFLOW\n");
    }else{
        **stack = 0; // to "clean" the memory position
        (*stack)--; // the top becomes the previous contiguous memory space 
        (*top)--;  
    }
}
