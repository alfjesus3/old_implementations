# dataStructuresInC
- This project contains my implementations of relevant Data structures at low level abstraction using C.


Usage
-------

```

make  // to generate the executable files
make clean // to clean the .o files and executable files

// What's happening inside the MAKEFILE
    // First the testFile and the dataStructure are compiled separatly
    gcc -Wall -c <testFile>.c
    gcc -Wall -c <dataStructure>.c
    // The object files generated previously are linked together to make the final executable file
    gcc -o testing <dataStructure>.o <testFile>.o

```

TODOs
------
- Introduce more abstract structure so it can work other data types;
- Implement Tree, a Heap, graphs and hashing and collision data structure;

DONE
------
- Create Makefile for proj;
