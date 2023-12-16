package models.views.inboxtable;

import models.interfaces.Emailable;
import models.objects.Email;
import utils.DatabaseUtils;
import utils.UColors;

import javax.security.auth.Subject;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.Objects;

/**
 * This class extends {@link JButton} to create a button with rounded corners. The button will be used as a component
 * in list inbox table.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class MailButton extends JButton {
    // These attributes store the icons for the button.
    public static Icon mailRead = new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull
        (MailButton.class.getResource("/images/mailRead.png"))).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    public static Icon mailUnread = new ImageIcon(new javax.swing.ImageIcon(Objects.requireNonNull
        (MailButton.class.getResource("/images/mailUnread.png"))).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
    private boolean mousePressed;
    private boolean isRead = false;
    
    public MailButton() {
        setUnread();

        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
            }
        });
    }

    public MailButton(Emailable email) {
        this.isRead = email.getRead();
        // Sets the (internal) button text
        setText(String.format("<html>%s<br>%s<br>%s",
            email.getSubject(),
            DatabaseUtils.getFirstLastName(email.getSenderUuid()),
            email.getFormattedDate() + " " + email.getFormattedTime()
        ));

        checkRead();
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(3, 3, 3, 3));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                mousePressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mousePressed = false;
            }
        });
    }

    // Icon setters: read & unread

    public void setRead() {
        setIcon(mailRead);
    }

    public void setUnread() {
        setIcon(mailUnread);
    }

    public void checkRead() {
        if (isRead) {
            setRead();
        } else {
            setUnread();
        }
    }

    public String getText() {
        return super.getText();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Gets the width and height of the button.
        int width = getWidth();
        int height = getHeight();

        // Centers the x and y coordinates within available spaces. (top left)
        int x = (getWidth() - width) / 2;
        int y = 0;

        g2.setColor(UColors.BEIGE.toColor());

        // Fills using the rounded corner class.
        g2.fill(new RoundedCorners(x, y, width, height, 10));

        // Dispose the graphics.
        g2.dispose();

        // Renew the graphics.
        super.paintComponent(g);
    }

    /**
     * This class is used to create a rounded corner using {@link Float}. This class works by creating a path
     * that is used to draw the rounded corner.
     *
     * @see Float
     * */

    static class RoundedCorners extends Path2D.Float {
        /**
         * Constructor for the class, this constructor creates a rounded corner using the given parameters.
         *
         * @param x the x coordinate of the upper-left corner of the arc to be drawn.
         * @param y the y coordinate of the upper-left corner of the arc to be drawn.
         * @param width the width of the arc to be drawn.
         * @param height the height of the arc to be drawn.
         * @param arc the arc size of the arc to be drawn.
         * */
        public RoundedCorners(float x, float y, float width, float height, float arc) {
            // Moves the painter to the starting point
            moveTo(x + arc, y);

            // Drawing corner on top left edge
            lineTo(x + width - arc, y);
            quadTo(x + width, y, x + width, y + arc);

            // Drawing corner on top right edge
            lineTo(x + width, y + height - arc);
            quadTo(x + width, y + height, x + width - arc, y + height);

            // Drawing corner on bottom right edge
            lineTo(x + arc, y + height);
            quadTo(x, y + height, x, y + height - arc);

            // Drawing corner on bottom left edge
            lineTo(x, y + arc);
            quadTo(x, y, x + arc, y);

            // Completes the drawing of the path.
            closePath();
        }
    }
}
