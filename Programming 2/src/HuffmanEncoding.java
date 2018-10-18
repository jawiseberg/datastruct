/* Huffman Encoding:
 *   1. Open file and collect data (file I/O)
 *   2. Read through data and collect the different characters and frequencies of each character
 *   3. Build Huffman tree
 *   4. Print encodings
 *   5. Money
 */

import java.io.*;


class HuffmanNode {
  private Character inChar;
  private int frequency;
  private HuffmanNode left, right;
  
  public HuffmanNode(Character inChar, int frequency, HuffmanNode left, HuffmanNode right) {
    this.inChar = inChar;
    this.frequency = frequency;
    this.left = left;
    this.right = right;
  }
  
  
}

public class HuffmanEncoding {
  
  public static void main(String[] args) {
    FileReader in = null;
    FileWriter out = null;
    try {
      in = new FileReader("input.txt");
      out = new FileWriter("output.txt");
      int c;
      while ((c = in.read()) != -1) {
        out.write(c);
      }
    } finally {
      if (in != null)
        in.close();
      if (out != null)
        out.close();
    }
  }
  
  /*
  public static String huffmanCoder(​String​ inputFileName​,​ ​String​ outputFileName​) {
    return "";
  }
  
  public static HuffmanNode textReader(String inputFileName) {
    
  }
  
  public static HuffmanNode mergeNodes(HuffmanNode n) {
    
  }
  
  public static HuffmanNode buildTree() {
    
  }
  */
  
}

