#include<bits/stdc++.h>
using namespace std;
int main(){

    string sl;
    getline(cin,sl);

    stringstream ss(sl);
    string word;
    int i =0;
    int j =0;
    while(ss>>word){
        for(j=0; j<word.size(); j++){
            if((word[j]>=65 && word[j]<=90) || (word[j]>=97 && word[j]<=122)){
                i++;
                break;
            }
        }
    }
    cout<<i;
return 0;
}