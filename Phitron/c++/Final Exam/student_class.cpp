#include<bits/stdc++.h>
using namespace std;
class student{
    public:
    string name;
    int cls;
    char section;
    int math_mark;
    int english_mark;

    void setData(string name, int cls, char section, int math_mark, int english_mark){
        this->name = name;
        this->cls = cls;
        this->section = section;
        this->math_mark = math_mark;
        this->english_mark = english_mark;
    }


};
int main(){
    int N;
    cin>>N;
    student * st = new student[N];
    int j=N;
    while(j--){
        string NAME;
        int CLS;
        char SECTION;
        int MATH;
        int ENGLISH;
        cin>>NAME>>CLS>>SECTION>>MATH>>ENGLISH;

        st[j].setData(NAME, CLS, SECTION, MATH, ENGLISH);
    }

    for(int i =0; i<N; i++)
    {
        cout<<st[i].name<<" "<<st[i].cls<<" "<<st[i].section<<" "<<st[i].math_mark<<" "<<st[i].english_mark<<endl;

    }
    delete [] st;
return 0;
}