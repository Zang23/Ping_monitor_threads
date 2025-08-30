package controller;

public class ThreadPings extends Thread {
    private String site;
    private String nomeSite;
    
    public ThreadPings(String site, String nomeSite) {
        this.site = site;
        this.nomeSite = nomeSite;
    }
    
    public void run() {
    	PingController pc = new PingController();
    	
    	pc.executaComando(site, nomeSite);    		
    	
    }
    
    
    
}