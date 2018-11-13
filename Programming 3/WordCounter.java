import java.io.*;

public class WordCounter {
  
  public static void main(String[] args) {
    
  }
  
  public static void wordCount(String inputFileName, String outputFileName) throws IOException {
    FileInputStream in = null;
    FileOutputStream out = null;
    
    try {
      
      in = new FileInputStream(inputFileName);
      out = new FileOutputStream(outputFileName);
      
      
      
    } finally {
      if (in != null) { in.close(); }
      if (out != null) { out.close(); }
    }
  }
  
}