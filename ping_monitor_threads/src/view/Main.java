package view;

import controller.ThreadPings;

public class Main {
    public static void main(String[] args) {
        
    	ThreadPings tp = new ThreadPings("google.com.br", "google");
    	
    	tp.start();
    	
    }
}