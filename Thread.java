
package javaapplication2;

/**
 *
 * @author ykota
 */
//public class Thread {
 
     public class thread1 extends Thread {
    //To create producer and consumer as threads
        //Shared variable
        public static int x = 0;//checks if all lines are read                                      
        public static String line; //holds lines from file
        public static int j = 0;//variable to switch between threads based upon its value

        public thread1(String threadName) {     //Constuctor
            super(threadName);      //Call to constructor of Thread class
        }

        public void run() {

            while (x != -1)
            {
                if (Thread.currentThread().getName().contains("Reader")) {
                    if (x != -1&&j==0)
                    {
                   j=1;
                    String fileName = "c:/name.txt";


                    try {
                        // FileReader reads text files in the default encoding.
                        FileReader fileReader =
                                new FileReader(fileName);

                        // Always wrap FileReader in BufferedReader.
                        BufferedReader bufferedReader =
                                new BufferedReader(fileReader);

                        for (int check = 0; check <= x; check++) {

                            line = bufferedReader.readLine();
                        }
                        if (line == null) {
                            x = -1;
                        } else {
                            System.out.println(line);

                            x++;
                        }


                        // Always close files.
                        bufferedReader.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println(
                                "Unable to open file '"
                                + fileName + "'");
                    } catch (IOException ex) {
                        System.out.println(
                                "Error reading file '"
                                + fileName + "'");
                        // Or we could just do this: 
                        // ex.printStackTrace();

                    }
                    }

                    yield();
                } 
                else if (Thread.currentThread().getName().contains("writer")) {
    if (x != -1 && line != null&&j==1)
    {
                    j=0;

                    String fileName = "c:/name.txt";

                    try {
                        // Assume default encoding.
                        FileWriter fileWriter =
                                new FileWriter(fileName, true);

                        // Always wrap FileWriter in BufferedWriter.
                        BufferedWriter bufferedWriter =
                                new BufferedWriter(fileWriter);

                        // Note that write() does not automatically
                        // append a newline character.
                        bufferedWriter.write(line);
                        bufferedWriter.newLine();
                        System.out.println("y");
                        // Always close files.
                        bufferedWriter.close();
                    } catch (IOException ex) {
                        System.out.println(
                                "Error writing to file '"
                                + fileName + "'");
                        // Or we could just do this:
                        // ex.printStackTrace();
                    }
    }     
                    Thread.yield();
                }
                else{}
            }
        }

        public static void main(String[] args) {

            thread1 p = new thread1("Reader");
            thread1 c = new thread1("writer");

            p.start();
            c.start();


        }
    }


//}
