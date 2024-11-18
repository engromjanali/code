#include<bits/stdc++.h>
using namespace std;

class student{
public :
    int roll;
    int age;
    string name;

    student(string name, int roll, int age)
    {
        this->roll = roll;
        this->age = age;
        this->name = name;
    }
    void display()
    {
        cout<<name<<" "<<roll<<" "<<age<<endl;
    }
};
class max_heap{
public:
    bool operator()(student a, student b)
    {
        //it's for MAX HEAP
        if(a.roll < b.roll) return true; // here if the class return true value will be swap. it's fully opposite of compare function of sort.
        else return false;
    }
};
class min_heap{
public:
    bool operator()(student a, student b)
    {
        if(a.roll > b.roll) return true; // here if the function return true value will be swap. it's fully opposite of compare function of sort.
        else return false;
    }
};
int main(){

    int N;
    cin>>N;
    priority_queue<student, vector<student>, max_heap>max_heap;
    priority_queue<student, vector<student>, min_heap>min_heap;
    
    while(N--)
    {
        int roll,age;
        string name;
        cin>>name>>roll>>age;
        student a(name,roll,age);
        max_heap.push(a);
        min_heap.push(a);
    }
    
    while(!max_heap.empty())
    {
        student a = max_heap.top();
        a.display();
        max_heap.pop();
    }

    cout<<endl;
    
    while(!min_heap.empty())
    {
        student a = min_heap.top();
        a.display();
        min_heap.pop();
    }

return 0;
}