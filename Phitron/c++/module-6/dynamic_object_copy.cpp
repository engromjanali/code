#include<bits/stdc++.h>
using namespace std;
class Persion{
    public :
        string name;
        int age;
        Persion(string name, int age){
            this->name= name;
            (*this).age = age;
        }
};
int main(){

    Persion * romjan =  new Persion("Md Romjan Ali", 20);
    Persion * kapil  =  new Persion("Kapil Uddin", 19);

    //romjan = kapil; // that's mean we have changed pointer address of romjan. now we can access kapil by both object but we gat loss access of romjan object. the to ponter locate a same memory.
    //romjan.name = kapil.name; // we copy kapil name to romjan name.
    *romjan = *kapil; // we copy all from kapil to romjan. but romjan and kapil the two pointer locate 2 defrend memory. 

    cout<<romjan->name<<endl;
    cout<<romjan->age<<endl;

    cout<<kapil->name<<endl;
    cout<<kapil->age<<endl;

return 0;
}