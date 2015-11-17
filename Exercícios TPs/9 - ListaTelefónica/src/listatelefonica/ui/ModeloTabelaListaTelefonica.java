package listatelefonica.ui;

import javax.swing.table.AbstractTableModel;
import listatelefonica.model.ListaTelefonica;
import listatelefonica.model.Telefone;

public class ModeloTabelaListaTelefonica extends AbstractTableModel {

    private static String[] nomesColunas = {"Titular", "Telefone"};
    private ListaTelefonica listaTelefonica;

    public ModeloTabelaListaTelefonica(ListaTelefonica listaTelefonica) {
        this.listaTelefonica = listaTelefonica;
    }

    @Override
    public int getRowCount() {
        return this.listaTelefonica.tamanho();
    }

    @Override
    public int getColumnCount() {
        return ModeloTabelaListaTelefonica.nomesColunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return ModeloTabelaListaTelefonica.nomesColunas[columnIndex];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String nomeColuna = getColumnName(columnIndex);
        return nomeColuna.equalsIgnoreCase(
                ModeloTabelaListaTelefonica.nomesColunas[0])
                        ? this.listaTelefonica.getTelefone(rowIndex).getTitular()
                        : this.listaTelefonica.getTelefone(rowIndex).getNumero();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        String nomeColuna = getColumnName(columnIndex);
        if (nomeColuna.equalsIgnoreCase(ModeloTabelaListaTelefonica.nomesColunas[0])) {
            this.listaTelefonica.getTelefone(rowIndex).setTitular((String) value);
        } else {
            this.listaTelefonica.getTelefone(rowIndex).setNumero((Integer) value);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public boolean addRow(Telefone telefone) {
        int rowCount = getRowCount();
        boolean telefoneAdicionado = this.listaTelefonica.adicionarTelefone(telefone);
        if (telefoneAdicionado) {
            fireTableRowsInserted(rowCount, rowCount);
        }
        return telefoneAdicionado;
    }
    
    public boolean removeRow(Telefone telefone){
        int row = this.listaTelefonica.obterIndiceDeTelefone(telefone);
        boolean telefoneRemovido = this.listaTelefonica.removerTelefone(telefone);
        if(telefoneRemovido)
            fireTableRowsDeleted(row, row);
        return telefoneRemovido;
    }
    
    public int addRows(ListaTelefonica listaTelefonica) {
        int rowCount = getRowCount();
        int totalTelefonesAdicionados
                = this.listaTelefonica.adicionarListaTelefonica(listaTelefonica);
        if (totalTelefonesAdicionados != 0) {
            fireTableRowsInserted(rowCount, rowCount + totalTelefonesAdicionados - 1);
        }
        return totalTelefonesAdicionados;
    }

}
