//fast way it's dose not work in online but work in windows.
// 
// #include<bits/stdc++.h>
// using namespace std;
// int main(){
// 
    // int A;
    // cin>>A;
    // while(A--){
        // getchar();
        // string X, Y;
        // cin>>X;
        // cin>>Y;
// 
        // while(true)
        // {
            // if(X.find(Y) != 4294967295)
            // {
                // X.replace(X.find(Y), Y.length(),"$");
            // }
            // else{
                // break;
            // }
        // }
        // cout<< X<<endl;
    // }
// 
// return 0;
// }

//2nd way it created by chatgpt. it's work in online

// #include <bits/stdc++.h>
// using namespace std;

// int main() {
//     int A;
//     cin >> A;
//     while (A--) {
//         // Read the input strings
//         string X, Y;
//         cin >> X >> Y;

//         // Replace all occurrences of Y in X with "$"
//         size_t pos;
//         while ((pos = X.find(Y)) != string::npos) {
//             X.replace(pos, Y.length(), "$");
//         }

//         // Print the modified string
//         cout << X << endl;
//     }
//     return 0;
// }


#include<bits/stdc++.h>
using namespace std;
int main(){

    int A;
    cin>>A;
    while(A--){
        getchar();
        string X, Y;
        cin>>X;
        cin>>Y;

    for(int i=0; i<X.length(); i++){
        if(X.substr(i,Y.length()) == Y){
            X.replace(i,Y.length(), "$");
        }
    }
        cout<< X<<endl;
    }

return 0;
}
