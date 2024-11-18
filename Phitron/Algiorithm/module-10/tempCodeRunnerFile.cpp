 s, d;
    cin>>s>>d;
    //bfs(grap, s);
    int current = d;
    vector<int>path;
    while(current != -1)
    {
        path.push_back(current);
        current = parent[current-1];
    }
    reverse(path.begin() , path.end());
    for(int x : path)
    {
        cout<<x<<" ";
    }
    cout<<"ma