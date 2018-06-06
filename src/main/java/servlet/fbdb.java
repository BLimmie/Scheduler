package servlet;

public class fbdb {
    private String python;

    public fbdb() {
        this.python = "python";
    }

    public fbdb(String python) {
        this.python = python;
    }

    public void pull(String filename, String nodestring) {
        Runtime rt = Runtime.getRuntime();
        String tempstr = "python jsonupdate ";
        tempstr = tempstr + filename + " ";
        tempstr = tempstr + "pull ";
        tempstr = tempstr + nodestring;
        try {
            Process pr = rt.exec(tempstr);
        } catch (Exception e) {
        }
    }

    public void push(String filename, String nodestring) {
        Runtime rt = Runtime.getRuntime();
        String tempstr = "python jsonupdate ";
        tempstr = tempstr + filename + " ";
        tempstr = tempstr + "push ";
        tempstr = tempstr + nodestring;
        try {
            Process pr = rt.exec(tempstr);
        } catch (Exception e) {
        }
    }

}

/*
import java.util.concurrent.TimeUnit

String localpath = "./temp_12345"
String fbdbpath = "Course cs48"

#read
fbdb().pull(localpath, fbdbpath)
//wait
Course cs48;
TimeUnit.SECONDS.sleep(1);
JsonIo (localpath, Course.class).read(cs48)

#write
JsonIo (localpath, Course.class).write(cs48);
fbdb().push(localpath, fbdbpath);
*/