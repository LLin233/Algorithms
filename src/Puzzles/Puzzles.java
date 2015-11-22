package Puzzles;

/**
 * Created by Le on 2015/11/21.
 */
public class Puzzles {
    /**
     * Nim Game
     * {https://leetcode.com/problems/nim-game/}
     * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
     * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
     * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
     *
     *
     * n∈[1,3]，first move wins
     * n == 4，second move will be turned into n∈[1,3]，first move loses。
     * n∈[5,7], first move wins by taking [1,3] stone, turn into n == 4
     * n == 8, no matter how first move moves, next round will go into n∈[5,7], first move loses
     * -> n % 4 != 0, first move wins, otherwise it loses.
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
