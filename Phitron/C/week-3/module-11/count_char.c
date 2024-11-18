// #include<stdio.h>
// int main(){
//     int N =5;
//     scanf("%d", &N);
//     char arr[N];

//     for(int i =0; i<N; i++){
//     scanf(" %c",  &arr[i]);
//     printf("%d\n",i);
//     }

//     int count [26] = {0};
//     for(int i =0; i<N; i++){
//         int val = arr[i]-'a';
//         count[val]++;
//     }

//     for( int i =0; i <26; i++){
//         printf("%c - %d\n",i+97,count[i]);
//         }


// return 0;
// }

// #include<stdio.h>
// #include<string.h>
// int main(){
//     int N =5;
//     scanf("%d", &N);
//     char arr[N];

//     for(int i =0; i<N; i++){
//     scanf(" %c",  &arr[i]);
//     }

//     int count [26] = {0};
//     for(int i =0; i<N; i++){
//         int val = arr[i]-'a';
//         count[val]++;
//     }

//     for( int i =0; i <26; i++){
//         if(count[i]!=0){
//         printf("%c - %d\n",i+97,count[i]);
//         }
//     }

// #include<stdio.h>
// #include<string.h>
// int main(){
//     int N =5;
//     scanf("%d", &N);
//     char arr[N];

//     for(int i =0; i<N; i++){
//     scanf(" %c",  &arr[i]);
//     }

//     int count [26] = {0};
//     for(int i =0; i<N; i++){
//         int val = arr[i]-'a';
//         count[val]++;
//     }

//     for( int i =0; i <strlen(arr); i++){
//         int val = arr[i]-97;
//         printf("%c - %d\n",val+97,count[val]);
        
//     }
// return 0;
// }