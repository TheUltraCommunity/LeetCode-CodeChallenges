#include <stdio.h>
#include <stdlib.h>

// Definition for a doubly linked list node
typedef struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
    struct Node* down;
} Node;

// Function to create a new node
Node* createNode(int data) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;
    newNode->down = NULL;
    return newNode;
}

// Function to print the doubly linked list
void printList(Node* head) {
    Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

// Function to collect all nodes in the linked list into an array
void collectNodes(Node* root, Node** arr, int* index) {
    Node* temp = root;
    while (temp != NULL) {
        arr[*index] = temp;
        (*index)++;
        if (temp->down != NULL) {
            collectNodes(temp->down, arr, index);
        }
        temp = temp->next;
    }
}

// Comparator function for qsort
int compare(const void* a, const void* b) {
    Node* nodeA = *(Node**)a;
    Node* nodeB = *(Node**)b;
    return nodeA->data - nodeB->data;
}

// Function to flatten the linked list and sort it
Node* flattenAndSort(Node* root) {
    if (!root) return NULL;

    // Array to store the nodes
    int maxNodes = 100;  // Adjust size if necessary
    Node** nodeArray = (Node**)malloc(maxNodes * sizeof(Node*));
    int index = 0;

    // Collect all nodes
    collectNodes(root, nodeArray, &index);

    // Sort the nodes
    qsort(nodeArray, index, sizeof(Node*), compare);

    // Rebuild the sorted doubly linked list
    for (int i = 0; i < index - 1; i++) {
        nodeArray[i]->next = nodeArray[i + 1];
        nodeArray[i + 1]->prev = nodeArray[i];
        nodeArray[i]->down = NULL; // Clear down pointers
    }
    nodeArray[index - 1]->next = NULL;
    nodeArray[index - 1]->down = NULL;

    Node* newHead = nodeArray[0];
    free(nodeArray);

    return newHead;
}

int main() {
    Node* head = createNode(1);
    head->next = createNode(2);
    head->next->prev = head;
    head->next->next = createNode(8);
    head->next->next->prev = head->next;

    head->next->down = createNode(3);
    head->next->down->next = createNode(4);
    head->next->down->next->prev = head->next->down;
    head->next->down->next->next = createNode(7);
    head->next->down->next->next->prev = head->next->down->next;

    head->next->down->next->down = createNode(5);
    head->next->down->next->down->next = createNode(6);
    head->next->down->next->down->next->prev = head->next->down->next->down;

    Node* newHead = flattenAndSort(head);
    
    printList(newHead);

    return 0;
}
