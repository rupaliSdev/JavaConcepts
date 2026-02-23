🔥 1️⃣ What is a Heap?

A Heap is:

A Complete Binary Tree that follows Heap Property

Complete Binary Tree

Filled level by level

Left to right

No gaps

🔹 2️⃣ Types of Heap
🟢 Min Heap

Parent ≤ Children
Smallest element at root

🔵 Max Heap

Parent ≥ Children
Largest element at root

🔹 3️⃣ Why Heap is Stored in Array?

Because it’s complete.

Index relationships:

If node index = i

Left child  → 2i + 1
Right child → 2i + 2
Parent      → (i - 1) / 2

No need for pointers.

🔥 4️⃣ Height of Heap

If heap size = k

Nodes grow like:

1
2
4
8
...

So:

2^h ≈ k
h ≈ log k

👉 Height = log k

This is why operations are log k.

🔥 5️⃣ Core Heap Operations
✅ INSERT (Heapify Up)

Steps:

Insert at end

Compare with parent

Swap if needed

Continue upward

Worst case:

Bottom → root

Moves log k levels

Time = O(log k)

✅ DELETE ROOT (Heapify Down)

Steps:

Remove root

Replace with last element

Compare with children

Swap downward

Worst case:

Root → leaf

log k swaps

Time = O(log k)

🔥 6️⃣ What is HEAPIFY?

Heapify means:

Fix heap property at a given index

There are two types:

🔹 Heapify Up

Used after insertion
Move element upward

🔹 Heapify Down

Used after deletion
Move element downward

🔥 7️⃣ Build Heap (VERY IMPORTANT)

Given unsorted array → convert into heap.

Naively:

Insert each element

O(n log n)

Better way:

Start from last non-leaf node and heapify down.

Why?

Leaves are already heaps.

🔹 Last Non-Leaf Node

If n elements:

Last index = n-1
Last non-leaf = (n/2) - 1

We heapify from:

(n/2 - 1) → 0
🔥 Why Build Heap is O(n) (Important Interview Question)

Even though heapify is O(log n),

Most nodes are near bottom,
So they move very little.

Total cost:

n/2 nodes → height 1
n/4 nodes → height 2
n/8 nodes → height 3
...

Total:

n(1/2 + 2/4 + 3/8 + ...)
= O(n)

So:

Build Heap = O(n)

🔥 8️⃣ Top K Pattern

We keep heap size = k.

For n elements:

Each insertion = log k

Total = n log k

Space = k

🔥 9️⃣ Two Heaps Concept (Median)

We use:

MaxHeap → left half

MinHeap → right half

Maintain:

Size difference ≤ 1

Left max ≤ Right min

Insert → O(log n)
Find median → O(1)

🔥 🔟 Lazy Deletion (Advanced)

Problem:
Heap doesn’t support removing arbitrary element efficiently.

Solution:

Use HashMap to mark deletions

Remove only when element reaches top

Used in:

Sliding window median

🔥 1️⃣1️⃣ QuickSelect vs Heap

QuickSelect:

Based on partition

Average O(n)

Worst O(n²)

Heap:

O(n log k)

Safe worst case

Good for streaming

🔥 1️⃣2️⃣ Heap vs Sorting

Sorting:
O(n log n)

Heap Top K:
O(n log k)

If k << n → heap better.

🔥 1️⃣3️⃣ Common Interview Traps

⚠️ Comparator overflow:

(b - a)  ❌
Integer.compare(b, a) ✅

⚠️ Forget to rebalance two heaps
⚠️ Confuse log n vs log k
⚠️ Forget build heap is O(n)

🔥 1️⃣4️⃣ When to Think Heap?

If question says:

Kth largest

Top K

Running median

Merge K lists

Always need min/max quickly

Stream processing

Think → Heap

🧠 Final Mental Model

Heap = Complete tree
Height = log(size)
Insert/Delete = log(size)
Build heap = n

Everything depends on height.