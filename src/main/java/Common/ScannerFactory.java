//Student ID: cjw220005
//Name: Christopher Wiratman
package Common;
import java.util.Scanner;


public abstract class ScannerFactory {

    //Creates Scanner instance
    private static Scanner _scannerObject; 
    
    //Returns Scanner instance to be in scope of the program
    //it's called in
    //If scanner instance does not exist it makes
    //a new one
    public static Scanner GetScannerInstance()
    {
        if(_scannerObject == null)
        {
            _scannerObject = new Scanner(System.in); 
        }

        return _scannerObject;
    }   
    
    public static void CloseScannerInstance()
    {
        _scannerObject.close();
        _scannerObject = null; 
    } 
}