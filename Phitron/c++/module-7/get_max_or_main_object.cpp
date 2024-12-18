#include<bits/stdc++.h>
using namespace std;
class Persion {
    public :
        int roll;
        int age;
        string name;
        // Persion(int i){ //we can use constractor in dynamic object not static object.
        //     age=i;
        // }
         
};
int main(){
//Persion arr[5];// we can use static boject.
Persion * arr[3];// we can use dynamic boject also. but we have to initializ it after.
for(int i=0; i<3; i++){
    arr[i]= new Persion();
    //arr[i]= new Persion(0);//initialization but we can use constractor in dynamic object.
    cin>>arr[i]->roll>>arr[i]->age;
    cin.ignore();
    getline(cin,arr[i]->name);
}
Persion * mx = new Persion();
mx->age= INT_MIN;
for(int i=0; i<3;i++){
    if(arr[i]->age>mx->age){
        *mx = *arr[i];
        //mx= arr[i];// for static object.
    }
}
cout<<mx->name<<endl;
cout<<mx->roll<<endl;
cout<<mx->age<<endl;
    
return 0;
}