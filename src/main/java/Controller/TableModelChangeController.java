/*
 * Controller.TableModelChangeController
 * Create by Bin
 * Date 11/8/23, 2:56 PM
 * Description:
 */

package Controller;

import View.EditSlangView;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TableModelChangeController implements TableModelListener {
    private final EditSlangView currentView;
    public TableModelChangeController(EditSlangView currentView){
        this.currentView=currentView;
    }
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            String value = (String) this.currentView.tableModel.getValueAt(row,column);
            if (!value.isEmpty()){
                this.currentView.editTheSlang(row,column);
            }
            else JOptionPane.showMessageDialog(this.currentView,"Can not empty!!!");
        }
    }
}
