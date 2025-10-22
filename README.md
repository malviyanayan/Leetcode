<div align="center">

# 🧠 LeetCode Java Solutions  
### Organized by Topic | Clean | Beginner-Friendly | Consistent  

</div>

## 📘 Introduction  
This repository contains my **LeetCode problem solutions** written in **Java**, neatly organized by topic such as Arrays, Strings, Dynamic Programming, DFS, BFS, and more.  
Each folder includes well-structured `.java` files that demonstrate clean code practices, optimal solutions, and detailed problem categorization — making it easy to navigate and learn.

---

## 📂 Folder Structure  
Leetcode/
├── arrays/
│ ├── Leetcode1.java
│ ├── Leetcode26.java
│ └── ...
├── string/
│ ├── Leetcode3.java
│ ├── Leetcode5.java
│ └── ...
├── dp/
│ ├── Leetcode70.java
│ ├── Leetcode198.java
│ └── ...
├── dfs/
│ ├── Leetcode733.java
│ ├── Leetcode200.java
│ └── ...
└── ...

arduino
Copy code

Each folder name represents a **topic**, and every file corresponds to a **specific LeetCode problem number**.

---

## 💻 Example Problem — *Leetcode733.java*  
**Problem:** Flood Fill  
**Topic:** DFS  

```java
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != color) return;
        image[r][c] = newColor;
        dfs(image, r + 1, c, color, newColor);
        dfs(image, r - 1, c, color, newColor);
        dfs(image, r, c + 1, color, newColor);
        dfs(image, r, c - 1, color, newColor);
    }
}
⚙️ How to Run Locally
Navigate to the problem directory:

bash
Copy code
cd Leetcode/dfs
Compile the Java file:

bash
Copy code
javac Leetcode733.java
Run the program (if main method exists):

bash
Copy code
java Leetcode733
💡 Some solution files are class-only implementations (without a main method) since they are designed for LeetCode’s online judge environment.

🧩 Topics Covered
Category	Description
Arrays	Searching, Sorting, Prefix Sum, Sliding Window
Strings	Substrings, Palindromes, Pattern Matching
Dynamic Programming (DP)	Recursion, Memoization, Tabulation
Depth First Search (DFS)	Graph and Grid traversal problems
Breadth First Search (BFS)	Level order traversal, Shortest paths
Hashing	Frequency maps, Sets, and Dictionaries
Recursion & Backtracking	Permutations, Combinations, N-Queens
Binary Tree / BST	Traversals, LCA, Path Sums
Graph	Union-Find, Topological Sort, Connectivity
Math / Bit Manipulation	Prime checks, XOR patterns, Modular arithmetic

🧑‍💻 Author
Nayan Malviya
Software Developer | Java & React Enthusiast

📅 Last Updated: October 2025
🔗 GitHub Profile

<div align="center">
⭐ If you find this repository useful, consider giving it a star! ⭐

</div> ```