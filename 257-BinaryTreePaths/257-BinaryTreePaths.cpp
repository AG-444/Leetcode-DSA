// Last updated: 8/28/2025, 9:58:12 AM
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        if (root == nullptr) return paths;
        dfs(root, to_string(root->val), paths);
        return paths;
    }
    
private:
    void dfs(TreeNode* node, string path, vector<string>& paths) {
        if (node->left == nullptr && node->right == nullptr) {
            paths.push_back(path);
            return;
        }
        
        if (node->left != nullptr)
            dfs(node->left, path + "->" + to_string(node->left->val), paths);
        
        if (node->right != nullptr)
            dfs(node->right, path + "->" + to_string(node->right->val), paths);
    }
};
