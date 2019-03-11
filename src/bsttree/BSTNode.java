/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsttree;

/**
 *
 * @author csc190
 */
public class BSTNode {
    protected int val;
    protected BSTNode left=null, right=null;
    
    public BSTNode(int v){
        this.val = v;
    }
    public void insert(int v){
        if(this.val==v) return;
        if(v<this.val){
            if(this.left==null){
                this.left = new BSTNode(v);
            }else{
                this.left.insert(v);
            }
        }else{//>
            if(this.right ==null){
                this.right = new BSTNode(v);
            }else{
                this.right.insert(v);
            }
        }
    }
    public static BSTNode buildTree(int [] arr){
        if(arr==null || arr.length==0) return null;
        BSTNode root = new BSTNode(arr[0]);
        for(int i=1; i<arr.length; i++){
            root.insert(arr[i]);
        }
        return root;
    }
    
    @Override
    public boolean equals(Object n){
        BSTNode other= (BSTNode) n;
        if(n==null) return false;
        if(other.val!=this.val) return false;
        boolean leftOK = this.left==null? other.left==null: this.left.equals(other.left);
        boolean rightOK = this.right==null? other.right==null: this.right.equals(other.right);
        return leftOK ==rightOK;
    }
}
