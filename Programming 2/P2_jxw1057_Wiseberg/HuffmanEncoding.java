/* Huffman Encoding:
 *   1. Open file and collect data (file I/O)
 *   2. Read through data and collect the different characters and frequencies of each character
 *   3. Build Huffman tree
 *   4. Print encodings as String to deconstruct
 *   Wasn't able to finish/figure out
 *   5. Print encodings and trace huffman tree to decompress
 *   6. Print huffman tree properties
 */

import java.io.*;
import java.util.PriorityQueue;


public class HuffmanEncoding {
    public static void main(String[] args) {
        String encoded = huffmanCoder("/Users/jakewiseberg/Documents/datastruct/Programming 2/src/input.txt", "output.txt");

    }

    public static String huffmanCoder(String inputFileName, String outputFileName) {
        try {
            File in = new File(inputFileName​);
            FileOutputStream fos = new FileOutputStream(outputFileName​);
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(fos));

            
            //Array of all the characters from the input file
            char[] input = textReader(in);

            //256 is the length of the ASCII alphabet so that's as long as the frequency array should be
            int[] freq = new int[256];
            for (int i = 0; i < input.length; i++)
                freq[input[i]]++;

            HuffmanNode root = buildTree(freq);

            String encoded = printTree(root);

            out.writeUTF(encoded);
            
            System.out.println(encoded);
            System.out.println("DONE");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFileName​;
    }

    //This method returns an array of chars that can be analyzed and broken into HuffmanNodes
    //Used a string then broke it into an array so I wouldn't have to deal with initial char array size
    private static char[] textReader(File f) {
        FileInputStream fis = null;
        String str = "";

        try {
            fis = new FileInputStream(f);
            int content;
            while ((content = fis.read()) != -1) {
                //convert to char and add it to the string
                str += (char)content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return str.toCharArray();
    }

    //This method uses the frequency array to create the HuffmanNode elements and build the tree
    private static HuffmanNode buildTree(int[] freq) {
        // initialze priority queue with minimum as first element, again use 256 for ASCII characters
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>();
        for (char i = 0; i < 256; i++)
            if (freq[i] > 0)
                pq.add(new HuffmanNode(i, freq[i], null, null));
        // merge two smallest trees
        while (pq.size() > 1) {
            HuffmanNode left  = pq.peek();
            HuffmanNode right = pq.peek();
            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency, left, right);
            pq.add(parent);
        }
        return pq.peek();
    }
    

    //prints the tree in a readable form to deconstruct
    private static String printTree(HuffmanNode r) {
      if (r.isLeaf()) {
        BinaryStdOut.write(true);
        BinaryStdOut.write(r.ch, 8);
        return;
      }
      BinaryStdOut.write(false);
      printTree(r.left);
      printTree(r.right);
    }
    
}


class HuffmanNode extends Comparable{
    private Character inChar;
    public int frequency;
    public HuffmanNode left, right;

    public HuffmanNode(Character inChar, int frequency, HuffmanNode left, HuffmanNode right) {
        this.inChar = inChar;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public Character getInChar() { return inChar; }
    public boolean isLeaf() { return (left == null && right == null); }
    


}