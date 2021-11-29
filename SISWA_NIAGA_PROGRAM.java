import java.awt.*;
import java.awt.event.*;

public class SISWA_NIAGA_PROGRAM extends WindowAdapter implements ActionListener{
	Frame f; 
	Double h1,h2,h3;
	Checkbox checkBox1,checkBox2,checkBox3;
	Label display1,display2,display3,display4,card;
	TextField txtQuantity, txtCardnumber;
	final List l1;
	SISWA_NIAGA_PROGRAM(){
		f = new Frame();
		//SET FR0M ATTRIBUTES
		f.setTitle("SIswa Niaga Programe");
		f.setSize(800,500);
		f.setVisible(true);
		f.setLayout(null);
		// adding  WindowListener to the frame  
		f.addWindowListener (this);
		//label select item
		Label item = new Label("Select Item : ");
		item.setFont(new Font("Dialog", Font.PLAIN, 14));
		item.setBounds(32, 47, 81, 22);
		f.add(item);
		//checkboxgroup 
        CheckboxGroup cbg = new CheckboxGroup();  
        checkBox1 = new Checkbox("Crunchy Combo 1=Rm16.79", cbg, false);    
        checkBox1.setBounds(113,35, 179,50);    
        checkBox2 = new Checkbox("Crunchy Combo 2=Rm17.40", cbg, false);    
        checkBox2.setBounds(300,35, 179,50);    
        checkBox3 = new Checkbox("Hot variety pack=Rm29.29", cbg, false);    
        checkBox3.setBounds(495,35, 179,50);
        f.add(checkBox1);    
        f.add(checkBox2);      
        f.add(checkBox3);
		//label for quantity,payment,card number
        Label quantity = new Label("Quantity: ");
		quantity.setFont(new Font("Dialog", Font.PLAIN, 14));
		quantity.setBounds(32, 200, 81, 22);
		f.add(quantity);
		Label payment = new Label("Payment Method: ");
		payment.setFont(new Font("Dialog", Font.PLAIN, 14));
		payment.setBounds(32, 240, 112, 22);
		f.add(payment);
		card = new Label("Card number: ");
		card.setFont(new Font("Dialog", Font.PLAIN, 14));
		card.setBounds(32, 280, 100, 22);
		f.add(card);
		//input for quantity, card number
		txtQuantity = new TextField("");
		txtQuantity.setBounds(200,200,146,22);
		f.add(txtQuantity);
		txtCardnumber = new TextField("");
		txtCardnumber.setBounds(200,280,146,22);
		f.add(txtCardnumber);
		//list for payment method
		l1 = new List(3); 
		l1.setBounds(200,240,146,22);
		l1.add("Molcard");    
        l1.add("Paypal");    
        l1.add("Master");
		f.add(l1);
		//create button
		Button b = new Button("DONE");
		b.setBounds(167,370,80,30);
		b.addActionListener(this);//add listener to button
		f.add(b);
		//create display the output after clicking button
		display1 = new Label("");
		display1.setBounds(423, 200, 300, 22);
		display2= new Label("");
		display2.setBounds(423, 240, 200, 30);
		display3 = new Label("");
		display3.setBounds(423, 280, 200,30);
		display4 = new Label("");
		display4.setBounds(423,320, 400, 30);
		f.add(display1);
		f.add(display2);
		f.add(display3);
		f.add(display4);
	}
	
	public void windowClosing (WindowEvent e) { 
		//override the windows
		f.dispose();    
	}
	public void actionPerformed(ActionEvent e){ 
		//event for button
        float amount=0;  
        String msg="";
        if(checkBox1.getState()){  
            amount+=16.79;
            msg="Crunchy combo 1 Rm16.79";
        }  
        if(checkBox2.getState()){  
            amount+=17.40; 
            msg="Crunchy combo 2 Rm17.40";
        }  
        if(checkBox3.getState()){  
            amount+=29.29;
            msg="Hot variety pack Rm29.29";
        }    
        display1.setText("The item you choose is "+msg);
        display2.setText("Quantity: "+txtQuantity.getText());
        int i = Integer.parseInt(txtQuantity.getText());
        display3.setText("The amount is: Rm"+String.valueOf(amount*i));
        display4.setText(" charged to "+l1.getSelectedItem()+" card number: "+txtCardnumber.getText());
    }  
	
	public static void main(String[]args) {
		new SISWA_NIAGA_PROGRAM();
	}
}
