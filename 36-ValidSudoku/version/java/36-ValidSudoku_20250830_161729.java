// Last updated: 8/30/2025, 4:17:29 PM
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
        HashMap<Character,Integer> map3x31 = new HashMap<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                map3x31.put(board[i][j],map3x31.getOrDefault(board[i][j],0)+1);
                if(map3x31.get(board[i][j])>1){
                    matCheck[0] = false;
                }
            }
        }

        // i=0 to 3; j= 3 to 6; m. no 2
        HashMap<Character,Integer> map3x32 = new HashMap<>();
        for(int i=0;i<3;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                map3x32.put(board[i][j],map3x32.getOrDefault(board[i][j],0)+1);
                if(map3x32.get(board[i][j])>1){
                    matCheck[1] = false;
                }
            }
        }

        //i = 0 to 3; j= 6 to 9; m. no 3
        HashMap<Character,Integer> map3x33 = new HashMap<>();
        for(int i=0;i<3;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                map3x33.put(board[i][j],map3x33.getOrDefault(board[i][j],0)+1);
                if(map3x33.get(board[i][j])>1){
                    matCheck[2] = false;
                }
            }
        }

        //i = 3 to 6; j= 0 to 3; m. no. 4
        HashMap<Character,Integer> map3x34 = new HashMap<>();
        for(int i=3;i<6;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                map3x34.put(board[i][j],map3x34.getOrDefault(board[i][j],0)+1);
                if(map3x34.get(board[i][j])>1){
                    matCheck[3] = false;
                }
            }
        }

        HashMap<Character,Integer> map3x35 = new HashMap<>();
        for(int i=3;i<6;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                map3x35.put(board[i][j],map3x35.getOrDefault(board[i][j],0)+1);
                if(map3x35.get(board[i][j])>1){
                    matCheck[4] = false;
                }
            }
        }
        HashMap<Character,Integer> map3x36 = new HashMap<>();
        for(int i=3;i<6;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                map3x36.put(board[i][j],map3x36.getOrDefault(board[i][j],0)+1);
                if(map3x36.get(board[i][j])>1){
                    matCheck[5] = false;
                }
            }
        }
        HashMap<Character,Integer> map3x37 = new HashMap<>();
        for(int i=6;i<9;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='.') continue;
                map3x37.put(board[i][j],map3x37.getOrDefault(board[i][j],0)+1);
                if(map3x37.get(board[i][j])>1){
                    matCheck[6] = false;
                }
            }
        }
        HashMap<Character,Integer> map3x38 = new HashMap<>();
        for(int i=6;i<9;i++){
            for(int j=3;j<6;j++){
                if(board[i][j]=='.') continue;
                map3x38.put(board[i][j],map3x38.getOrDefault(board[i][j],0)+1);
                if(map3x38.get(board[i][j])>1){
                    matCheck[7] = false;
                }
            }
        }
        HashMap<Character,Integer> map3x39 = new HashMap<>();
        for(int i=6;i<9;i++){
            for(int j=6;j<9;j++){
                if(board[i][j]=='.') continue;
                map3x39.put(board[i][j],map3x39.getOrDefault(board[i][j],0)+1);
                if(map3x39.get(board[i][j])>1){
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