int getFourthLargest(int arr[], int n)
{
    int l_arr[4] = {-2147483648 ,-2147483648 ,-2147483648 ,-2147483648};
    for(int i =0; i<n; i++)
    {
        // fast larg
        if(l_arr[3] <= arr[i])
        {
            l_arr[0]=l_arr[1];
            l_arr[1]=l_arr[2];
            l_arr[2]=l_arr[3];

            l_arr[3] = arr[i];
        }
        else if(l_arr[2] <= arr[i])
        {
            l_arr[0]=l_arr[1];
            l_arr[1]=l_arr[2];

            l_arr[2] = arr[i];
        }
        else if(l_arr[1] <= arr[i])
        {

            l_arr[0]=l_arr[1];

            l_arr[1] = arr[i];
        }
        else if(l_arr[0] <= arr[i])
        {
            l_arr[0]=arr[i];
        }
    }
    return l_arr[0];
}