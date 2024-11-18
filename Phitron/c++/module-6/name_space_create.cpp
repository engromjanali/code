// name space is a group. what contain variable,function,class ETC.

#include<bits/stdc++.h>
using namespace std;
namespace romjan{
    string name;
    int age;
    int roll;
    void fun(){
        cout<<"Hay, I Am fun."<<endl;
    }
    class Romjan{
        int age;
        int roll;
        string name;
    };
}
using namespace romjan;
int main(){
    name = "md romjan ali";
    cout<<name<<endl;
    fun();
return 0;
}