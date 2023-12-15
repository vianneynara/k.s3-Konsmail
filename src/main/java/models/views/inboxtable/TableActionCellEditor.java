package models.views.inboxtable;

import javax.swing.*;
import java.awt.*;

/**
 * This class is an extended class of {@link javax.swing.DefaultCellEditor}. This class is used to set the wholke row
 * background color when it is being selected. This class is used in {@link InboxTable}.
 *
 * @author <a href="https://github.com/vianneynara">Nara</a>
 * */

public class TableActionCellEditor extends DefaultCellEditor {
    
    private CellsActionable event;

    public TableActionCellEditor(CellsActionable event) {
        super(new JCheckBox());
        this.event = event;
    }   
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();
        action.initEvents(event, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
}
