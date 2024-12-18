bool dfs_cycle(int node, int parent, bool visited[], struct graph *g) {
    visited[node] = true;

    struct ListNode *adjNode = g->head[node];
    while (adjNode != NULL) {
        int neighbor = adjNode->data;

        // If the neighbor hasn't been visited, recurse
        if (!visited[neighbor]) {
            if (dfs_cycle(neighbor, node, visited, g)) {
                return true;
            }
        }
        // If the neighbor is visited and is not the parent, there's a cycle
        else if (neighbor != parent) {
            return true;
        }

        adjNode = adjNode->next;
    }

    return false;
}

bool isCycle(struct graph *g, int n, int m) {
    bool visited[N] = {false};

    for (int i = 0; i < n; i++) {
        // Perform DFS if the node is unvisited
        if (!visited[i]) {
            if (dfs_cycle(i, -1, visited, g)) {
                return true;
            }
        }
    }

    return false;
}



#include<bits/stdc++.h>
using namespace std;
void dfs_cycle(struct graph *g, vector<bool>visited, int node)
{
    visited[node] = true;
    struct ListNode * adjNode = g->head[node];
    while(adjNode != NULL)
    {
        if(visited[adjNode->data]) continue;
        dfs_cycle(g,visited,adjNode->data);
        adjNode = adjNode->next;
    }
}

bool isCycle(struct graph *g, int n, int m) {
    
    vector<bool>visited;
    for(int i =0; i<n; i++)
    {
        if(visited[i]) return true;
        dfs_cycle(g,visited,i);
    }
    return false;
}