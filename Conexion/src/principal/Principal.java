package principal;

import vista.Formulario;

public class Principal {
    public static void main(String[] args) {
        //Instancia del formulario
        Formulario formulario1 = new Formulario();
        formulario1.setVisible(true);
        formulario1.setResizable(false);
        formulario1.setLocationRelativeTo(null);
    }
}
