/*
 * The simple program will print the files and subdirectories of a folder in Windows    
 */

package fileanddirectoryprinter;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Edward Cooney
 */
public class FileAndDirectoryPrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Get parent folder name from user
        String parent = getParent();
    }
    
    /**
     * Get the parent directory the user would like to start printing from
     * @return the parent directory 
     */
    private static String getParent() {
        String parent;
        parent = JOptionPane.showInputDialog(
                "Enter the location of the parent folder:");
        
        while (!isValid(parent)) {
            JOptionPane.showMessageDialog(null, "That directory cannot be found.  Please check your input:\n" + parent);
            
            parent = JOptionPane.showInputDialog(
                "Enter the location of the parent folder:");
        }    
        return parent;
    }
    
    /**
     * Check that the user defined parent directory exists.
     * @param parent The user defined parent directory
     * @return TRUE if the directory exists, otherwise FALSE
     */
    private static boolean isValid(String parent) {
        File file = new File(parent);
        return file.exists();
    }
    
}
