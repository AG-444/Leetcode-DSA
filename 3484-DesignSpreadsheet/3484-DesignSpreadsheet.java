// Last updated: 9/19/2025, 10:17:02 AM
class Spreadsheet {
    List<Integer>[] spreadSheet = new ArrayList[26];
    public Spreadsheet(int rows) {
        for (int i = 0; i < 26; i++) {
            spreadSheet[i] = new ArrayList<>(Collections.nCopies(rows, 0));
        }
    }
    
    public void setCell(String cell, int value) {
        int col = Character.toLowerCase(cell.charAt(0)) - 'a';
        int row = Integer.parseInt(cell.substring(1));
        spreadSheet[col].set(row-1,value);
    }
    public void resetCell(String cell) {
        int col = Character.toLowerCase(cell.charAt(0)) - 'a';
        int row = Integer.parseInt(cell.substring(1));
        spreadSheet[col].set(row-1,0);
    }
    
    public int getValue(String formula) {
        String exp = formula.substring(1);
        String[] ops = exp.split("\\+");
        if(Character.isLetter(ops[0].charAt(0)) && Character.isLetter(ops[1].charAt(0))){
            int col1 = Character.toLowerCase(ops[0].charAt(0)) - 'a';
            int row1 = Integer.parseInt(ops[0].substring(1)) - 1;
            int col2 = Character.toLowerCase(ops[1].charAt(0)) - 'a';
            int row2 = Integer.parseInt(ops[1].substring(1)) - 1;

            return spreadSheet[col1].get(row1) + spreadSheet[col2].get(row2);
        }
        else if(Character.isLetter(ops[0].charAt(0))){
            int col1 = Character.toLowerCase(ops[0].charAt(0)) - 'a';
            int row1 = Integer.parseInt(ops[0].substring(1)) - 1;
            return spreadSheet[col1].get(row1) + Integer.parseInt(ops[1]);
        }
        else if(Character.isLetter(ops[1].charAt(0))){
            int col1 = Character.toLowerCase(ops[1].charAt(0)) - 'a';
            int row1 = Integer.parseInt(ops[1].substring(1)) - 1;
            return spreadSheet[col1].get(row1)+Integer.parseInt(ops[0]);
        }
        
        return Integer.parseInt(ops[0])+Integer.parseInt(ops[1]);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */