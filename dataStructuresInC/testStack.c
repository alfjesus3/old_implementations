#include <stdio.h>

#include "ArrayStack.h"

//int *top = NULL;
int *arrStack = NULL;

int main(void)
{
    int top = -1;
    
    // Testing Push
    push(&arrStack, &top, 5);
    push(&arrStack, &top, 94);

    // Testing Peek
    printf("%d\n", peek(&arrStack, &top));
    
    //Testing Pop
    pop(&arrStack, &top);
    printf("%d\n", peek(&arrStack, &top));
    // testing Underflow
    pop(&arrStack, &top);
    pop(&arrStack, &top);

    //testing overflow
    int i;
    for(i=0; i<= MAX_ST; i++){
        push(&arrStack, &top,i);
        printf("%d\n",i);
    }
    
    return 0;
}
