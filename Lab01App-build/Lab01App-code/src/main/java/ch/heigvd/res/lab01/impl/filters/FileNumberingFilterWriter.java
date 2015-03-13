package ch.heigvd.res.lab01.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

  private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());
  private static int compteur = 1;

  public FileNumberingFilterWriter(Writer out) {
    super(out);
  }

   
  
  @Override
  public void write(String str, int off, int len) throws IOException {
      
     String resultat = compteur + "\t";
      for (int i = 0; i < str.length(); i++){
          if(str.charAt(i) == '\n'){   
              resultat = resultat + "\n" + ++compteur + "\t";
              //compteur++;
          }
          else
              resultat = resultat + str.charAt(i);
          
      }
      

      super.write(resultat, off+2, len);
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }
  
  
  @Override
   public void write(String str) throws IOException {
      
      String resultat = compteur + "\t";
      for (int i = 0; i < str.length(); i++){
          if(str.charAt(i) == '\n'){   
              resultat = resultat + "\n";// + ++compteur + "\t";
              ++compteur;
          }
          else
              resultat = resultat + str.charAt(i);
          
      }
      
      super.write(resultat);
     
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
      String str = new String (cbuf);
      String resultat = compteur + "\t";
      for (int i = 0; i < str.length(); i++){
          if(str.charAt(i) == '\n'){   
              resultat = resultat + "\n";// + ++compteur + "\t";
              compteur++;
          }
          else
              resultat = resultat + str.charAt(i);
          
      }
      super.write(resultat, off+2, len);
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

  @Override
  
  public void write(int c) throws IOException {
     
      String resultat = compteur + "\t";
      
          if((char)c == '\n'){   
              resultat = resultat + "\n" ;//+ ++compteur + "\t";
              compteur++;
          }
          else
              resultat = resultat + (char)c;
          super.write(resultat);
          
      //throw new UnsupportedOperationException("The student has not implemented this method yet.");
      }
  

}
