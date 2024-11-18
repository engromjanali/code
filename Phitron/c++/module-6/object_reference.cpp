#include<bits/stdc++.h>
using namespace std;
void print(string s){//here we are passing value as a copy that's why main value won't change.
    s="abc";
}

void print1(string & s){//we are passing  value as a reference. so main value will be change. it's not a pointer, it's reference object.
    s="abc";
}
int main(){

    string s = "xyz";
    print(s);
    cout<<s<<endl;
    print1(s);
    cout<<s<<endl;

return 0;
}

