#include<bits/stdc++.h>
using namespace std;
int main(){
string s;
char a;
int i=0;
while(scanf("%c", &a)!= EOF){
    if(a==' '){
        
    }
    else if(a=='\n'){
        s+=' ';
    }
    else{
        s+=a;
    }
}
stringstream ss(s);
string word;
while (ss>>word)
{
sort(word.begin(),word.end());
cout<<word<<endl;
}
return 0;
}