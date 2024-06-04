/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabalho;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import trabalho.view.TelaInicial;

/**
 *
 * @author lucas.wojahn
 */
public class Trabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            NeoApi api = new NeoApi();
            NeoFeed data = api.fetchNeoData("2024-05-20", "2024-05-21");
            System.out.println(data.toString());
            System.out.println("Objetos detectados: "+data.getCount());
            
            SwingUtilities.invokeLater(() -> {
                TelaInicial dash = new TelaInicial();
                dash.setVisible(true);
            });
            
        } catch (IOException ex) {
            Logger.getLogger(Trabalho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

