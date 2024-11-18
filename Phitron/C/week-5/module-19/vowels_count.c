#include<stdio.h>
#include<string.h>
int fun(char * arr,int i){
    if(arr[i]=='\0') return 0;
    int result = fun(arr,i+1);
    if(arr[i]>='A' && arr[i]<=90){
        arr[i]+=32;
    }
    if(arr[i]=='a'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='e'){
        result++;
        return result;
    }
    else{
        return result;
    }
}
int main(){
    char a[10000];
    fgets(a,255,stdin);
    int x = fun(a,0); 
    printf("%d", x);
return 0;
}