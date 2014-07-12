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
        
        // Print a list of directories from parent to end. Initial indent is 0.
        printDirectoryTree(parent, 0);
        
    }
    
    /**
     * Get the parent directory the user would like to start printing from
     * @return the parent directory 
     */
    private static String getParent() {
        String parent;
        parent = JOptionPane.showInputDialog(
                "Enter the location of the parent folder:");
        
        // Test for valid path
        while (!isValidPath(parent)) {
            JOptionPane.showMessageDialog(null, "That directory cannot be found.\n"
                    + "Please check your input:\n" + parent, "Invalid Entry", 
                    JOptionPane.ERROR_MESSAGE);
            
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
    private static boolean isValidPath(String parent) {
        File file = new File(parent);
        return file.exists();
    }
    
    private static void printDirectoryTree(String parent, int indent) {
        File file = new File(parent);
      
        // If the file is a directory, print the neccesary indent, then the 
        // directory name, then call the function on the rest of the list of files
        if (file.isDirectory()) {
            for (int i = 0; i < indent; i++) {
                System.out.print(' ');          
            }
            
            System.out.println(file.getName());
            File[] files = file.listFiles();
            for (File afile : files) {
                printDirectoryTree(afile.getPath(), indent+2);
            }
        }
    }
}
