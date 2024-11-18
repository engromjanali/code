#include<bits/stdc++.h>
using namespace std;
string print(string & x, int a){
    string res="";
    if(x[a]=='\0'){
        return "";
    }
    else {
        res+=print(x,a+1);
        res+=x[a];
        return res ;
    }
}
int main(){

    string s;
    getline(cin,s);
    stringstream ss(s);
    string word;
    s.clear();
    while(ss>>word){
        word = print(word,0);
        
        s.append(word);
        s.append(" ");
    }
    s.resize(s.size()-1);
    cout<<s;
return 0;
}