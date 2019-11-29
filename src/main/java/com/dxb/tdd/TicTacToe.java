package com.dxb.tdd;

import java.io.Serializable;

/**
 * User: dxb
 * Date: 2019/11/25
 * Description: When I wrote this, only God and I understood what I was doing. Now, God only knows
 */
public class TicTacToe implements Serializable {
    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
    }

    private void checkAxis(int axis) {
        if (axis > 3 || axis < 1) {
            throw new RuntimeException(String.format("{} is outside board!", axis));
        }
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied!");
        }
        board[x - 1][y - 1] = 'x';
    }
}
