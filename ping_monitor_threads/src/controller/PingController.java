package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PingController {
    
    public PingController() {
        super();
    }
    
    public void executaComando(String site, String nomeSite) {
    	
    	StringBuffer sBuffer = new StringBuffer();
    	
    	String[] vetProc = sBuffer.append("ping -4 -c 10 ").append(site).toString().split(" ");
    	
    	try {
    		Process p = Runtime.getRuntime().exec(vetProc);
    		InputStream fluxo = p.getInputStream();
    		InputStreamReader leitor = new InputStreamReader(fluxo);
    		BufferedReader buffer = new BufferedReader(leitor);
    		String linha = buffer.readLine();
    		while(linha != null) {
    			if(linha.contains("time=")) {
    				String[] vetPing = linha.split(" ");
    				for(String i: vetPing) {
    					System.out.println(i);
    				}
    			}
    			
    			linha = buffer.readLine();
    		}
    		
    	}catch(Exception e ) {
    		System.err.println(e.getMessage());
    	}

    }
    
   
}