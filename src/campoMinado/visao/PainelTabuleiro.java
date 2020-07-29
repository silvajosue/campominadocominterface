package campoMinado.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import campoMinado.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {

		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

		tabuleiro.paraCada(c -> add(new ButtonCamp(c)));

		tabuleiro.registrarObservador(e -> {
			SwingUtilities.invokeLater(() -> {
				if (e.isGanhou()) {
					JOptionPane.showMessageDialog(this, "Ganhouuuuu!!!!MITOO!!");
				} else {
					JOptionPane.showMessageDialog(this, "Perdeuu MARRECOO!!");
				}
				tabuleiro.reiniciar();

			});
		});

	}

}
