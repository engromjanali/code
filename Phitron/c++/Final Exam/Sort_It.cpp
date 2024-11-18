//    https://www.hackerrank.com/contests/final-exam-a-introduction-to-c-for-dsa-a-batch-03/challenges/sort-it-6-2/submissions/code/1381199603


#include<bits/stdc++.h>
using namespace std;
class Student{
    public :

        string name;
        int cls;
        char section;
        int student_ID;
        int math_mark;
        int english_mark;

        void student_set( string name, int cls, char section, int student_ID, int math_mark, int english_mark)
        {
        this->name = name;
        this->cls = cls;
        this->section = section;
        this->student_ID = student_ID;
        this->math_mark = math_mark;
        this->english_mark = english_mark;
        }

        void display(){
            cout<<name<<" "<< cls<<" "<< section<<" "<< student_ID<<" "<< math_mark<<" "<< english_mark<<endl;
        }
};
bool  com(Student & A, Student & B)
{
    bool res = false;

    if(A.math_mark+A.english_mark > B.math_mark+ B.english_mark){// for desanding order.
        res = true;
    }
    else if((A.math_mark+A.english_mark == B.math_mark+ B.english_mark) && A.student_ID<B.student_ID){
        res = true;
    }

    return res;

}
int main(){

    int N;
    cin>> N;
    Student * arr = new Student[N];
    int X = 0;
    while(X!=N){
        string name;
        int cls;
        char section;
        int student_ID;
        int math_mark;
        int english_mark;


        cin>> name>> cls>> section>> student_ID>> math_mark>> english_mark;

        arr[X].student_set(name,cls,section,student_ID,math_mark,english_mark);
        X++;
        
    }
    //object array sorting

    sort(arr, arr+N,  com);

    //output :
    for(int i =0; i< N; i++)
    {
        arr[i].display();
    } 

return 0;
}