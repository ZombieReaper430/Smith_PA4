import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

    private Set<String> uniqueWords;

    //Instance method call remove with parameter dateFile
    public void remove (String dataFile) throws FileNotFoundException
    {
        String line;

        uniqueWords = new HashSet<String>();
        Scanner scan =new Scanner(new File(dataFile));

        while(scan.hasNext())
        {

            line = scan.next();
            uniqueWords.add( line );

        }
        scan.close();


    }

    public void Write(String outputFile) throws IOException
    {

        File txt;
        FileWriter fw = null;

        txt = new File(outputFile);


        if(txt.exists()) {

            //Overwrite
            txt.delete();
            txt.createNewFile();

            fw = new FileWriter(txt,true);
            Iterator i = uniqueWords.iterator();

            while(i.hasNext())
            {

                String str=(String)i.next();
                fw.write(str+"\n");

            }
            fw.close();

            System.out.println("Data Written to txt File");

        }
        else
        {
            fw = new FileWriter(txt);
            Iterator i = uniqueWords.iterator();

            while(i.hasNext())
            {

                String str=(String)i.next();
                fw.write(str+"\n");

            }
            fw.close();

            System.out.println("Data Written to txt File");
        }

    }

}