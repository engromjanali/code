// #include<stdio.h>
// int main(){
//     int a,b,c;
//     scanf("%d %d %d", &a, &b, &c);
//     if(a==b && b ==c){
//         printf("%d %d",b,a);
//     }
//     else if(a==b && a>c){
//         printf("%d %d",c,a);
//     }
//     else if(a==b && a<c){
//         printf("%d %d",a,c);
//     }
//     else if(a==c && a>b){
//         printf("%d %d",b,a);
//     }
//     else if(a==c && a<b){
//         printf("%d %d",a,b);
//     }
//     else if(b==c && b>a){
//         printf("%d %d",a,b);
//     }
//     else if(b==c && b<a){
//         printf("%d %d",b,a);
//     }

//     else if(a<b && a<c){
//         if(b>a && b>c){
//             printf("%d %d",a,b);
//         }
//         else if(c>a && c>b){
//             printf("%d %d",a,c);
//         }
//     }
//     else if(b<a && b<c){
//         if(c>a && c>b){
//             printf("%d %d",b,c);
//         }
//         else if(a>b && a>c){
//             printf("%d %d",b,a);
//         }
//     }
//     else if(c<b && c<a){
//         if(b>a && b>c){
//             printf("%d %d",c,b);
//         }
//         else if(a>b && a>c){
//             printf("%d %d",c,a);
//         }
//     }
// }

// 2nd way 

#include<stdio.h>
int main(){
    int a,b,c;
    scanf("%d %d %d",&a , &b, &c);
    if(a<=b && a<=c){
        printf("%d ",a );
    }
    else if(b<=a && b<=c){
        printf("%d ",b );
    }
    else if(c<=a && c<=b){
        printf("%d ",c );
    }

    if(a>=b && a>=c){
        printf("%d ",a );
    }
    else if(b>=a && b>=c){
        printf("%d ",b );
    }
    else if(c>=b && c>=a){
        printf("%d ",c );
    }
}