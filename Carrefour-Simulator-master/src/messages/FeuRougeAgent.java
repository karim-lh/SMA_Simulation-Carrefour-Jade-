package messages;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class FeuRougeAgent extends Agent {
    // public static String m;
    private GuiCarreffour frame;
    private JLabel lbl;

    @Override

    protected void setup() {

        Object[] args = getArguments();

        frame = (GuiCarreffour) args[0];
        lbl = new JLabel();


        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource((String) args[5]))); // NOI18N
        frame.add(lbl);
        lbl.setBounds((int) args[1], (int) args[2], (int) args[3], (int) args[4]);


        frame.getContentPane().add(lbl, BorderLayout.SOUTH);


        addBehaviour(new OneShotBehaviour() {

            @Override
            public void action() {
                // TODO Auto-generated method stub

                if ((int) args[7] == 0) {
                    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                    msg.setContent("GREEN");
                    lbl.setIcon(new ImageIcon(getClass().getResource((String) args[6]))); // NOI18N

                    msg.addReceiver(new AID((String) args[8], AID.ISLOCALNAME));

                    send(msg);
                }
            }
        });

        addBehaviour(new TickerBehaviour(this, 5000) {

            public int p = (int) args[7];

            @Override
            protected void onTick() {
                p++;
                // TODO Auto-generated method stub


                System.out.println(p + "\n");
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                if ((p % 2) == 0) {
                    msg.setContent("RED");
                    lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource((String) args[5]))); // NOI18N


                } else {
                    msg.setContent("GREEN");

                    lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource((String) args[6]))); // NOI18N
                }
                msg.addReceiver(new AID((String) args[8], AID.ISLOCALNAME));
                // msg.addReceiver(new AID("VoitureNoire",AID.ISLOCALNAME));

                send(msg);

            }

        });


    }


}
