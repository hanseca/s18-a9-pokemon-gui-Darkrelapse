/**
 * Pokemon class for a binary search tree.
 * 
 * @author Hansen Cabanero
 * @since 4/22/18
 */
public class PokeTree {

  /** Root node instance variable. */
   private PokeNode root = null;

  /** No parameter constructor. */
   public PokeTree() {
      // root already initialized
   }
   
  /**
   * Adds an item to the tree.
   * Non-recursive wrapper method
   * 
   * @param p The object to be added
   */
   public void add(Pokemon p) {
   // calls a recursive, private method
   // cannot get direct access to the root outside the class
      root = add(root, p);
   }
  
  /**
   * Recusively adds an item to the tree.
   * 
   * @param node The root of the tree/subtree
   * @param p The object to be added
   * @return The current node
   */
   private PokeNode add(PokeNode node, Pokemon p) {
   // base case: empty tree or end of a leaf
      if (node == null) {
         return new PokeNode(p, 1, null, null);
      } else if (node.getPokemon().compareTo(p) == 0) {
         node.increaseNumCaught();
         return node;
      }

      // recursive case: if item is less than current node
      // then move to left child node
      else if (p.compareTo(node.getPokemon()) < 0) {
      // set the node's left child to the
      // left subtree with item added
         node.setLChild(this.add(node.getLChild(), p));
         return node;
      }
      // recursive case: if item is greater than current node
      // then traverse to right child node
      else {
      // set the node's right child to the
      // right subtree with item added
         node.setRChild(this.add(node.getRChild(), p));
         return node;
      }
   }

  /**
   * called automatically by println/print method.
   * 
   * @return an inorder String of the tree
   */
   public String toString() {
      return this.inOrder(root);
   }

  /**
   * inOrder display of nodes, with newline between each node.
   * 
   * @param node The root of the tree/subtree
   * @return an inorder String of the tree
   */
   private String inOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes 
            + this.inOrder(node.getLChild());
         displayNodes = displayNodes + node.toString() + "\n";
         displayNodes = displayNodes 
            + this.inOrder(node.getRChild());
      }
      return displayNodes;
   }

  /**
   * Pre-Order traversal of tree.
   * 
   * @return String representation of preOrder
   */
   public String preOrder() {
      return this.preOrder(root);
   }

  /**
   * Recursive preOrder traversal of tree.
   * 
   * @param node The root of the tree/subtree
   * @return a preOrder String of the tree
   */
   private String preOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes + node.toString() + "\n";
         displayNodes = displayNodes
            + this.preOrder(node.getLChild());
         displayNodes = displayNodes 
            + this.preOrder(node.getRChild());
      }
      return displayNodes;
   }

  /**
   * Post-Order traversal of tree.
   * 
   * @return a postOrder String of the tree
   */
   public String postOrder() {
      return this.postOrder(root);
   }

  /**
   * Recursive postOrder traversal of tree.
   * To display nodes, with newline between each node
   * 
   * @param node The root of the tree/subtree
   * @return a post-Order String of the tree
   */
   private String postOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes + this.postOrder(node.getLChild());
         displayNodes = displayNodes + this.postOrder(node.getRChild());
         displayNodes = displayNodes + node + "\n";
      }
      return displayNodes;
   }

  /**
   * gets an item from the tree with the same search key.
   * 
   * @param p An object containing the search key
   * @return the data item in the tree with matching key.
   */
   public Pokemon get(Pokemon p) {
   // cannot get direct access to the root outside the class
      return this.get(root, p);
   }

  /**
   * Recursive methog to get an item from the tree.
   * 
   * @param node The root of the tree/subtree
   * @param p An object storing the key to get.
   * @return the data item in tree with matching key.
   * @throws TreeException if item not found
   */
   private Pokemon get(PokeNode node, Pokemon p) {
   // if not found, throw exception
      if (node == null) {
         throw new TreeException("Item not found!");
      } else {
      // if the search key matches, return the item's address
         if (p.compareTo(node.getPokemon()) == 0) {
            return node.getPokemon();
         }
         // if the search key of the searchKey is less than the node,
         // then search the left subtree
         else if (p.compareTo(node.getPokemon()) < 0) {
            return this.get(node.getLChild(), p);
         }
         // if the search key of the searchKey is greater than the node,
         // then search the right subtree
         else {
            return this.get(node.getRChild(), p);
         }
      }
   }

  /**
   * Removes an item from the tree.
   * 
   * @param p An object storing the key to remove.
   */
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   }

  /**
   * Recursively removes an item from the tree.   
   * 
   * @param node The root of the tree/subtree
   * @param p An object storing only the key to remove.
   * @return root of current subtree.
   * @throws TreeException if item not found in tree.
   */
   private PokeNode remove(PokeNode node, Pokemon p) {
   // if item not found, throw exception
      if (node == null) {
         throw new TreeException("Item not found!");
      } else if (node.getPokemon().compareTo(p) == 0) {
         if (node.getNumCaught() > 0) {
            node.decreaseNumCaught();
            if (node.getNumCaught() == 0) {
               node = this.remove(node);
               return node;
            }
         }
         return node;
      }
      // if search key is less than node's search key,
      // continue to left subtree
      else if (p.compareTo(node.getPokemon()) < 0) {
         node.setLChild(this.remove(node.getLChild(), p));
         return node;
      }
      // if search key is greater than node's search key,
      // continue to right subtree
      else if (p.compareTo(node.getPokemon()) > 0) {
         node.setRChild(this.remove(node.getRChild(), p));
         return node;
      }
      // found node containing object with same search key,
      // so delete it
      else {
      // call private method remove
         node = this.remove(node);
         return node;
      }
   }

  /**
   * Helper method that takes a node out of tree.
   * 
   * @param node The node to remove
   * @return The node that replaces removed node or null.
   */
   private PokeNode remove(PokeNode node) {
   // if node is a leaf,return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes
      else {
      // get next Smaller Item, which is Largest Item in Left Subtree
      // The next Smaller Item is stored at the rightmost node in the left
      // subtree.
         Pokemon largestItemInLeftSubtree = 
             this.getItemWithLargestSearchKey(node.getLChild());
      // replace the node's item with this item
         node.setData(largestItemInLeftSubtree);
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }

  /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return The data item with largest key
   */
   private Pokemon getItemWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node.getPokemon();
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
   
   /**
   * method to print out tree.
   */
   public void printPokeTree() {
      printPokeTree(root);
   }
   
   /**
   * recursive method to print tree.
   * @param node the item in the tree
   */
   private void printPokeTree(PokeNode node) {
      if (node != null) {
         printPokeTree(node.getLChild());
         System.out.println("" + node.getPokemon().toString() 
             + "\nCaught: " + node.getNumCaught() + "\n\n");
         printPokeTree(node.getRChild());
      }
   }
} // end of class

