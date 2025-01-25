#include <bits/stdc++.h>
using namespace std;

// A Huffman Tree Node
struct Node {
    char data;
    int freq;
    Node *left = NULL;
    Node *right= NULL;

    Node(char data, int freq) {
        this->data = data;
        this->freq = freq;
    }
};

// Custom comparator for the priority queue
struct Compare {
    bool operator()(Node* l, Node* r) {
        return l->freq > r->freq; // Min-Heap based on frequency
    }
};

// Function to print Huffman Codes
void printCodes(Node* root, string str) {
    if (!root) return;

    // If this is a leaf node, it contains a character
    if (!root->left && !root->right) {
        cout << root->data << ": " << str << "\n";
    }

    // Recur for left and right subtrees with updated codes
    printCodes(root->left, str + "0");
    printCodes(root->right, str + "1");
}

// Huffman Encoding Algorithm
Node* huffmanCoding(vector<char>& chars, vector<int>& freqs) {
    priority_queue<Node*, vector<Node*>, Compare> pq;

    // Create a leaf node for each character and push it to the priority queue
    for (size_t i = 0; i < chars.size(); ++i) {
        pq.push(new Node(chars[i], freqs[i]));
    }

    // While the size of the queue is greater than 1
    while (pq.size() > 1) {
        // Extract the two nodes with the lowest frequency
        Node* left = pq.top();
        pq.pop();
        Node* right = pq.top();
        pq.pop();

        // Create a new internal node with a frequency equal to the sum of the two nodes
        Node* newNode = new Node('$', left->freq + right->freq);
        newNode->left = left;
        newNode->right = right;

        // Add the new node to the priority queue
        pq.push(newNode);
    }

    // The remaining node is the root of the Huffman Tree
    Node* root = pq.top();
    return root;
}

int main() {
    // Input characters and their frequencies
    vector<char> chars = {'a', 'b', 'c', 'd', 'e', 'f'};
    vector<int> freqs = {5, 9, 12, 13, 16, 45};

    // Call Huffman Coding function
    Node* root = huffmanCoding(chars, freqs);
    // Print 
    printCodes(root, "");
    return 0;
}
