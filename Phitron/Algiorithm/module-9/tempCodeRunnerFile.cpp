    vector<int>path;
    int current = d;
    while(current != -1)
    {
        path.push_back(current);
        current = parent[current];
    }
    reverse(path.begin(), path.end());
    for( int x : path)
    {
        cout<<x<<" ";
    }