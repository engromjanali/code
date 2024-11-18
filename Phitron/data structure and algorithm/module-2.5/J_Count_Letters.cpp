#include<bits/stdc++.h>
using namespace std;
int main(){

    vector<char>S;
    while(1)
    {
        char a;
        a= cin.get();
        if(a=='\n')
        {
            break;
        }
        else{
            S.push_back(a);
        }
    }
    int count[26]={0};
    for(char x : S)
    {
        count[x-97]++;
    }
    for(int i =0; i<26; i++)
    {
        if(count[i]>0){
            char a='a';
            a+=i;
            cout<<a<< " : "<<count[i]<<endl;
        }
    }


return 0;
}