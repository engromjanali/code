#include<bits/stdc++.h>
using namespace std;
class Student{
    public :

        string name;
        int cls;
        char section;
        int student_id;
        int math_mark;
        int english_mark;

        void set_data(string name, int cls, char section,int student_id, int math_mark, int english_mark)
        {
            this->name= name;
            this->cls= cls;
            this->section= section;
            this->student_id= student_id;
            this->math_mark= math_mark;
            this->english_mark= english_mark;
        }

};
bool comp(Student a, Student b)
{
    if(a.english_mark>b.english_mark){
        return true;
    }
    else if(a.english_mark==b.english_mark)
    {
        if(a.math_mark>b.math_mark)
        {
            return true;
        }
        else if(a.math_mark==b.math_mark)
        {
            if(a.student_id<b.student_id){
                return true;
            }
        }
    }

    return false;
}
int main(){
    int N;
    cin>>N;
    int j=N;
    Student * arr =new Student[N];
    while(N--)
    {
        string name;
        int cls;
        char section;
        int student_id;
        int math_mark;
        int english_mark;
        cin>>name>>cls>>section>>student_id>>math_mark>>english_mark;
        arr[N].set_data(name, cls, section, student_id, math_mark, english_mark);
    }
    
    sort(arr,arr+j,comp);
    for(int i=0; i<j; i++)
    {
        cout<< arr[i].name<<" "<< arr[i].cls<<" "<< arr[i].section<<" "<< arr[i].student_id<<" " <<arr[i].math_mark<<" " <<arr[i].english_mark<<" " <<endl;
    }

return 0;
}
