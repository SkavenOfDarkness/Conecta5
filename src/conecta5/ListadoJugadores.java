/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import static conecta5.Conecta5.nombreJugador1;
import static conecta5.Conecta5.nombreJugador2;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Javier
 */
public class ListadoJugadores extends JFrame{
    JList list;
	String[] listaNombres = { "Javier", "Luis", "Antonio", "yellow",
			"white" };
	Color[] listColorValues = { Color.BLACK, Color.BLUE, Color.GREEN,
			Color.YELLOW, Color.WHITE };
	Container contentpane;
	public ListadoJugadores() {
		super("List Source Demo");
		contentpane = getContentPane();
		contentpane.setLayout(new FlowLayout());
		list = new JList(listaNombres);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentpane.add(new JScrollPane(list));
		list.addListSelectionListener(new ListSelectionListener() {
                        @Override
			public void valueChanged(ListSelectionEvent e) {
                                Conecta5.nombreJugador1 = list.toString();
                                       
        
				contentpane.setBackground(listColorValues[list
						.getSelectedIndex()]);
			}
		});
		setSize(250, 250);
		setVisible(true);
	}
        /*	public static void main(String[] args) {
        Conecta5 test = new Conecta5();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }*/
    
}
/*
ESTO DENTRO DE DONDE QUEREMOS LLAMARLO

ListadoJugadores test = new ListadoJugadores();
test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


*/