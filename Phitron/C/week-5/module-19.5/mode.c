    int max_element, value_count=0;
    for(int i=0; i<N;i++){
        int count =0;
        for(int j = 0; j<N; j++){
            if(arr[i]==arr[j]){
                count ++;
            }
        }
        if(count>value_count){
            value_count=count;
            max_element=arr[i];
        }
    }