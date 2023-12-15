package models.views.inboxtable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * This class is an extended class of {@link DefaultTableCellRenderer} that is used to render the action buttons in
 * the table. Specifically changing the button's background color when it is being selected.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class TableActionCellRender extends DefaultTableCellRenderer {

    public TableActionCellRender() {
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.LEADING);
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        PanelAction action = new PanelAction();
        
        if (!isSelected && (row % 2 == 0)) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(component.getBackground());
        }
        return action;
    }
    
    
}
