package messages;

 

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

 




import org.omg.CORBA.Bounds;

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Main {
	
	private GuiCarreffour frame;
	
public Main() throws StaleProxyException {
	// TODO Auto-generated constructor stub
	frame = new GuiCarreffour();
	 
	
	
	
	// R�cup�ration du conteneur (Main Container) en cours d'execution de Jade					
	Runtime rt = Runtime.instance();
	 
	// Cr�ation du profil par d�fault
		ProfileImpl p = new ProfileImpl(false);
	 AgentContainer container =rt.createAgentContainer(p); // get a container controller for creating new agents
	
	 
	 
	 
	 
	//Agent Voiture verticle 1
	AgentController AgentVoitureV1=null;		
	Object[] argsVV1 = {frame,620, 580, 60, 120,"/images/coche2.png",0,0,container};
	AgentVoitureV1 = container.createNewAgent("VoitureV1", "messages.VoitureAgent",argsVV1);
	AgentVoitureV1.start();
	

	//Agent Voiture verticle 2
	AgentController AgentVoitureV2=null;		
	Object[] argsVV2 = {frame,470, 0, 60, 120,"/images/orange-racing-car-top-view-104989.png",0,1,container};
	AgentVoitureV2 = container.createNewAgent("VoitureV2", "messages.VoitureAgent",argsVV2);
	AgentVoitureV2.start();
	
	//Agent Voiture horizontal 1
	AgentController AgentVoitureH1=null;		
	Object[] argsVH1 = {frame,910, 290, 120, 60,"/images/Car_Tovgp_Red_2h6349.png",1,0,container};
	AgentVoitureH1 = container.createNewAgent("VoitureH1", "messages.VoitureAgent",argsVH1);
	AgentVoitureH1.start();

	
	//Agent Voiture horizontal 2
	AgentController AgentVoitureH2=null;		
	Object[] argsVH2 = {frame,10, 360, 120, 60,"/images/racing-car-303766_640.png",1,1,container};
	AgentVoitureH2 = container.createNewAgent("VoitureH2", "messages.VoitureAgent",argsVH2);
	AgentVoitureH2.start();
	

	//Agent Feu Rouge vertical 1
	AgentController AgentFeuV1=null;		
	Object[] argsV1 = {frame,680,430,30,60,"/images/RRSans_titre.png","/images/VVSans_titre.png",0,"VoitureV1"};
	AgentFeuV1 = container.createNewAgent("FeuRougeV1", "messages.FeuRougeAgent",argsV1);		
	AgentFeuV1.start();
	
	 
	//Agent Feu Rouge vertical 2
	AgentController AgentFeuV2=null;		
	Object[] argsV2 = {frame,415, 225, 30, 60,"/images/RRSans_titre.png","/images/VVSans_titre.png",0,"VoitureV2"};
	AgentFeuV2 = container.createNewAgent("FeuRougeV2", "messages.FeuRougeAgent",argsV2);		
	AgentFeuV2.start();
	
	//Agent Feu Rouge horizontal 1
	AgentController AgentFeuH1=null;		
	Object[] argsH1 = {frame,680, 260, 60, 30,"/images/RRSans_titre-Copie.png","/images/VVSans_titre-Copie.png",1,"VoitureH1"};
	AgentFeuH1 = container.createNewAgent("FeuRougeH1", "messages.FeuRougeAgent",argsH1);		
	AgentFeuH1.start();
	
	//Agent Feu Rouge horizontal 2
	AgentController AgentFeuH2=null;		
	Object[] argsH2 = {frame,388, 430, 60, 30,"/images/RRSans_titre-Copie.png","/images/VVSans_titre-Copie.png",1,"VoitureH2"};
	AgentFeuH2 = container.createNewAgent("FeuRougeH2", "messages.FeuRougeAgent",argsH2);		
	AgentFeuH2.start();
	
	
}

	public static void main(String[] args) throws StaleProxyException {
		// TODO Auto-generated method stub
		
		Main window = new Main();
		window.frame.setVisible(true);
	}


	

}
