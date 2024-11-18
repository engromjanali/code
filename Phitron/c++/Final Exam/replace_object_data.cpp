#include<bits/stdc++.h>
using namespace std;
class student{
    public:
    string name;
    int cls;
    char section;
    int id;

    void setData(string name, int cls, char section, int id){
        this->name = name;
        this->cls = cls;
        this->section = section;
        this->id= id;
    }


};
int main(){
    int N;
    cin>>N;
    student * st = new student[N];
    int j=N, p=N-1;
    while(j--){
        string NAME;
        int CLS;
        char SECTION;
        int ID;
        cin>>NAME>>CLS>>SECTION>>ID;

        st[j].setData(NAME, CLS, SECTION, ID);
    }

    while(j<=N-1)
    {
        st[j].id = st[j].id + st[N].id;
        st[N].id = st[j].id - st[N].id;
        st[j].id = st[j].id - st[N].id;
        j++;
        N--;
    }

    for(int i =p; i>=0; i--)
    {
        cout<<st[i].name<<" "<<st[i].cls<<" "<<st[i].section<<" "<<st[i].id<<endl;

    }
    delete  [] st;
return 0;
}