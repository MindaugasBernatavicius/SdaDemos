package cf.mindaugas.sdademos._02_javaadvanced._14_io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class _01_NIO {

    public static void _00_ReadWriteWithNIO(){
        // Writing in NIO
        Path filePath = Paths.get("data2/example.txt");
        Path dir = Paths.get("data2");

        // try {
        //     if (!Files.isDirectory(dir)) Files.createDirectory(Paths.get("data2"));
        //     Files.write(filePath, Arrays.asList("line1", "line2", "line3"));
        //     // Files.write(filePath, Arrays.asList("line1", "line2", "line3"), StandardOpenOption.APPEND);
        // } catch (IOException ex) {
        //     ex.printStackTrace();
        // }

        // Read in NIO
        try {
            List<String> linesReadNew = Files.readAllLines(filePath);
            System.out.println(linesReadNew);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Read in IO (Old)
        File f = new File("data/example.txt");
        List<String> linesRead = new ArrayList<>();
        try {
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) linesRead.add(line);
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }
        System.out.println(linesRead);
    }

    public static void _01_FilesAndPaths() throws IOException {
        Path path = Paths.get("data.txt");
        Path pathToCopy = Paths.get("data_copy.txt");

        Files.delete(path);
        Files.createFile(path);

        Files.write(path, "test data\n".getBytes(), StandardOpenOption.WRITE);
        Files.write(path, "first line\n".getBytes(), StandardOpenOption.APPEND);
        Files.write(path, "second line\n".getBytes(), StandardOpenOption.APPEND);

        for (String line : Files.readAllLines(path))
            System.out.println(line);

        Files.copy(path, pathToCopy);
        Files.delete(pathToCopy);
    }

    public static void _02_NioBuffersAndChannelsSimple() throws IOException {
        var file = new RandomAccessFile("user.txt", "r");
        var fileChannel = file.getChannel();
        var byteBuffer = ByteBuffer.allocate(512);
        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining())
                System.out.print((char) byteBuffer.get());
            byteBuffer.clear();
        }
        file.close();
    }

    public static void _03_NonBlockingIO_NotFinished() throws IOException, InterruptedException {
        // language level needs to be >11
        Path filePath = Path.of("data2/example.txt");
        var fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ);
        var buffer = ByteBuffer.allocate(8); // Create a buffer to hold the read data

        fileChannel.read(buffer, 0, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                buffer.flip();
                byte[] data = new byte[buffer.limit()];
                buffer.get(data);
                System.out.println("Read data: " + new String(data));
                buffer.clear();
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });

        // Other tasks can be performed concurrently while the read operation is in progress

        // Wait for the read operation to complete (in a real-world scenario, you would typically use callbacks or other mechanisms to handle asynchronous operations)
        Thread.sleep(1000);

        fileChannel.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // _00_ReadWriteWithNIO();
        _02_NioBuffersAndChannelsSimple();
        _03_NonBlockingIO_NotFinished();
    }
}
