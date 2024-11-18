#include<bits/stdc++.h>
using namespace std;
void print(stringstream & ss){
    string word;
    if(ss>>word){
        print(ss);
        cout<<word<<endl;
    }
}
int main(){  //we can print a string as  reverse.(word by word not character) using "stringstream" class and "recursion".

    string s;
    getline(cin, s);
    stringstream ss(s);
    print(ss);

return 0;
}