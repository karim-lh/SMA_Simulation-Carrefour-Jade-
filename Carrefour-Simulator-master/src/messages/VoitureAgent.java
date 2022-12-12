package messages;

import java.awt.Point;
import java.awt.Rectangle;

import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;

public class VoitureAgent extends Agent {

    private GuiCarreffour frame;
    private JLabel lbl;
    private boolean etat;
    private static int p = 1;

    //public static String message;
    @Override
    protected void setup() {


        Object[] args = getArguments();

        frame = (GuiCarreffour) args[0];
        lbl = new JLabel();
        lbl.setBounds((int) args[1], (int) args[2], (int) args[3], (int) args[4]);
        lbl.setIcon(new ImageIcon(getClass().getResource((String) args[5]))); // NOI18N

        frame.getContentPane().add(lbl);

        ParallelBehaviour comportementparallele = new ParallelBehaviour(ParallelBehaviour.WHEN_ANY);


        comportementparallele.addSubBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    if (msg.getContent().equals("RED")) {

                        System.out.println("RED");
                        etat = false;
                    } else if (msg.getContent().equals("GREEN")) {
                        System.out.println("GREEN");
                        ;
                        etat = true;
                    }

                } else block();

            }
        });

        comportementparallele.addSubBehaviour(new TickerBehaviour(this, 100) {
            @Override
            protected void onTick() {


                if (((int) args[6] == 1) && (int) args[7] == 1) {

                    if (etat) lbl.setLocation(lbl.getLocation().x + 10, lbl.getLocation().y);
                    if (!etat && lbl.getX() <= 300) {
                        lbl.setLocation(lbl.getLocation().x + 10, lbl.getLocation().y);
                    }
                    if (!etat && lbl.getX() >= 350) {
                        lbl.setLocation(lbl.getLocation().x + 10, lbl.getLocation().y);
                    }
                }

                if (((int) args[6] == 1) && (int) args[7] == 0) {

                    if (etat) lbl.setLocation(lbl.getLocation().x - 10, lbl.getLocation().y);
                    if (!etat && lbl.getX() <= 650) {
                        lbl.setLocation(lbl.getLocation().x - 10, lbl.getLocation().y);
                    }
                    if (!etat && lbl.getX() >= 710) {
                        lbl.setLocation(lbl.getLocation().x - 10, lbl.getLocation().y);
                    }
                }


                if (((int) args[6] == 0) && (int) args[7] == 0) {
                    if ((p % 3 == 0) && lbl.getLocation().getY() == 360) {
                        //	lbl.setLocation(lbl.getLocation().x+10,lbl.getLocation().y);
                        lbl.setBounds(lbl.getX() + 10, lbl.getY(), 120, 60);
                        lbl.setIcon(new ImageIcon(getClass().getResource("/images/coche2Copie.png")));

                    } else {
                        if (etat) {

                            lbl.setLocation(lbl.getLocation().x, lbl.getLocation().y - 10);

                        }
                        if (!etat && lbl.getY() <= 300) {

                            lbl.setLocation(lbl.getLocation().x, lbl.getLocation().y - 10);
                        }
                        if (!etat && lbl.getY() >= 450) {


                            lbl.setLocation(lbl.getLocation().x, lbl.getLocation().y - 10);
                        }
                    }

                }

                if (((int) args[6] == 0) && (int) args[7] == 1) {

                    if (etat) lbl.setLocation(lbl.getLocation().x, lbl.getLocation().y + 10);
                    if (!etat && lbl.getY() <= 160) {
                        lbl.setLocation(lbl.getLocation().x, lbl.getLocation().y + 10);
                    }
                    if (!etat && lbl.getY() >= 210) {
                        lbl.setLocation(lbl.getLocation().x, lbl.getLocation().y + 10);
                    }
                }


            }
        });


        comportementparallele.addSubBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {


                if (((int) args[6] == 0) && (int) args[7] == 0) {
                    if (lbl.getY() <= -1) {

                        //Agent Voiture verticle 2
                        lbl.setBounds(620, 580, 60, 120);
                        p++;
                    } else if (lbl.getX() >= 920) {
                        lbl.setBounds(620, 580, 60, 120);
                        lbl.setIcon(new ImageIcon(getClass().getResource((String) args[5])));
                        p++;
                    }
                } else if (((int) args[6] == 0) && (int) args[7] == 1) {
                    if (lbl.getY() >= 590) {
                        lbl.setBounds(470, 0, 60, 120);
                    }
                } else if (((int) args[6] == 1) && (int) args[7] == 1) {
                    if (lbl.getX() >= 920) {
                        lbl.setBounds(10, 360, 120, 60);
                    }
                } else if (((int) args[6] == 1) && (int) args[7] == 0) {
                    if (lbl.getX() <= 0) {
                        lbl.setBounds(910, 290, 120, 60);
                    }
                } else block();

            }
        });

        addBehaviour(comportementparallele);
    }


}
