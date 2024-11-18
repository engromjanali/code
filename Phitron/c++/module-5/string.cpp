#include<bits/stdc++.h>
using namespace std;
int main(){

    // string s;
    // cout<<s.capacity(); //it's return 15 for fast time. and String is a  dinamic datatype/class, and it's auto increment it's size.
    // s = "md romjan ali";

    // // capacity:
    //     s.size();//for size of the string.
    //     s.max_size();//for max size of the system capacity to take array langth.
    //     s.capacity(); //for current length of string.
    //     s.clear();// to clear the Array/String. and it's size will be zero / 0.
    //     s.empty();// it's return  true and false if the string is empty it's return true otherwise return false.
    //     s.resize(7);//it's resize the size of string.
    //     s.resize(7,'X');//it's resize also, but the null and garbage value will be replace by the definded charecter.
    
    // // Element access:
    //     s[0];//for fast index.
    //     s.at(0);//for fast index.
    //     s.front();//for fast index.
    //     s[s.size()-1];//for last index.
    //     s.back();//for last index.
    //     s[10];//for 11th index. 
    //     s.at(10);//for 11th index. 
    //     cin>>s;//to take string without space, that's mean space won't take.
    //     s.substr(start_index , length);
    // // Modifier :
    //     string A, B;
    //     A  = "Md Romjan";
    //     B  = "Ali";
    //     A+=B;// to add B in A
    //     A.append(B);// to add B in A
    //     A.push_back('H');// to add a charecter in last of string.
    //     A.pop_back();// to remove last charecter from the string.
    //     A.assign("xyz");// like A= "xyz";
    //     A.erase(2,3);// to delete spacific few cherecter from a String, the fast argument of erase function it's mean start index, and 2nd argument mean how many character. 
    //     A.replace(2,3,B);//fast 2 argument like erase function and 3rd argument is a string what will be replace in erased place.
    //     A.insert(3,"xyz"); // it's will be inserted in fast arguments index.

    // //Iterators:
    //     //itrator is a pointer and it's is a private element so we can dereferance it and use it, 
    //     cout<<*A.begin()<<endl;// it's return fast index.
    //     cout<<*(A.end()-1)<<endl;// it's return next index of last index. that's why we can do -1 from it's pointer to get last index.
        string A = "sdfsdgsdgh";
        //for(auto itr=A.begin(); itr<A.end(); itr++){
        for(string :: iterator itr=A.begin(); itr<A.end(); itr++){
            cout<<*itr<<endl;
        }
 

return 0;
}