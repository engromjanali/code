#include<bits/stdc++.h>
using namespace std;

class Student {
public:
    int marks;
    int roll;
    string name;

    Student(int m, int r, string n) : marks(m), roll(r), name(n) {}

    // For max heap (comparator for higher priority to higher marks)
    bool operator<(const Student& other) const {
        return marks < other.marks;
    }

    // For min heap (comparator for higher priority to lower marks)
    bool operator>(const Student& other) const {
        return marks > other.marks;
    }

    void display() const {
        cout << "Name: " << name << ", Roll: " << roll << ", Marks: " << marks << endl;
    }
};

// Function to print and clear a priority queue
template<typename T>
void printQueue(T& pq) {
    while (!pq.empty()) {
        pq.top().display();
        pq.pop();
    }
}

int main() {
    // Max Heap (highest marks first)
    priority_queue<Student> maxHeap;
    
    // Min Heap (lowest marks first)
    priority_queue<Student, vector<Student>, greater<Student>> minHeap;

    // Sample data
    maxHeap.push(Student(85, 1, "Alice"));
    maxHeap.push(Student(95, 2, "Bob"));
    maxHeap.push(Student(75, 3, "Charlie"));
    
    minHeap.push(Student(85, 1, "Alice"));
    minHeap.push(Student(95, 2, "Bob"));
    minHeap.push(Student(75, 3, "Charlie"));

    // Display max heap
    cout << "Max Heap (Highest Marks First):" << endl;
    printQueue(maxHeap);

    // Display min heap
    cout << "\nMin Heap (Lowest Marks First):" << endl;
    printQueue(minHeap);

    return 0;
}
