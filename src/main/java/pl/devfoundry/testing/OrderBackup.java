package pl.devfoundry.testing;

import java.io.*;

class OrderBackup {

    private Writer writer;

    Writer getWriter() {
        return writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    void backupOrder(Order order) throws IOException {
        writer.append(order.toString());
    }

    void closeFile() throws IOException {
        writer.close();
    }

}
