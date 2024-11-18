    char ar;
    int count [26] = {0};
    while(scanf("%c", &ar) != EOF){//EOF mean when we type (ctrl+z) then enter the loop will be break.
        int val= ar -'a';
        count[val]++;
    }

    for( int i =0; i <26; i++){
        if(count[i]!=0){
        printf("%c : %d\n",i+97,count[i]);
        }
    }
