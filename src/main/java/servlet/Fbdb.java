public class Fbdb {
    private String python;

    public Fbdb() {
        this.python = "python";
    }

    public Fbdb(String python) {
        this.python = python;
    }

    public void pull(String filename, String nodestring) {
        Runtime rt = Runtime.getRuntime();
        String tempstr = "python jsonupdate.py ";
        tempstr = tempstr + filename + " ";
        tempstr = tempstr + "pull ";
        tempstr = tempstr + nodestring;
        try {
            Process pr = rt.exec(tempstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void push(String filename, String nodestring) {
        Runtime rt = Runtime.getRuntime();
        String tempstr = "python jsonupdate.py ";
        tempstr = tempstr + filename + " ";
        tempstr = tempstr + "push ";
        tempstr = tempstr + nodestring;
        try {
            Process pr = rt.exec(tempstr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/*
String localpath = "./temp_12345";
String fbdbpath = "Course cs48";
Fbdb fbdb = new Fbdb();

//read
fbdb.pull(localpath, fbdbpath);
//wait
Course cs48 = new Course();
try {
    TimeUnit.SECONDS.sleep(1);
} catch (Exception e) {
}
JsonIO<Course> jsonio = new JsonIO<Course>(localpath, Course.class);
cs48 = jsonio.read();

//write
new JsonIO(localpath, Course.class).write(cs48);
fbdb.push(localpath, fbdbpath);
*/