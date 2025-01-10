#include<bits/stdc++.h>
using namespace std;
class student{
public:
    string name;
    int roll;
    int mark;
    student(string nm, int rol, int mrk) : name(nm), roll(rol), mark(mrk){}
    void display()
    {
        cout<<name<<" "<<roll<<" "<<mark<<endl;
    }
};
class max_heap{
public:
    bool operator()(student A, student B){
        if(A.mark <B.mark) return true;
        else if(A.mark == B.mark)
        {
            if(A.roll > B.roll) return true;
            else return false;
        }
        else return false;
    }
};
int main(){

    int N;
    cin>>N;
    priority_queue<student, vector<student>, max_heap>stdn;
    while(N--)
    {
        string name;
        int roll, mark;
        cin>>name>>roll>>mark;
        student s(name, roll, mark);
        stdn.push(s);
    }
    int Q;
    cin>>Q;
    while (Q--)
    {
        int command;
        cin>>command;
        if(command == 0)
        {
            string name;
            int roll, mark;
            cin>>name>>roll>>mark;
            student s(name, roll, mark);
            stdn.push(s);

            student max = stdn.top();
            max.display();
        }
        else if(command == 1)
        {
            if(stdn.size() == 0) cout<<"Empty"<<endl;
            else{
                student max = stdn.top();
                max.display();
            }
        }
        else{
            if(stdn.size()==0) cout<<"Empty"<<endl;
            else if(stdn.size()==1){
                stdn.pop();
                cout<<"Empty"<<endl;
            }
            else{
                stdn.pop();
                student max = stdn.top();
                max.display();
            }
        }
    }
    
return 0;
}