package Chapter7;
//
//public class EightQueen {
//    public static void main(String[] args)
//    {
//        int[][] borad=new int[8][8];
//        int[][] queen=new int[8][2];
//        int num=0,i,j;//将空设置为0 有皇后的地方放置为1
//        for(i=0;i<8;i++)
//            for(j=0;j<8;j++)
//                borad[i][j]=0;
//        i=0;j=0;
//        for(;i < 8;i++)//之后从第二行第二列开始
//        {
//            for (; j < 8; j++)
//            {
//                if(isOk(queen,i,j,num))//如果满足的话 进行下一行搜索
//                {
//
//                    queen[num][0]=i;
//                    queen[num][1]=j;
//                    num++;
//                    borad[i][j]=1;
//                    break;
//                }
//                else if(j==7)//当遍历到最后一个还是不满足的情况下 返回上一行
//                {
//                        num--;
//                        j = queen[num][1];
//                        i --;
//
//
//                }
//            }
//        }
//        for(i=0;i<8;i++)
//            System.out.println("("+queen[i][0]+","+queen[i][1]+")");
//    }
//
//    public static boolean isOk(int[][] queen,int i,int j,int num)
//    {
//        for(int k=0;k<num;k++)
//        {
//            if(queen[k][0]==i||queen[k][1]==j)
//                return false;
//            if((i-queen[k][0])==(j-queen[k][1]))
//                return false;
//            if((i-queen[k][0])==(queen[k][1]-j))
//                return false;
//        }
//        return true;
//    }
//
//}
public class EightQueen{

    // 皇后/棋盘的个数
    private static final int QUEEN_NUM = 8;

    // 首先定义一个8 * 8 的棋盘
    private static final int[][] Checkerboard = new int[QUEEN_NUM][QUEEN_NUM];

    // 定义一共有多少种放置皇后的算法
    private static int COUNT = 0;

    /**
     * 打印棋盘
     */
    public static final void show() {
        System.out.println("第" + (++COUNT) + "次摆法");
        for (int i = 0; i < QUEEN_NUM; i++) {
            for (int j = 0; j < QUEEN_NUM; j++) {
                System.out.print(Checkerboard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 判断当前位置是否能放置皇后
     *
     * @param
     * @param row
     *            行数
     * @param col
     *            列数
     * @return
     */
    public static final boolean check(int row, int col) {

        // 判断当前位置的上面是否有皇后
        for (int i = row - 1; i >= 0; i--) {
            if (Checkerboard[i][col] == 1)
                return false;
        }

        // 判断左上是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (Checkerboard[i][j] == 1)
                return false;
        }

        // 判断右上是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < QUEEN_NUM; i--, j++) {
            if (Checkerboard[i][j] == 1)
                return false;
        }

        return true;
    }

    /**
     * 从第n行放置皇后
     *
     * @param row
     */
    public static final void play(int row) {
        // 遍历当前行的所有单元格 以列为单元
        for (int i = 0; i < QUEEN_NUM; i++) {
            // 是否能够放置皇后
            if (check(row, i)) {
                Checkerboard[row][i] = 1;

                if (row == QUEEN_NUM - 1) {
                    // 最后行 放置完毕 打印皇后
                    show();
                } else {
                    // 放置下一行
                    play(row + 1);
                }

                //回退到当前步骤，把皇后设置为0
                Checkerboard[row][i] = 0;
            }

        }
    }

    public static void main(String[] args) {
        play(0);
    }
}