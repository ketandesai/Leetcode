package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
* In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
* A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a
* cardinal direction, then one square in an orthogonal direction.
* Return the minimum number of steps needed to move the knight to the square [x, y].
* It is guaranteed the answer exists.

Example 1:
Input: x = 2, y = 1, Output: 1
Explanation: [0, 0] → [2, 1]

Example 2:
Input: x = 5, y = 5, Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]

Constraints:
|x| + |y| <= 300
*/
public class MinimumKnightMoves {

    /**
     *  BFS
     *  -Use BFS to move from starting point (0,0) to point (X,Y)
     *      - similar: shortest path, shortest distance
     *  -Take abs |x| and |y| to shorten the search space, since board is like a mirror
     *  - bfs: minimum steps, enumerate the possible moves
     *      - move closer to x or y (test 8 possible directions)
     *      - add possible moves in queue
     *  -use visited to cache visited coordinates
     *  time: O(n)
     *  space: O(n)
     *
     */
    public int minKnightMoves(int x, int y) {
        //take absolute value of x and y to shorten the search space
        x = Math.abs(x);
        y = Math.abs(y);
        //base case
        if (x == 1 && y == 1) return 2;

        //8 direction the Knight can move
        int dir[][] = new int[][]{ {-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {1, 2}, {1, -2}, {-1, -2}, {-1, 2} };
        //keep track of visited squares
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        //add x,y,moves
        q.add(new int[]{0,0,0});

        while(!q.isEmpty()) {
            int coord[] = q.poll();
            int px = coord[0];
            int py = coord[1];
            int moves = coord[2];
            if (px == x && py == y) return moves;

            for (int d[] : dir) {
                int dx = px + d[0];
                int dy = py + d[1];

                if (dx > -1 && dx < 300 &&
                    dy > -1 && dy < 300 &&
                    !visited.contains(dx +","+dy) ){
                    visited.add(dx +","+dy);
                    q.add(new int[]{dx, dy, moves + 1});
                }
            }
        }

        return -1;
    }

}

