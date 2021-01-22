
package com.shutl.UI;

import com.shutl.controller.QuoteController;
import com.shutl.model.Quote;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import com.seaglasslookandfeel.*;



public class deliveryForm extends JFrame implements ActionListener {
    // this is the  the class varibles that ere asked to be included for the form
    private JComboBox vehicle;
    private JLabel Lvehicle;
    private JLabel Ldelivery_Postcode;
    private JLabel Lpickup_Postcode;
    private JTextField delivery_Postcode;
    private JTextField pickup_Postcode;
    // these are other instance varibles
    private JLabel title;
    private JLabel subtitle;
    // this will be usefull to reset thing s
    private JButton reset;
    private JButton sub;
    private JTextArea tout;

    private Container c;

    // combo needs to have a list of vehicles

    private String vehicles[]={"Bicycle","Motorbike", "Parcel Car","Small Van", "Large Van" };


    public deliveryForm() {

        try
        {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        setTitle("Delivery form ");
        setBounds(200,100,600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        c=getContentPane();

        c.setLayout(null);

        title = new JLabel("Jude's Delivery Service");
        title.setFont(new Font("Arial", Font.PLAIN, 20 ));
        title.setSize(300,30);
        title.setLocation(200,20);
        c.add(title);

        subtitle = new JLabel("Please fill in the form below for a quote");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 12 ));
        subtitle.setSize(300,30);
        subtitle.setLocation(200,45);
        c.add(subtitle);

        Ldelivery_Postcode=new JLabel("Delivery Postcode");
        Ldelivery_Postcode.setFont(new Font("Arial", Font.PLAIN, 12 ));
        Ldelivery_Postcode.setSize(100,20);
        Ldelivery_Postcode.setLocation(100,150);
        c.add(Ldelivery_Postcode);
        //this is where the user will put in the the delivery postcode
        delivery_Postcode=new JTextField();
        delivery_Postcode.setFont(new Font("Arial", Font.PLAIN, 15 ));
        delivery_Postcode.setSize(130,20);
        delivery_Postcode.setLocation(250,150);
        c.add(delivery_Postcode);

        Lpickup_Postcode=new JLabel("Pickup  Postcode");
        Lpickup_Postcode.setFont(new Font("Arial", Font.PLAIN, 12 ));
        Lpickup_Postcode.setSize(100,20);
        Lpickup_Postcode.setLocation(100,100);
        c.add(Lpickup_Postcode);
        //this is where the user will put in the pickup postcode
        pickup_Postcode=new JTextField();
        pickup_Postcode.setFont(new Font("Arial", Font.PLAIN, 15 ));
        pickup_Postcode.setSize(130,20);
        pickup_Postcode.setLocation(250,100);
        c.add(pickup_Postcode);

        Lvehicle= new JLabel("Vehicle Type");
        Lvehicle.setFont(new Font("Arial", Font.PLAIN, 12 ));
        Lvehicle.setSize(100,20);
        Lvehicle.setLocation(100,200);
        c.add(Lvehicle);
        //this is where the user will put in the pickup postcode
        //
        vehicle=new JComboBox(vehicles);
        vehicle.setFont(new Font("Arial", Font.PLAIN, 12 ));
        vehicle.setSize(130,20);
        vehicle.setLocation(200,200);
        c.add(vehicle);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 250);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 250);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 150);
        tout.setLocation(150, 300);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        setVisible(true);



    }

    /*ObjectMapper objectMapper = new ObjectMapper();

    public MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
    }*/


    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==sub){
            String data
                    ="Delivery Postcode"+delivery_Postcode.getText()+"\n"
                    +"Pickup Postcode"+pickup_Postcode.getText()+"\n";
            String data1= "Vehicle :"+(String)vehicle.getSelectedItem()+"\n";

            Quote myQuote = new Quote();

            myQuote.setPickupPostcode(pickup_Postcode.getText());
            myQuote.setDeliveryPostcode(delivery_Postcode.getText());
            myQuote.setVehicle((String)vehicle.getSelectedItem());



            QuoteController myQuoteContr = new QuoteController();

            Quote findPrice = myQuoteContr.quote(myQuote);


            tout.setText("The Quote for this delivery is £" + String.valueOf(findPrice.getPrice()));
            tout.setEditable(false);





        }
        else if (e.getSource() == reset) {
            String def = "";
            delivery_Postcode.setText(def);

            pickup_Postcode.setText(def);

            tout.setText(def);

            vehicle.setSelectedIndex(0);

        }
    }
}
