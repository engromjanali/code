#include<bits/stdc++.h>
using namespace std;

class Persion {
    public :
        string name;  
        int roll;
        int age;      
};
bool com(Persion A, Persion B)// we can't compayer by two object. but we can compare by object of element, like "obj.age".
{//it's for dessending order// for assending order we have to use "<" the oprator. 
    if(A.age > B.age){// the all over sort perfrom as a swap function, here the condition of "com" function decide formet of sorting. if the "com" function return true, sort wont't swap any thing. when "com" function return false the two object will be swap. what we receive in "com" function.
        return true;
    }
    else{
        return false;
    }
}
int main(){
    Persion arr[5];

    for(int i=0; i<5; i++)
    {
        cin>>arr[i].roll>>arr[i].age;
        cin.ignore();
        getline(cin,arr[i].name);
    }
    sort(arr, arr+sizeof(arr)/sizeof(arr[0]), com);// "com" is function what's deside sort format.
    for(int i=0; i<5;i++)
    {
        cout<<arr[i].roll<<" "<<arr[i].age<<" "<<arr[i].name<<endl;
    }

return 0;
}




