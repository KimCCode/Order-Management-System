package ordering_system.View.Sidebar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import ordering_system.View.CardArea.CardArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideBarItem extends JLabel {
    private String text;
    private CardArea cardArea;
    private String relatedCard;
    private String imageLocation;

    public SideBarItem(String text, CardArea cardArea, String relatedCard, String imageLocation) {
        this.text = text;
        this.cardArea = cardArea;
        this.relatedCard = relatedCard;
        this.imageLocation = imageLocation;
        initialiseSideBarItem();
    }

    private void initialiseSideBarItem() {
        setText(text);
        setIcon(new ImageIcon(getClass().getResource(imageLocation)));
        setIconTextGap(10);
        setFont(new Font("Arial", Font.BOLD, 18));
        setPreferredSize(new Dimension(160, 40));
        setMinimumSize(new Dimension(160, 40));
        setMaximumSize(new Dimension(160, 40));
        setForeground(Color.WHITE);
        setAlignmentX(CENTER_ALIGNMENT);
        setHorizontalAlignment(LEFT);
        setBorder(new EmptyBorder(0, 10, 0, 0));
        initialiseMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardArea.switchToCard(relatedCard);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setOpaque(true);
                setBackground(new Color(0x133a94));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(false);
                setBackground(null);
            }
        });
    }

    public void initialiseMouseListener(MouseListener l) {
        addMouseListener(l);
    }
}
