// What is a Priority Queue?
// A Priority Queue is an abstract data structure similar to a regular queue, but where each element has a priority.

// In a regular queue, elements are served First-In-First-Out (FIFO).

// In a priority queue, the element with the highest priority is served first, regardless of the insertion order.

// Think of an emergency room:

// Patients are treated not based on arrival time, but on the severity of their condition (priority).

// 🔧 How is it implemented?
// In most languages (like Java), a priority queue is implemented using a heap — specifically:

// Min Heap: smallest element comes out first.

// Max Heap: largest element comes out first (can be created using comparators or negating values).

// In Java, it’s:

PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap by default