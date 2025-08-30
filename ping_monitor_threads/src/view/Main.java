package view;

import controller.PingController;
import controller.ThreadPings;

public class Main {
    public static void main(String[] args) {
        
    	PingController pc = new PingController();
    	
    	if(pc.isLinux()) {
    		ThreadPings tp1 = new ThreadPings("google.com.br", "google");	
    		ThreadPings tp2 = new ThreadPings("terra.com.br", "terra");
    		ThreadPings tp3 = new ThreadPings("uol.com.br", "uol");
    		
    		tp1.start();
    		tp2.start();
    		tp3.start();
    		
    	}else {
    		System.err.println("Esse sistema operacional não suporta essa aplicação.");
    	}
    	
    	
    	
    }
}