public void insert(Node root, Node toInsert) {
  //checks to see if the toInsert value is less than the roots value
  if (toInsert.value < root.value) {
    //if value is less than and the left part isn't null, recursively call method using the left binary search subtree
    if (root.left != null)
      insert(root.left, toInsert);
    //if value is less than and the left part is null, then insert
    else 
      root.left = toInsert;
  }
  
  //checks to see if the toInsert value is greater than the roots value
  else if (toInsertvalue > root.value) {
    //if value is greater than and the right part isn't null, recursively call method using the right binary search subtree
    if (root.right != null)
      insert(root.right, toInsert);
    // if the value is less than and the right part is null, then insert
    else
      node.right = toInsert;
  }
  
  //using an else if instead of else prevents the opportunity for doubly inserting values which would break the binary search trees definition
}

//note, changed 'Node new' to 'Node toInsert' because new is a keyword for java and it wouldn't compile