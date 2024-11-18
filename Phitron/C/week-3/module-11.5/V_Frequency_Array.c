// 10 5
// 1 2 3 4 5 3 2 1 5 3

// 2
// 2
// 3
// 1
// 2
// Note
// Numbers from 1 to 5 appearance are :

// 1 appears 2 times in the array .
// 2 appears 2 times in the array.
// 3 appears 3 times in the array.
// 4 appears once in the array.
// 5 appears 2 times in the array.


#include <stdio.h>
#include<string.h>

int main(){
int N,M;
scanf("%d %d", &N, &M);
int arr[N];
for(int i =0; i<N; i++){
    scanf("%d", &arr[i]);
}    
int count[M];
for(int i=0; i<M;i++){
    count[i]=0;
}

for(int i = 0; i<N; i++){
    if(arr[i]<=M && arr[i]>0){
        int val = arr[i];
        count[val-1]++;
    }
}
for(int i =0; i<M;i++){
printf("%d\n",count[i]);
}
return 0;
}