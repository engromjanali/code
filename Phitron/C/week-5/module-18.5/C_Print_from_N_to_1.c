#include<stdio.h>
void fun(int N){
    if(N==1) {
    printf("%d", N);
        return;
    }
    printf("%d ", N);
    fun(N-1);

}
int main(){
    int N;
    scanf("%d", &N);
    fun(N);
return 0;
}