// it's complax too. we should check this vedio.
//https://phitron.io/ph453/video/ph453-6-1-reference-of-a-pointer

// it's called pass by value. here we pass a pointer not value.
// #include<bits/stdc++.h>
// using namespace std;
// void fun(int * p)// p is a pointer it's hold pointer but if we make change anything here the pointed value may be change. but the "ptr" pointer won't be change.
// {
//     p=NULL;
//     cout<<&p<<endl; // it's print address of "p".
// }
// int main(){
//     int val=10;
//     int *ptr = &val;
//     fun(ptr);
//     cout<<ptr<<endl;// we receive a address not "NULL" because the "p" and ptr r not same. "p" take just a address from "ptr". "p" is another pointer.
//     cout<<&ptr<<endl; //it's print address of "ptr";
// return 0;
// }


// // it's called pass by reference.
// #include<bits/stdc++.h>
// using namespace std;
// void fun(int * &p)// "p" and "ptr" is connected. i mean same pointer. 
// {
//     p=NULL;
//     cout<<&p<<endl;
// }
// int main(){
//     int val=10;
//     int *ptr = &val;
//     fun(ptr);
//     cout<<&ptr<<endl;
//     // cout<<*ptr<<endl; // we get a error here because ptr=NULL, that's why we can't dereference it. we make ptr=null by the function.

// return 0;
// }