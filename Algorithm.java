package com.cbs.look;

public class Algorithm {
    int[][] judge={{-1,-1,-1,0,1,1,1,0},{-1,0,1,1,1,0,-1,-1}};
    public int neighbor_count(int x,int y,int [][]array){
        int cnt=0;
        for(int i=0;i<8;i++){
            int dx=x+judge[0][i];
            int dy=y+judge[1][i];
            if(dx>=0&&dy>=0&&dx<array.length&&dy<array[0].length)cnt+=array[dx][dy];
        }
        return cnt;
    }

    public int[][] evolve(int[][] array){//单步演化
        int x=array.length;
        int y=array[0].length;
        int [][]count=new int[x][y];
        for(int i=0;i< array.length;i++) {
            for (int j = 0; j < array[0].length; j++) {
                count[i][j]=neighbor_count(i,j,array);
            }
        }
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                switch (count[i][j]){
                    case 2:continue;
                    case 3:array[i][j]=1;break;
                    default:array[i][j]=0;break;
                }
            }
        }
        return array;
    }
}
