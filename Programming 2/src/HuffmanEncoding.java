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
    public int frequency;
    public HuffmanNode left, right;

    public HuffmanNode(Character inChar, int frequency, HuffmanNode left, HuffmanNode right) {
        this.inChar = inChar;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public Character getInChar() { return inChar; }


}

public class HuffmanEncoding {
    public static void main(String[] args) {
        huffmanCoder("input.txt", "output.txt");
    }

    public static String huffmanCoder(​String inputFileName​,​ ​String outputFileName​) {
        try {
            File in = new File(inputFileName​);
            FileWriter out = new FileWriter(outputFileName​);

            //Array of all the characters from the input file
            char[] input = textReader(in);

            //256 is the length of the ASCII alphabet so that's as long as the frequency array should be
            int[] freq = new int[256];
            for (int i = 0; i < input.length; i++)
                freq[input[i]]++;

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
        for (int i=0; i<freq; i++)

    }

    private static HuffmanNode mergeNodes(HuffmanNode n) {}



  
}

