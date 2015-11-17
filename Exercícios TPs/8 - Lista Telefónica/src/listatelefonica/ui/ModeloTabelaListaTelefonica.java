package listatelefonica.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import listatelefonica.model.Telefone;

public class ModeloTabelaListaTelefonica extends AbstractTableModel {

    private static String[] nomesColunas = {"Titular", "Telefone"};
    private List<Telefone> listaTelefonica;

    public ModeloTabelaListaTelefonica() {
        this.listaTelefonica = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return this.listaTelefonica.size();
    }

    @Override
    public int getColumnCount() {
        return ModeloTabelaListaTelefonica.nomesColunas.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public String getColumnName(int colunaIndex) {
        return nomesColunas[colunaIndex];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String nomeColuna = getColumnName(columnIndex);
        return nomeColuna.equalsIgnoreCase(
                ModeloTabelaListaTelefonica.nomesColunas[0]) ? 
                this.listaTelefonica.get(rowIndex).getTitular() :
                this.listaTelefonica.get(rowIndex).getNumero();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        String nomeColuna = getColumnName(columnIndex);
        if (nomeColuna.equalsIgnoreCase(ModeloTabelaListaTelefonica.nomesColunas[0])) {
            this.listaTelefonica.get(rowIndex).setTitular((String) value);
        } else {
            this.listaTelefonica.get(rowIndex).setNumero((Integer) value);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addRow(Telefone telefone) {
        int rowCount = getRowCount();
        this.listaTelefonica.add(telefone);
        fireTableRowsInserted(rowCount, rowCount);
    }
    
    public void removeRow(Telefone telefone){
        int row = this.listaTelefonica.indexOf(telefone);
        this.listaTelefonica.remove(telefone);
        fireTableRowsDeleted(row, row);
    }

    public Telefone[] getArray(){
        return this.listaTelefonica.toArray(new Telefone[this.listaTelefonica.size()]);
    } 

}
