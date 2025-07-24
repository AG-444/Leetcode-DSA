class Solution {
public:
    bool reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;

            if (tx > ty) {
                if (ty > sy)
                    tx %= ty;
                else  // ty == sy: we can only reduce tx by multiples of ty
                    return (tx - sx) % ty == 0;
            } else {
                if (tx > sx)
                    ty %= tx;
                else  // tx == sx: reduce ty by multiples of tx
                    return (ty - sy) % tx == 0;
            }
        }
        return false;
    }
};
