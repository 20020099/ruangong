package com.cbs.look;

public class SurvivalRate extends Thread {

    public static double N=0;
    public static double rate;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<GameLook.array.length;i++){
                for(int j=0;j<GameLook.array[0].length;j++){
                    if(GameLook.array[i][j]==1){
                        N++;
                    }
                }
            }
            rate = N*100/(900.0);
            GameLook.rate.setText("存活率："+String.format("%.2f", rate)+"%");
            N = 0;
        }
    }
}
