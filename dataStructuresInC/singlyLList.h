/*
    Cases to Analyse:
        Transversing (Iterating singly Linkedlist)
        Searching for a value
        Insertion
            At the beginning
            At the end
            After a given node (THINK HOW TO BE ABSTRACT)
            Before a given node (THINK HOW TO BE ABSTRACT)
        Deletion
            At the beginning
            At the end
            After a given node (THINK HOW TO BE ABSTRACT)
*/

struct node 
{
    int data;
    struct node *next;
};


struct node *createNode(); // it allocates the memory for a node struct dynamically

void insertNodeBeginning(struct node **start, int val); // insert a node in the beginning of the list

void insertNodeEnd(struct node **start, int val); // insert a node in the end of the list

struct node *searchForNode(struct node **start, int val); // search for the node with the specified value and returns it if found and NULL otherwise

void deleteNodeBeginning(struct node **start); // deletes a node from the beginning

void deleteNodeEnd(struct node **start); // deletes a node from the end of the list
