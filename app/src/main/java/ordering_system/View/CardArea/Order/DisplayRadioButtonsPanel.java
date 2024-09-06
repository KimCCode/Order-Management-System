package ordering_system.View.CardArea.Order;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DisplayRadioButtonsPanel extends JPanel {
    ButtonGroup group;

    public DisplayRadioButtonsPanel(String[] options) {
        initialisePanel();
        initialiseRadioButtons(options);
    }
    
    private void initialisePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();
    }

    private void initialiseRadioButtons(String[] options) {
        for (int i = 0; i < options.length; i++) {
            JRadioButton button = new JRadioButton(options[i]);
            add(button);
            group.add(button);
            if (i != options.length - 1) {
                add(Box.createVerticalStrut(20));
            }
        }
    }
}
