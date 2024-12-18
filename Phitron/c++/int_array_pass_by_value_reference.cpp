#include<bits/stdc++.h>
using namespace std;
int Knapsack(int n, int s, int items[], int weight [])// pass by reference. there are no way to pass by value. for pass by value we have to use dynamic array.
{

}
int main(){

    int n,w;
    cin>>n>>w;          
    int item[n];
    int weight[n];
    for(int i =0; i<n; i++)
    {
        int product, wit;
        cin>>product>>wit;
        item[i]= product;
        weight[i] = wit;
    }
    cout<<Knapsack(n,w,item,weight);

return 0;
}