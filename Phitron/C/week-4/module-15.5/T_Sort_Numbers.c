#include<stdio.h>
void copy_arrays(int * arr,int copy[], int N){
    for(int i=0; i<N; i++){
        copy[i]=arr[i];
    }
}
void output(int * p, int N){
    for(int i =0; i<N; i++){
        printf("%d\n", p[i]);
    }
    printf("\n");
}
void ascending_order(int * p, int N){
    for(int i =0; i<3; i++){
        for(int j =i+1; j<N; j++){
            if (p[i]>p[j]){
                p[i]= p[i]+ p[j];
                p[j]= p[i]-p[j];
                p[i] = p[i]- p[j];
            }
        }
    }
    output(p,N);
}

int main (){
    int arr[3];
    scanf("%d %d %d",&arr[0],&arr[1],&arr[2]);
    int copy_array[3];
    copy_arrays(arr,copy_array,3);
    ascending_order(arr,3);
    output(copy_array,3);
}