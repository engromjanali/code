#include <bits/stdc++.h> 
/*
	Tree Node class.

	class BinaryTreeNode 
	{
		T data;
		BinaryTreeNode<T> *left;
		BinaryTreeNode<T> *right;

		BinaryTreeNode(T data) {
			this->data = data;
			left = NULL;
			right = NULL;
		}
	}
*/
// sum_of_left_children_node

long long left_value(BinaryTreeNode<int> *root)
{
	
	if(root==NULL) return 0;
	long long int sum =0;
	if(root->left != NULL) 
	sum += root->left->data;
	sum += left_value(root->left);
	sum += left_value(root->right);

	return sum;
}

long long leftSum(BinaryTreeNode<int> *root)
{
	left_value(root);
}