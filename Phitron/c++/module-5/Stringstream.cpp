#include<bits/stdc++.h>
using namespace std;
int main(){
    string s = "md romjan ali";
    stringstream ss(s);// with constractor
    // stringstream ss;// with out constractor just declear
    // ss<<s; // opration
    string word;
    while(ss>>word){
        cout<<word<<endl;
    }
    return 0;
}