package leetCode._37;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 暴力破解
    public void solveSudoku(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        int colNum = board.length;
        int rowNum = board[0].length;
        char[][] back = new char[colNum][rowNum];
        int recall = 0;
        int i = 0;
        int j = 0;
        for (; i < board.length; i++) {
            char[] row = board[i];
            j %= 9;
            for (; j < row.length; j++) {
                if (i < 0 || j < 0) {
                    break;
                }
                int bas = 1;

                char c = board[i][j];
                // 获取当前单元格的数据，判断是否有数据，
                // 判断这个数据是否为原始数据，
                // 如果当前有数据且原始单元没数据，说明现在要进行回溯,k的取值要比当前大
                if (recall != 0) {
                    bas = (c - '0') + 1;
                }

                // 当前单元有数据，原始单元无数据，且没有回溯，存一份原始数据
                if (c != '.' && back[i][j] == 0 && recall == 0) {
                    back[i][j] = c;
                }
                // 当前单元有数据，原始单元无数据，清空当前数据
                if (c != '.' && back[i][j] == 0) {
                    board[i][j] = '.';
                }

                // 当前单元有数据，原始单元有数据，继续回溯上级
                if (c != '.' && (back[i][j] != 0 || c == '9') && recall != 0) {
                    if (j > 0) {
                        // 大于第一列的数据，往前回溯
                        j -= 2;
                    }else {
                        // 小于第一列的数据，向上一排回溯
                        j = 8;
                        i -= 2;
                        break;
                    }
                    continue;
                }

                recall = 0;
                // 如果当前单元没数据，继续探测
                if (board[i][j] == '.') {
                    // 循环判断1-9是否能放入当前位置
                    boolean flag = false;
                    for (int k = bas; k < 10; k++) {
                        if (checkNum(board, i, j, k)) {
                            if (k == c - 48) {
                                continue;
                            }
                            board[i][j] = (char) (k + 48);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        // 不能放1-9 进行回溯
                        recall = c - '0';
                        if (j > 0) {
                            // 大于第一列的数据，往前回溯
                            j -= 2;
                        }else {
                            // 小于第一列的数据，向上一排回溯
                            i -= 2;
                            j = 8;
                            break;
                        }
                    }
                    // 已经放入了一个数据，不做操作
                }
            }
        }
    }

    // 检查当前数字能否准入
    private boolean checkNum(char[][] board, int i, int j, int k) {
        k += 48;
        for (int i1 = 0; i1 < 9; i1++) {
            if (board[i1][j] == k) {
                return false;
            }
        }
        for (int j1 = 0; j1 < 9; j1++) {
            if (board[i][j1] == k) {
                return false;
            }
        }
        int x = (i / 3) * 3 ;
        int y = (j / 3) * 3;
        for (int l = x; l < x + 3; l++) {
            for (int m = y; m < y + 3; m++) {
                if (board[l][m] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}
