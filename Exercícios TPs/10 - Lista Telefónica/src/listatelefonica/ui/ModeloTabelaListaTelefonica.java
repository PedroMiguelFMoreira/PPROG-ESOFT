package listatelefonica.ui;

import javax.swing.JOptionPane;
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
        Telefone[] telefones = this.listaTelefonica.getArray();

        String nomeColuna = getColumnName(columnIndex);
        
        return nomeColuna.equalsIgnoreCase(
                ModeloTabelaListaTelefonica.nomesColunas[0])
                        ? telefones[rowIndex].getTitular()
                        : telefones[rowIndex].getNumero();
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Telefone[] telefones = this.listaTelefonica.getArray();
        
        String nomeColuna = getColumnName(columnIndex);
        
        if (nomeColuna.equalsIgnoreCase(ModeloTabelaListaTelefonica.nomesColunas[0])) {
            telefones[rowIndex].setTitular((String) value);
        } else {
                String titular = telefones[rowIndex].getTitular();
                Telefone alterado = new Telefone(titular, (Integer) value);
                
                if (this.listaTelefonica.getListaTelefonica().get(value) == null) {
                    removeRow(telefones[rowIndex]);
                    addRow(alterado);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Telefone já incluído na lista telefónica!",
                            "Alterar Telefone",
                            JOptionPane.WARNING_MESSAGE);
                }
            
        }
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
        Telefone[] telefones = this.listaTelefonica.getArray();
        
        int row = 0;
        for (int i=0; i<telefones.length; i++) {
            if (telefones[i].equals(telefone)) {
                row = i;
                break;
            }
        }

        boolean telefoneRemovido = this.listaTelefonica.removerTelefone(telefone);
        if(telefoneRemovido) {
            fireTableRowsDeleted(row, row);
        }
        
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
