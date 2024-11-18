#include<bits/stdc++.h>
using namespace std;
int main(){


    vector<string>v(2);//now size is 2.
    v.push_back("hii");
    v.push_back("hello");//now size is 4.
    cout<<v.size(); //4
    
    v.resize(8,"hello");// new size is 8 and every new-string = "hello".
    cout<<v.size();//8
    v[3]="md romjan ali";
    cout<<v[3];// md romjan ali
    cout<<v[3][3];// r
    
    string s = "hay";
    v.push_back(s);
    cout<<v.back();//hay
return 0;
}