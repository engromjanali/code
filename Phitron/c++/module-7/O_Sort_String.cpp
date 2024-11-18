// it;s solved by counting sort.

#include<bits/stdc++.h>
using namespace std;
int main(){

    int N;
    cin>> N;

    int count[26] = {0};
for(int i=0; i<N; i++)
{
    char a;
    cin>>a;
    count[a-'a']++;
}
for(char i='a'; i<='z'; i++)
{
    if(count[i-'a']>0)
    {
        for(int j=0; j<count[i-'a']; j++)
        {
            cout<<i;
        }
    }
}

return 0;
}

// it's splved by genaral mood. depand's on my brain/mood
#include<bits/stdc++.h>
using namespace std;
int main(){
    int N;
    cin>>N;
    char A[N];
    getchar();
    gets(A);
    for(int i=0; i<N-1; i++){
        for(int j=i; j<N; j++){
            if(A[i]>A[j]){
                A[i]= A[i]+A[j];
                A[j]= A[i]-A[j];
                A[i]= A[i]-A[j];
            }
        }
    }
    for(int i=0; i<N; i++){
        cout<< A[i];
    }
}