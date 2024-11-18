#include<bits/stdc++.h>
using namespace std;
class romjan{
    public:
        string name;
        int age;
        int roll;
    
        romjan(string name, int age, int roll){

            (*this).name = name;
            this->age= age;
            this->roll = roll;

    }
};
int main(){

    romjan *rm = new romjan("MD ROMJAN ALI", 20,677844);
    cout<<"Name :" << rm->name<<endl;
    cout<<"Age :" << rm->age<<endl;
    cout<<"Roll :" << (*rm).roll<<endl;
    
return 0;
}