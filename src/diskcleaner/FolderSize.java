
package diskcleaner;
import java.io.*;
public class FolderSize  {
    
    public long getFolderSize(File folder){//method to get size
        
        long length=0;
        File [] files=folder.listFiles();//put all the files in the array files
        int count=files.length;
        for(int i=0; i<count; i++)//This loop counts for all the files in a folder
        {
            if(files[i].isFile()){
                length+=files[i].length();
            }else{
                length+=getFolderSize(files[i]);
            }
        }
        return length; 
    }

   
    public float whenGetFolderSize(String path){//method to convert size to desired units
        
        File folder=new File(path);
        float size=getFolderSize(folder)/1048576;
        return size;
    }}
    
   
    

