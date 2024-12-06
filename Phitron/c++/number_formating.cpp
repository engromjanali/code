#include<bits/stdc++.h>
using namespace std;

int length_of_int(int num)
{
    int res = 0; 
    while (num>0)
    {
        num /=10;
        res++;
    }
    return res;
}

int fast_digit(int num)
{
    while (num>10)
    {
        num/=10;
    }
    return num;
}

int last_digit(int num)
{
    return num%10;
}

int powr(int base, int pr)
{
    int res = base;
    if(pr ==0) return 1;
    for(int i =0; i<pr-1; i++)
    {
        res *= base;
    }
    return res;
}

int first_n_digit(int num, int n)
{
    return num/powr(10,length_of_int(num)-n);
}

int N_th_digit(int num , int n)
{
    return first_n_digit(num,n)%10;;
}

int add_in_last(int num, int N_d)
{
    return (num*10)+N_d;
}

int add_in_first(int num, int N_d)
{
    return (N_d * powr(10,length_of_int(num))+num);
}

int last_n_digit(int num, int n)
{
    return num%(powr(10,n));
}

int insert_in_position(int num, int p, int v)
{
    int f_p = first_n_digit(num, p-1);
    int l_p = last_n_digit(num,length_of_int(num)-length_of_int(f_p));

    f_p = f_p * 10+v;
    f_p = f_p * powr(10,length_of_int(l_p)) + l_p;
    return f_p;
}

int main(){

    int num = 28563;
    
    int power = powr(10,2);
    int len = length_of_int(num);

    int First_d = fast_digit(num);
    int Last_d = last_digit(num);
    
    int n =2;
    int N_th_digit = first_n_digit(num,n)%10;
    
    int First_n_digit = first_n_digit(num,n);
    int Last_n_digit = last_n_digit(num, n);

    int Add_in_first = add_in_first(num , n);
    int Add_in_last = add_in_last(num , n);
    int insert_position = insert_in_position(num,2,9);

    string s = "34523462";
    int d = stoi(s);//string to int bilt_in_function.

    cout<<Last_d;

return 0;
}