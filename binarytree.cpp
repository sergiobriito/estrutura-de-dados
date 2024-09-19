#include <iostream>

using namespace std;

struct Node {
	int value;
	Node* left;
	Node* right;
	Node(int value) {
	    this->value = value;
	    this->left = nullptr;
	    this->right = nullptr;
	};
};

struct BinaryTree {
	Node* head;
	
	BinaryTree(Node* head){
	    this->head = head;
	};

	void addNode(Node* node) {
		int value = node->value;
		int headValue = head->value;
		if (value < headValue) {
			Node* curr = head;
			while (curr->left != nullptr) {
				curr = curr->left;
			};
			curr->left = node;
		} else {
			Node* curr = head;
			while (curr->right != nullptr) {
				curr = curr->right;
			};
			curr->right = node;
		};
	};
	

};

void printTree(Node* node, string direction) {
	if (node == nullptr) {
		return;
	};
	
	cout << node->value << " - " << direction << '\n';

	printTree(node->left, "left");
	printTree(node->right, "right");
};


int main() {
	Node* head = new Node(10);
	Node* node1 = new Node(5);
	Node* node2 = new Node(20);
	Node* node3 = new Node(7);
	Node* node4 = new Node(80);
    
    BinaryTree* tree = new BinaryTree(head);
    
    tree->addNode(node1);
    tree->addNode(node2);
    tree->addNode(node3);
    tree->addNode(node4);
    
	printTree(head, "head");

	return 0;
}