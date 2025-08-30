// Last updated: 8/30/2025, 4:19:38 PM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rowCheck = true;
        for(int i=0;i<9;i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);
                if(map.get(board[i][j])>1){
                    rowCheck = false;
                }
            }
        }

        boolean colCheck = true;

        for(int i=0;i<9;i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=0;j<9;j++){
                if(board[j][i]=='.') continue;
                map.put(board[j][i],map.getOrDefault(board[j][i],0)+1);
                if(map.get(board[j][i])>1){
                    colCheck = false;
                }
            }
        }

        boolean matCheck[] = new boolean[9];
        for(int i=0;i<9;i++){
            matCheck[i] = true;
        }
        //i=0 to 3; j=0 to 3 ; m no. 1
        HashMap<Character,Integer> map3x3 = new HashMap<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[0] = false;
                }
            }
        }

        map3x3.clear();
        for(int i=0;i<3;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[1] = false;
                }
            }
        }

        //i = 0 to 3; j= 6 to 9; m. no 3
        map3x3.clear();
        for(int i=0;i<3;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[2] = false;
                }
            }
        }

        //i = 3 to 6; j= 0 to 3; m. no. 4        
        map3x3.clear();
        for(int i=3;i<6;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[3] = false;
                }
            }
        }

        map3x3.clear();
        for(int i=3;i<6;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[4] = false;
                }
            }
        }
        map3x3.clear();
        for(int i=3;i<6;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[5] = false;
                }
            }
        }
        map3x3.clear();
        for(int i=6;i<9;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[6] = false;
                }
            }
        }
        map3x3.clear();
        for(int i=6;i<9;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[7] = false;
                }
            }
        }
        map3x3.clear();
        for(int i=6;i<9;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                map3x3.put(board[i][j],map3x3.getOrDefault(board[i][j],0)+1);
                if(map3x3.get(board[i][j])>1){
                    matCheck[8] = false;
                }
            }
        }

        boolean ans = true;
        for(int i=0;i<9;i++){
            ans = ans&&matCheck[i];
        }
        if(ans && rowCheck && colCheck) return true;
        return false;
        
    }
}