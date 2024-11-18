
// there's a small issue with it. When you use scanf("%c", &arr[i]), it reads newline characters (\n) as well.
// To avoid this, you can put a space before %c in the scanf format string.
// Here's the corrected version:

#include<stdio.h>
int main(){
    int N =5;
    scanf("%d", &N);
    char arr[5];

    for(int i =0; i<5; i++){
    scanf(" %c",  &arr[i]);//we must have to give a space befare %c. 
    printf("%d\n",i);
    }

return 0;
}

// #include<string.h>
// #include<stdio.h>
// int main(){
//     int N;
//     scanf("%d ", &N);
//     for(int i = 0; i<N; i++){
//     char arr[101];
//     //scanf("%s", arr);
//     gets(arr);  //gets and fgets capture \n that's why when we take input of N. and click enter fgets capture the enter. that's why fast loop won't work. to egnore the problem we have to give a space in after pre inputed data type. example "scanf("%d ", &N);""
//     int len = strlen(arr);
//     if(len>10){
//     printf("%c%d%c\n",arr[0],len-2,arr[len-1]);
//     }
//     else{
//         printf("%s\n", arr);
//     }
//     }
// return 0;
// }
