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
    		double soma = 0;
    		while(linha != null) {
    			if(linha.contains("time=")) {
    				String[] vetPing = linha.split(" ");
    				String[] vetTempo = vetPing[vetPing.length-2].split("=");
    				System.out.println("Site: " + nomeSite + " - Tempo ping: " + vetTempo[1]);
    				
    				soma += Double.parseDouble(vetTempo[1]);
    				
    			}
    			
    			linha = buffer.readLine();
    		}
    		double media = soma / 10;
    		System.out.println("Média " + nomeSite + ": " + media + "ms");
    		
    	}catch(Exception e ) {
    		System.err.println(e.getMessage());
    	}

    }
    
    public boolean isLinux() {
    	return System.getProperty("os.name").toLowerCase().contains("linux");
    }
    
   
}