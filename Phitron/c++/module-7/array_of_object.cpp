#include<bits/stdc++.h>
using namespace std;
class Persion {
    public :
        int roll;
        int age;
        string name;
        //we cant use constractor for object array. because array can't assign constractor.
         
};
int main(){
Persion arr[5];
for(int i=0; i<5; i++){
    cin>>arr[i].roll>>arr[i].age;
    cin.ignore();
    getline(cin,arr[i].name);
}
for(int i=0; i<5;i++){
    cout<<arr[i].roll<<" "<<arr[i].age<<" "<<arr[i].name<<endl;
}
    

return 0;
}