#include<bits/stdc++.h>
using namespace std;

int main(){

vector<int> v;
int N;
cin>>N;
while(N--)
{
    int a;
    cin>>a;
    v.push_back(a);
}

int f =0;
int l = v.size()-1;
int target; cin>>target;
string res ="Not Found";

while(f<=l) // we mist have to use "<=". because for a single value "l==r".
{
    int mid = (l + f)/2;
    if(v[mid] == target)
    {
        res = to_string(mid);
        break;
    } 
    if(v[mid] >  target)
    {
        l = mid-1;
    }
    else f = mid + 1;
}
cout<<res;
return 0;
}