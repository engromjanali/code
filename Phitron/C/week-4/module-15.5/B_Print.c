 #include<stdio.h>
void xyz(int N){
    for(int i =1; i<N; i++){
        printf("%d ",i);
    }
    printf("%d", N);
}
int main(){
    int N;
    scanf("%d", &N);
    xyz(N);
}